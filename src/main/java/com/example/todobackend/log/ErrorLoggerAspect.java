package com.example.todobackend.log;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Aspect
@Slf4j
@Component
public class ErrorLoggerAspect {

    @AfterReturning(pointcut = "@annotation(com.example.todobackend.log.ErrorLogger)", returning = "object")
    private static void log(JoinPoint joinPoint, Object object) throws IllegalAccessException {
        String methodMessage = getMethodMessage(joinPoint);
        Class<?> objectClass = object.getClass();
        Map<String, String> logElements = new HashMap<>();
        Set<String> displayFields = new HashSet<>();
        for (Field field : objectClass.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(ErrorLogger.class)) {
                if (checkIsShowDataEnabled(field)) {
                    logElements.put(getFieldValue(field), String.valueOf(field.get(object)));
                } else {
                    displayFields.add(getFieldValue(field));
                }
            }
        }
        log.error("method message: " + methodMessage);
        log.error("displayed fields: " + String.join(", ", displayFields));
        log.error("displayed fields with data: " + logElements.toString());
    }

    private static String getMethodMessage(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        ErrorLogger aspectLogger = method.getAnnotation(ErrorLogger.class);
        return aspectLogger.value();
    }

    private static String getFieldValue(Field field) {
        String fieldValue = field.getAnnotation(ErrorLogger.class).value();
        return fieldValue.isEmpty() ? field.getName() : fieldValue;
    }

    private static boolean checkIsShowDataEnabled(Field field) {
        return field.getAnnotation(ErrorLogger.class).showData();
    }
}
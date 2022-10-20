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
public class InfoLoggerAspect {


    @AfterReturning(pointcut = "@annotation(com.example.todobackend.log.InfoLogger)", returning = "object")
    private static void log(JoinPoint joinPoint, Object object) throws IllegalAccessException {
        String methodMessage = getMethodMessage(joinPoint);
        Class<?> objectClass = object.getClass();
        Map<String, String> logElements = new HashMap<>();
        Set<String> displayFields = new HashSet<>();
        for (Field field : objectClass.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(InfoLogger.class)) {
                if (checkIsShowDataEnabled(field)) {
                    logElements.put(getFieldValue(field), String.valueOf(field.get(object)));
                } else {
                    displayFields.add(getFieldValue(field));
                }
            }
        }
        log.info("method message: " + methodMessage);
        log.info("displayed fields: " + String.join(", ", displayFields));
        log.info("displayed fields with data: " + logElements.toString());
    }

    private static String getMethodMessage(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        InfoLogger aspectLogger = method.getAnnotation(InfoLogger.class);
        return aspectLogger.value();
    }

    private static String getFieldValue(Field field) {
        String fieldValue = field.getAnnotation(InfoLogger.class).value();
        return fieldValue.isEmpty() ? field.getName() : fieldValue;
    }

    private static boolean checkIsShowDataEnabled(Field field) {
        return field.getAnnotation(InfoLogger.class).showData();
    }
}
package com.example.todobackend.advice;

import com.example.todobackend.log.ErrorLogger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
@Slf4j
public class RestGenericErrorAdvice {
    //En alta generic exception koy farklı hatalar için
    //Runtimeexception yerine farklı bir exceptiondan extend et
    public static final String DEFAULT_ERROR_VIEW = "error";

    @ExceptionHandler(value = Exception.class)
    @ErrorLogger("Bilinmedik bir hatayla karsilasildi")
    @ResponseStatus(HttpStatus.BAD_REQUEST)//
    public ModelAndView
    defaultErrorHandler(HttpServletRequest request, Exception e) throws Exception {

        if (AnnotationUtils.findAnnotation //Tüm anotasyonları gez.
                (e.getClass(), ResponseStatus.class) != null)
            throw e;

        ModelAndView genericError = new ModelAndView();
        genericError.addObject("exception", e);
        genericError.addObject("url", request.getRequestURL());
        genericError.setViewName(DEFAULT_ERROR_VIEW);
        log.error("Error url {}", request.getRequestURL());
        return genericError;
    }
}

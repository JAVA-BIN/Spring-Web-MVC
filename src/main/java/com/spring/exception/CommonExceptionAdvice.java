package com.spring.exception;

import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

@Log4j
// 스프링의 컨트롤러에서 발생하는 예외를 처리하는 존재임을 명시
@ControllerAdvice
public class CommonExceptionAdvice {

    // ExceptionHandler()안에 있는 Exception의 종류를 예외처리 함
    @ExceptionHandler(Exception.class)
    public String except(Exception e, Model model) {
        log.error("Exception ........" + e.getMessage());
        model.addAttribute("exception", e);
        log.error(model);
        return "/sample/error_page";
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handle404(NoHandlerFoundException ex) {
        return "/sample/custom404";
    }
}

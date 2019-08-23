package com.example.shirojwt2.controller;

import com.example.shirojwt2.exception.UnauthorizedException;
import com.example.shirojwt2.pojo.JsonResult;
import org.apache.shiro.authc.AuthenticationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {


    @ExceptionHandler(AuthenticationException.class)
    public JsonResult handle401() {
        return new JsonResult(401, "Unauthorized", null);
    }

}

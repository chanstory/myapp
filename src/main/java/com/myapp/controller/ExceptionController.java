package com.myapp.controller;


import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.advice.exception.AuthenticationEntryPointException;
import com.myapp.common.CommonResult;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/exception")
public class ExceptionController {
 
    @GetMapping(value = "/entrypoint")
    public CommonResult entrypointException() {
        throw new AuthenticationEntryPointException();
    }
    
    @GetMapping(value = "/accessdenied")
    public CommonResult accessdeniedException() throws AccessDeniedException {
        throw new AccessDeniedException("");
    }
}
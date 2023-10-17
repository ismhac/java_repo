package com.example.demo_01.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_01.dtos.AuthenticationRequest;
import com.example.demo_01.dtos.RegisterRequest;
import com.example.demo_01.responses.ResponseHandler;
import com.example.demo_01.services.AuthenticationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<Object> register(@Validated @RequestBody RegisterRequest request) {
        return ResponseHandler.generateResponse(
                HttpStatus.OK,
                "Register successfully",
                authenticationService.register(request));
    }

    @PostMapping("/authentication")
    public ResponseEntity<Object> authenticate(@RequestBody AuthenticationRequest request) {
        return ResponseHandler.generateResponse(
                HttpStatus.OK,
                "Login successfully",
                authenticationService.authentication(request));
    }

}

package com.dbd.duser.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v1/user")
@RestController
public class UserController {

    @GetMapping
    public ResponseEntity<String> get() {
        return ResponseEntity.ok("Hello from User Service");
    }
}

package com.dbd.duser.controller;

import com.dbd.commonlib.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
public class AuthController {

    @GetMapping
    public ResponseEntity<String> generateToken() {
        JwtUtil util = new JwtUtil();
        return ResponseEntity.ok(util.generateToken());
    }
}

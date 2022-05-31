package com.dbd.resource.controller;

import com.dbd.resource.feign.DbdUserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequestMapping("/v1/resource")
@RestController
public class ResourceController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DbdUserFeignClient userFeignClient;

//    @GetMapping
//    public ResponseEntity<String> get() {
//        String fromUser = restTemplate.getForObject("http://dbd-user/v1/user", String.class);
//        System.out.println("____________________" + fromUser);
//        return ResponseEntity.ok("Hello from Resource Service");
//    }

    @GetMapping
    public ResponseEntity<String> get(@RequestHeader("username") String username) {
        String fromUser = userFeignClient.getUser().getBody();
        System.out.println("++++++++++++++++++++" + username);
        System.out.println("____________________" + fromUser);
        return ResponseEntity.ok("Hello from Resource Service");
    }
}

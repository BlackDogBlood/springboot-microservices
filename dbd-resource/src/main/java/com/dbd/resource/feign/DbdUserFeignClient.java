package com.dbd.resource.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "dbd-user")
public interface DbdUserFeignClient {

    @GetMapping("/v1/user")
    ResponseEntity<String> getUser();
}

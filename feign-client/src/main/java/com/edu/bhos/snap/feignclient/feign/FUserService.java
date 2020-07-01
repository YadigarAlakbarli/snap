package com.edu.bhos.snap.feignclient.feign;

import com.edu.bhos.snap.feignclient.feign.fallback.UserServiceFalback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name ="user-service",fallback = UserServiceFalback.class)
public interface FUserService {

    @GetMapping("")
    public String index();
}

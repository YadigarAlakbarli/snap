package com.edu.bhos.snap.postservice.feign;

import com.edu.bhos.snap.postservice.feign.fallback.UserServiceFalback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name ="user-service",url ="http://localhost:8081/api/v1/user-service/",fallback = UserServiceFalback.class)
public interface FeignClientUserService {

    @GetMapping("/getdemo")
    Object getDemoUser();

    @GetMapping("/index")
     String index();
}

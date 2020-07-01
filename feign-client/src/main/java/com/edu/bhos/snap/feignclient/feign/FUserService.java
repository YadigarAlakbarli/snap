package com.edu.bhos.snap.feignclient.feign;

import com.edu.bhos.snap.feignclient.feign.fallback.UserServiceFalback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@FeignClient(name ="user-service",url ="http://localhost:8081/api/v1/user-service/",fallback = UserServiceFalback.class)
public interface FUserService {

    @GetMapping("/index")
     String index();
}

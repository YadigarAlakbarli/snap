package com.edu.bhos.snap.feignclient.feign.fallback;

import com.edu.bhos.snap.feignclient.feign.FUserService;
import org.springframework.stereotype.Component;

@Component("user-service-fallback")
public class UserServiceFalback implements FUserService {
    @Override
    public String index() {
        return "Feign client User Service fallback method called";
    }



}

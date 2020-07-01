package com.edu.bhos.snap.feignclient.feign.fallback;

import com.edu.bhos.snap.feignclient.feign.FUserService;

public class UserServiceFalback implements FUserService {
    @Override
    public String index() {
        return "Feign client User Service fallback method called";
    }
}

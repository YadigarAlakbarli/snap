package com.edu.bhos.snap.postservice.feign.fallback;

import com.edu.bhos.snap.postservice.feign.FeignClientUserService;
import org.springframework.stereotype.Component;

@Component("user-service-fallback")
public class UserServiceFalback implements FeignClientUserService {
    @Override
    public Object getDemoUser() {
        return null;
    }
}

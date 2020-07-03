package com.edu.bhos.snap.userservice.controller;

import com.edu.bhos.snap.userservice.controller.abstracts.IRoleController;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("/api/v1/role-service")
public class RoleController implements IRoleController {
}

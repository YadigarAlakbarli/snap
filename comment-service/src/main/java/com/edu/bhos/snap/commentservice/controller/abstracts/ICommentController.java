package com.edu.bhos.snap.commentservice.controller.abstracts;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;

@Api(value = "All Comment operation in this Controller")
public interface ICommentController {

    @ApiOperation(value = "index endpoint return default message")
    @GetMapping("/index")
     String index();
}

package com.edu.bhos.snap.postservice.controller;

import com.edu.bhos.snap.postservice.controller.abstracts.ICategoryController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/category-service")
public class CategoryController implements ICategoryController {
}

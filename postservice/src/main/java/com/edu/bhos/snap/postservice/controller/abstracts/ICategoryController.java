package com.edu.bhos.snap.postservice.controller.abstracts;

import com.edu.bhos.snap.postservice.entity.Category;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

public interface ICategoryController {

    @ApiOperation(value = "Get category by id")
    @GetMapping("getbyid{id}")
    ResponseEntity<Category> getById(@PathVariable Integer id);

    @ApiOperation(value = "create new category")
    @PostMapping("/add")
    ResponseEntity<String> addCategory(@RequestBody Category category);

    @ApiOperation(value = "update exsisting category")
    @PostMapping("/update")
    ResponseEntity<Category> updateCategory(@RequestBody Category category);

    @ApiOperation(value = "Get ALL categories LIST")
    @GetMapping("/getall")
    ResponseEntity<List<Category>> getAllCategories();

    @GetMapping("/delete/{id}")
    @ApiOperation(value = "Delete Category by id")
    ResponseEntity<String> deleteCategoryById(@PathVariable Integer id);

}

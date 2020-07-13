package com.edu.bhos.snap.postservice.service;

import com.edu.bhos.snap.postservice.entity.Category;
import com.edu.bhos.snap.postservice.exception.CategoryNotFoundException;
import com.edu.bhos.snap.postservice.repo.CategoryRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    private static final Logger LOGGER= LogManager.getLogger("categoryservice");

    public Category saveCategory(Category category){
        categoryRepository.saveAndFlush(category);
        LOGGER.info("new category added");
        return category;
    }

    public Category findById(Integer id){
        return categoryRepository.findById(id).orElseThrow(()->new CategoryNotFoundException("Category not found with id "+id));
    }

    public Category update(Category _category){
        findById(_category.getId());
        saveCategory(_category);
        return _category;
    }

    public List<Category> getAll(){
        return categoryRepository.findAll();
    }

    public String deleteCategoryById(Integer id){
        Category category=findById(id);
        categoryRepository.delete(category);
        LOGGER.info("Category deleted");
        return "Category deleted succesfully";
    }
}

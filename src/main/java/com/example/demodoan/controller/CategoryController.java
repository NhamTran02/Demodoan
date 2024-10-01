package com.example.demodoan.controller;

import com.example.demodoan.dto.CategoryDTO;
import com.example.demodoan.model.Category;
import com.example.demodoan.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryServiceImpl categoryServiceImpl;

    @PostMapping
    Category createCategory(@RequestBody CategoryDTO categoryDTO){
        return categoryServiceImpl.createCategory(categoryDTO);
    }

    @GetMapping
    List<Category> getAllCategory(){
        return categoryServiceImpl.getAllCategory();
    }

    @PutMapping("/{id}")
    Category updateCategory (@PathVariable Long id, @RequestBody CategoryDTO categoryDTO){
        return categoryServiceImpl.updateCategory(id, categoryDTO);
    }

    @DeleteMapping("/{id}")
    String deleteCategory(@PathVariable Long id){
        categoryServiceImpl.deleteCategory(id);
        return "Xóa thành công";
    }

    @GetMapping("/{name}")
    List<Category> findNameCategory (@PathVariable String name){
        return categoryServiceImpl.findNameCategory(name);
    }
}

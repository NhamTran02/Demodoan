package com.example.demodoan.controller;

import com.example.demodoan.dto.request.CategoryDTO;
import com.example.demodoan.model.Category;
import com.example.demodoan.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping
    Category createCategory(@Valid @RequestBody CategoryDTO categoryDTO){
        return categoryService.createCategory(categoryDTO);
    }

    @GetMapping
    List<Category> getAllCategory(){
        return categoryService.getAllCategory();
    }

    @PutMapping("/{id}")
    Category updateCategory (@PathVariable Long id,@Valid @RequestBody CategoryDTO categoryDTO){
        return categoryService.updateCategory(id, categoryDTO);
    }

    @DeleteMapping("/{id}")
    String deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
        return "Xóa thành công";
    }

    @GetMapping("/{name}")
    List<Category> findNameCategory (@PathVariable String name){
        return categoryService.findNameCategory(name);
    }
}

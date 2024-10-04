package com.example.demodoan.service;

import com.example.demodoan.dto.request.CategoryDTO;
import com.example.demodoan.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategory();
    Category createCategory(CategoryDTO categoryDTO);
    Category updateCategory(Long id, CategoryDTO categoryDTO);
    void deleteCategory(Long id);
    List<Category> findNameCategory(String name);
}

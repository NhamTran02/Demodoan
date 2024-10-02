package com.example.demodoan.service.impl;

import com.example.demodoan.dto.CategoryDTO;
import com.example.demodoan.model.Category;
import com.example.demodoan.repository.CategoryRepository;
import com.example.demodoan.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Category createCategory(CategoryDTO categoryDTO) {
        Category category = new Category();

        category.setName(categoryDTO.getName());

        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Long id, CategoryDTO categoryDTO) {
        Optional<Category> category = categoryRepository.findById(id);

        Category updateCategory = category.get();
        updateCategory.setName(categoryDTO.getName());

        return categoryRepository.save(updateCategory);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public List<Category> findNameCategory(String name) {
        return categoryRepository.findByNameContainingIgnoreCase(name);
    }

}

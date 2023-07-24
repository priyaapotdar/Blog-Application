package com.MyFirstProjecy.Blog.Application.services.Impl;

import com.MyFirstProjecy.Blog.Application.entities.Category;
import com.MyFirstProjecy.Blog.Application.exception.ResourceNotFoundException;
import com.MyFirstProjecy.Blog.Application.payloads.CategoryDto;
import com.MyFirstProjecy.Blog.Application.repositories.CategoryRepository;
import com.MyFirstProjecy.Blog.Application.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category newCat = modelMapper.map(categoryDto, Category.class);
        Category addedCat = categoryRepository.save(newCat);
        return modelMapper.map(addedCat,CategoryDto.class);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
        Category cat = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "CategoryId", categoryId));
        cat.setCatrgoryTitle(categoryDto.getCatrgoryTitle());
        cat.setCatrgoryDescription(categoryDto.getCatrgoryDescription());
        Category newcat = categoryRepository.save(cat);
        return modelMapper.map(newcat,CategoryDto.class);
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        Category cat = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "CategoryId", categoryId));
        categoryRepository.delete(cat);
    }

    @Override
    public CategoryDto getCategory(Integer categoryId) {
        Category cat = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "CategoryId", categoryId));
        return modelMapper.map(cat,CategoryDto.class);
    }

    @Override
    public List<CategoryDto> getAllCategory() {
        return categoryRepository.findAll().stream().map(n -> modelMapper.map(n,CategoryDto.class)).toList();
    }
}

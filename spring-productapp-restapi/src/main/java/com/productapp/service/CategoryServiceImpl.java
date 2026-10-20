package com.productapp.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.productapp.config.ProductMapper;
import com.productapp.dtos.CategoryDto;
import com.productapp.model.Category;
import com.productapp.repository.IBrandRepository;
import com.productapp.repository.ICategoryRepository;
import com.productapp.repository.IProductRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class CategoryServiceImpl implements ICategoryService {
	
	
	ICategoryRepository categoryRepository;
	ProductMapper mapper;
	
	@Override
	public void addCategory(CategoryDto categoryDto) {
		Category category = mapper.toCategoryEntity(categoryDto);
		categoryRepository.save(category);
		
	}
	@Override
	public void updateCategory(CategoryDto categoryDto) {
		Category category = mapper.toCategoryEntity(categoryDto);
		categoryRepository.save(category);
		
	}
	@Override
	public void deleteCategory(int categoryId) {
		categoryRepository.deleteById(categoryId);
		
	}
	@Override
	public CategoryDto getById(int categoryId) {
		Category category = categoryRepository.findById(categoryId)
						.orElseThrow(()->new RuntimeException("Category not found"));
		return mapper.toCategoryDto(category);
	}	
	@Override
	public List<CategoryDto> getAll() {
		List<CategoryDto> categoryDtos=  categoryRepository.findAll()
				.stream()
				.map(category->mapper.toCategoryDto(category))
				.toList();
		return categoryDtos;
	}
	
}
	
package com.productapp.service;

import java.util.Comparator;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.productapp.dtos.ProductDto;
import com.productapp.exception.ProductNotFoundException;
import com.productapp.model.Product;
import com.productapp.repository.IProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {
	
	
	private final ModelMapper mapper;
	private final IProductRepository productRepository;
	
	@Override
	public void addProduct(ProductDto productdto) {
		//convert the dto into entity - either manually or using 3rd party library model mapper
		//this model mapper is to avoid calling individual properties of the another class
		// Product product = new Product(productdto.getProductName,productdto.getCity )
		//instead of calling individually, we use model mapper
		//call the method of model mapper
		Product product = mapper.map(productdto, Product.class);
		productRepository.save(product);
		

	}

	@Override
	public void updateProduct(ProductDto productdto) {
		Product product = mapper.map(productdto, Product.class);
		productRepository.save(product);

	}

	@Override
	public void deleteProduct(int productId) {
		productRepository.deleteById(productId);

	}

	@Override
	public ProductDto getById(int productId) throws ProductNotFoundException {
		Product product = productRepository.findById(productId)
				.orElseThrow(()->new ProductNotFoundException("Invalid"));
		return mapper.map(product, ProductDto.class);
	}

	@Override
	public List<ProductDto> getAllProducts() {
		
		List<Product> products = productRepository.findAll();
		
		return products.stream()
				.map(product->mapper.map(product, ProductDto.class))
				.toList();

	}

	@Override
	public List<ProductDto> getByLesserPrice(double price) throws ProductNotFoundException {
		List<Product> products = productRepository.findByPriceLessThan(price);
		return products.stream()
				.map(product->mapper.map(product, ProductDto.class))
				.sorted(Comparator.comparing(ProductDto::getProductName))
				.toList();

	}

	@Override
	public List<ProductDto> getByProductNameContains(String productname) {
		
		List<Product> products = productRepository.findByName(productname);
		return products.stream()
				.map(product->mapper.map(product, ProductDto.class))
				.sorted(Comparator.comparing(ProductDto::getProductName))
				.toList();

	}

	@Override
	public List<String> getByNameHaving(String productname) {
		// TODO Auto-generated method stub
		return null;
	}

}

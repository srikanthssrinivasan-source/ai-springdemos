package com.productapp.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.productapp.exception.ProductNotFoundException;
import com.productapp.model.Product;
import com.productapp.repository.IProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {
	
	
//use constructor base DI, if you the dependent MUST be injected
//if not mandatory, use setter bases DI	
	
//	private IProductRepository productRepository;
//	
//	public ProductServiceImpl(IProductRepository productRepository) {
//		super();
//		this.productRepository = productRepository;
//	}
	
	//instead of above, use @RequiredArgsConstructor by making the instance variable private
	//final variable must be initialized. This will be taken care by @RequiredArgsConstructor
	
	private final IProductRepository productRepository;
	

	@Override
	public void addProduct(Product product) {
		//call the method of CRUDRepo
		//product without id- create an id and create a new product in the table - inserted
		//product with id - check if id exists. 
		//If yes, update else create a new product in the table
		Product savedProduct = productRepository.save(product);
		System.out.println(savedProduct);

	}

	@Override
	public void updateProduct(Product product) {
		// sent product with id
		Product updatedProduct = productRepository.save(product);
		System.out.println(updatedProduct);

	}

	@Override
	public void deleteProduct(int productId) {
		productRepository.deleteById(productId);

	}

	@Override
	public Product getById(int productId) throws ProductNotFoundException {
		return productRepository.findById(productId)
						.orElseThrow(()-> new ProductNotFoundException("Invalid ID"));
		 
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}


	@Override
	public List<Product> getByBrand(String brand) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getByLesserPrice(double price) throws ProductNotFoundException {
		List<Product> products = productRepository.findByPriceLessThan(price);
		List<Product> productByPrice = products.stream()
									.sorted(Comparator.comparing(Product::getProductName)).toList();
		if(productByPrice.isEmpty())
			throw new ProductNotFoundException("product with this proce not available");
		return productByPrice;
	}

	@Override
	public List<Product> getByProductNameContains(String productname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getByBrandPrice(String brand, double cost) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findByCatBrand(String category, String brand) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findByCatPrice(String category, double price) {
		// TODO Auto-generated method stub
		return null;
	}

}

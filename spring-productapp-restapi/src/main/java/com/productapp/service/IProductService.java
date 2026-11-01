package com.productapp.service;

import java.util.List;

import com.productapp.dtos.ProductDto;
import com.productapp.exception.ProductNotFoundException;

public interface IProductService {

	// using the built in methods of JpaRepo
	void addProduct(ProductDto product);

	void updateProduct(ProductDto product);

	void deleteProduct(int productId);

	ProductDto getById(int productId) throws ProductNotFoundException;

	List<ProductDto> getAllProducts();

	// derived queries
	List<ProductDto> getByLesserPrice(double price) throws ProductNotFoundException;

	List<ProductDto> getByProductNameContains(String productname);

	List<String> getByNameHaving(String productname);
	
	//pagination
	List<ProductDto> getAllProducts(int pageNo, int itemcount);
	
	//custom queries
	List<ProductDto> getByColor(String color)  throws ProductNotFoundException;
	
	List<ProductDto> getByOffers(String offername)  throws ProductNotFoundException;
	
	List<ProductDto> getByColorAndLesserPrice(String color, double price)throws ProductNotFoundException;
	
	List<ProductDto> getByCategoryAndBrand(String category, String brand)throws ProductNotFoundException;
		
	List<ProductDto> getByDeliveryTypes(String delivery)throws ProductNotFoundException;

	List<ProductDto> getByPaymentAndDelivery(String payment, String delivery)throws ProductNotFoundException;
	
	List<ProductDto> getByCatBrandOffer(String category, String brand, String offer)throws ProductNotFoundException;
	
}

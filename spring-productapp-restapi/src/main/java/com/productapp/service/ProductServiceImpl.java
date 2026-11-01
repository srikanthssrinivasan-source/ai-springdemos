package com.productapp.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.productapp.config.ProductMapper;
import com.productapp.dtos.ProductDto;
import com.productapp.exception.ProductNotFoundException;
import com.productapp.model.Product;
import com.productapp.repository.IProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {

	// private final ModelMapper mapper;
	private final ProductMapper mapper;
	private final IProductRepository productRepository;

	@Override
	public void addProduct(ProductDto productdto) {
		// convert the dto into entity - either manually or using 3rd party library
		// model mapper
		// this model mapper is to avoid calling individual properties of the another
		// class
		// Product product = new Product(productdto.getProductName,productdto.getCity )
		// instead of calling individually, we use model mapper
		// call the method of model mapper

//		Product product = mapper.map(productdto, Product.class);
		// call the method of ProductMapper instead of calling ModelMapper
		// to convert Dto into entity
		Product product = mapper.toProductEntity(productdto);
		productRepository.save(product);

	}

	@Override
	public void updateProduct(ProductDto productdto) {
//		Product product = mapper.map(productdto, Product.class);
		// call the method of ProductMapper instead of calling ModelMapper
		// to convert Dto into entity
		Product product = mapper.toProductEntity(productdto);
		productRepository.save(product);

	}

	@Override
	public void deleteProduct(int productId) {
		productRepository.deleteById(productId);

	}

	@Override
	public ProductDto getById(int productId) throws ProductNotFoundException {
		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new ProductNotFoundException("Invald Id"));
//		return mapper.map(product, ProductDto.class);
		// call the method of ProductMapper instead of calling ModelMapper
		// to convert entity into Dto obj
		return mapper.toProductDto(product);
	}

	@Override
	public List<ProductDto> getAllProducts() {
		//get all the products sorted by db itself
		List<Product> products = productRepository.findAll(Sort.by("productName"));

//		return products.stream()
//				.map(product->mapper.map(product, ProductDto.class))
//				.toList();

		// call the method of ProductMapper instead of calling ModelMapper
		// to convert entity into Dto obj

		return products.stream()
				.map(product -> mapper.toProductDto(product))
				.toList();

	}

	@Override
	public List<ProductDto> getByLesserPrice(double price) throws ProductNotFoundException {
		List<Product> products = productRepository.findByPriceLessThan(price);
//		return products.stream()
//				.map(product->mapper.map(product, ProductDto.class))
//				.sorted(Comparator.comparing(ProductDto::getProductName))
//				.toList();

		// call the method of ProductMapper instead of calling ModelMapper
		// to convert entity into Dto obj
		return products.stream().map(product -> mapper.toProductDto(product))
				.sorted(Comparator.comparing(ProductDto::getProductName)).toList();

	}

	@Override
	public List<ProductDto> getByProductNameContains(String productname) {

		List<Product> products = productRepository.findByName("%" + productname + "%");
		
		if(products.isEmpty())
			throw new ProductNotFoundException("Product not found");
		
//		return products.stream()
//				.map(product->mapper.map(product, ProductDto.class))
//				.sorted(Comparator.comparing(ProductDto::getProductName))
//				.toList();
		// call the method of ProductMapper instead of calling ModelMapper
		// to convert entity into Dto obj
		return products.stream()
				.map(product -> mapper.toProductDto(product))
				.sorted(Comparator.comparing(ProductDto::getProductName))
				.toList();

	}

	@Override
	public List<String> getByNameHaving(String productname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductDto> getByColor(String color) throws ProductNotFoundException {
		//use custom query - return the products by color sorted by productName
		List<Product> products = productRepository.findByColor(color, Sort.by(Direction.DESC,"price","productName"));

		if (products.isEmpty())
			throw new ProductNotFoundException("Product not found");

		return products.stream().map(product -> mapper.toProductDto(product)).toList();
	}

	@Override
	public List<ProductDto> getByOffers(String offername) throws ProductNotFoundException {

		List<Product> products = productRepository.findByOffers(offername);

		if (products.isEmpty())
			throw new ProductNotFoundException("Product not found");

		return products.stream().map(product -> mapper.toProductDto(product)).toList();
	}

	@Override
	public List<ProductDto> getByColorAndLesserPrice(String color, double price) throws ProductNotFoundException {
		List<Product> products = productRepository.findByColorAndLesserPrice(color,price);

		if (products.isEmpty())
			throw new ProductNotFoundException("Product not found with this color and price range");

		return products.stream().map(product -> mapper.toProductDto(product)).toList();
	}

	@Override
	public List<ProductDto> getByCategoryAndBrand(String category, String brand) throws ProductNotFoundException {
		List<Product> products = productRepository.findByCategoryAndBrand(category,brand);

		if (products.isEmpty())
			throw new ProductNotFoundException("Product not found with this category and brand");

		return products.stream().map(product -> mapper.toProductDto(product)).toList();
	}

	@Override
	public List<ProductDto> getByDeliveryTypes(String delivery) throws ProductNotFoundException {
		List<Product> products = productRepository.findByDeliveryTypes(delivery);

		if (products.isEmpty())
			throw new ProductNotFoundException("Product not found for this delivery type");

		return products.stream().map(product -> mapper.toProductDto(product)).toList();
	}

	@Override
	public List<ProductDto> getByPaymentAndDelivery(String payment, String delivery) throws ProductNotFoundException {
		List<Product> products = productRepository.findByPaymentAndDelivery(payment,delivery);

		if (products.isEmpty())
			throw new ProductNotFoundException("Product not found for the given filter");

		return products.stream().map(product -> mapper.toProductDto(product)).toList();
	}

	@Override
	public List<ProductDto> getByCatBrandOffer(String category, String brand, String offer)
			throws ProductNotFoundException {
		List<Product> products = productRepository.findByCatBrandOffer(category,brand,offer);

		if (products.isEmpty())
			throw new ProductNotFoundException("Product not found for the given filter");

		return products.stream().map(product -> mapper.toProductDto(product)).toList();
	}

	@Override
	public List<ProductDto> getAllProducts(int pageNo, int itemcount) {
//		Pageable pageref = Pageable.ofSize(itemcount); //get the pagination done without sorting
		
		//pagenumber, no of items to be shown, sorting by
		Pageable pageref = PageRequest.of(pageNo, itemcount,Sort.by("productName")); //to get the pages sorted with limit that we pass from controller
		Page<Product> products = productRepository.findAll(pageref);
		
		//convert list of products to list of dtos
		return products.stream()
				.map(product -> mapper.toProductDto(product))
				.toList();
	}

}

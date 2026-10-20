package com.productapp.dtos;

import java.util.List;

import com.productapp.model.Brand;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProductDto {

	private String productName;

	private Integer productId;

	private double price; // use price for JPQL queries and cost for "sql"

	private int ratings;

	private FeaturesDto features; //one to one

	private List<OffersDto> offers; //one to many
	
	private List<CategoryDto> categories; //many to many
	
	private BrandDto brand;	//many to one
	
	private List<String> paymentMode;
	
	private List<String> deliveryTypes;

}

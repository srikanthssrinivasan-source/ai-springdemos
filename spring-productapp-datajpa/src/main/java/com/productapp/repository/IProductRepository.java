package com.productapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.productapp.model.Product;

public interface IProductRepository extends JpaRepository<Product, Integer>{
	
	//derived queries - use only instance variable names with findBy/ getBy
	List<Product> findByBrand(String brand);
	
	List<Product> findByPriceLessThan(double Price);
	
	List<Product> findByProductNameContains(String productName);
	
//	List<Product> findByBrandAndPriceLessThan(String brand, double price);
	
	//custom query - method name can be anything - use @Query annotation
	//JPQL
	@Query("select pi from Product pi where pi.brand = ?1 and pi.price=?2")
	List<Product> findByBrandPrice(String brand, double cost);
	
	@Query("select pi from Product pi where pi.category=?1and pi.brand = ?2")
	List<Product> findByCatBrand(String category, String brand);
	
	//native query -- pass the actual table name and actual column names which is in DB
	@Query(value="select * from product p where p.category = ?1 and p.cost=?2",nativeQuery=true)
	List<Product> findByCatPrice(String category,double price);
	

}

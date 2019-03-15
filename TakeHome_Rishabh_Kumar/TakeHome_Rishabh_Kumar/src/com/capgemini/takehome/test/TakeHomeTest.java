package com.capgemini.takehome.test;


import org.junit.Test;

import com.capgemini.takehome.dao.IProductDAO;
import com.capgemini.takehome.dao.ProductDAO;
import com.capgemini.takehome.exceptions.ProductDoesNotExistException;
import com.capgemini.takehome.service.ProductService;

public class TakeHomeTest {


	IProductDAO productDAO=new ProductDAO();
	ProductService productService=new ProductService(productDAO);

	

	/*
	 * Test Cases for DAO Packages
	 * 1. When Correct Product ID is Entered the it should return the Product object strored in collection.
	 * 2. When The product ID does not exist it should throw Exception.
	 */
	
	@Test
	public void WhenExistingProductIDIsPassedItShouldRetrunTheProductObject() throws ProductDoesNotExistException {
		
		
	 productService.getProductDetails(1001);
	 // We have already our data in CollectionUtil class which is linked with the Service layer.
	}
	
	@Test(expected=com.capgemini.takehome.exceptions.ProductDoesNotExistException.class)
	public void WhenTheProductIDDoesNotExistItShouldThrowException() throws ProductDoesNotExistException {
		productService.getProductDetails(1008);
		//We have only 4 produsts in our collection ie. 1001-1004. So, other then these searching other product code should throw exception.
	}

}

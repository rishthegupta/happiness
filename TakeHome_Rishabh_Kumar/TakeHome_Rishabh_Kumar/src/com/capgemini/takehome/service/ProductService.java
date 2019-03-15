package com.capgemini.takehome.service;

import com.capgemini.takehome.beans.Product;
import com.capgemini.takehome.dao.IProductDAO;
import com.capgemini.takehome.exceptions.ProductDoesNotExistException;

public class ProductService implements IProductService {

	
	
	IProductDAO productDAO;
	//Parameterized Constructor
	public ProductService(IProductDAO productDAO) {
		super();
		this.productDAO = productDAO;
	}

	
	//Method to find the produst on the basis of peoduct code and returns the object of it
	@Override
	public Product getProductDetails(int productCode) throws ProductDoesNotExistException {
		Product product=productDAO.getProductDetails(productCode);
		return product;
	}

}

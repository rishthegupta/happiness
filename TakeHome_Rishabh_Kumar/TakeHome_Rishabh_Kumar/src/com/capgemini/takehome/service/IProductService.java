package com.capgemini.takehome.service;

import com.capgemini.takehome.beans.Product;
import com.capgemini.takehome.exceptions.ProductDoesNotExistException;

public interface IProductService {
	
	Product getProductDetails(int productCode) throws ProductDoesNotExistException;

}

package com.capgemini.takehome.dao;

import com.capgemini.takehome.beans.Product;
import com.capgemini.takehome.exceptions.ProductDoesNotExistException;

public interface IProductDAO {
	Product getProductDetails(int productCode) throws ProductDoesNotExistException;
	

}

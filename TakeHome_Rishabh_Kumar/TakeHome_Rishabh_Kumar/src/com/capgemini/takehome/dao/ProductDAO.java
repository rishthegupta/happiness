package com.capgemini.takehome.dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.capgemini.takehome.beans.Product;
import com.capgemini.takehome.exceptions.ProductDoesNotExistException;
import com.capgemini.takehome.util.CollectionUtil;



public class ProductDAO implements IProductDAO {
	
	@SuppressWarnings("static-access")
	HashMap<Integer, Product> productData=(HashMap<Integer, Product>) new CollectionUtil().getProducts();

	
	@SuppressWarnings("unused")
	@Override
	public Product getProductDetails(int productCode) throws ProductDoesNotExistException {
		Product ctemp=null;
		Iterator<Entry<Integer, Product>> dataTrav=productData.entrySet().iterator();
		while(dataTrav.hasNext())
		{
			Entry<Integer, Product> data=(Map.Entry<Integer, Product>)dataTrav.next();
				if(data.getValue().getProductID()==productCode)
				{
					ctemp=data.getValue();
					return data.getValue();	
				}			
		}
		if(ctemp!=null)
			return ctemp;
		else
			throw new ProductDoesNotExistException(productCode);
	
	}
		
		
	


}


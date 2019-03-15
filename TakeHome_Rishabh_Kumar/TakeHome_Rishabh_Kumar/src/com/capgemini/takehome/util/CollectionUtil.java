package com.capgemini.takehome.util;

import java.util.HashMap;
import java.util.Map;

import com.capgemini.takehome.beans.Product;

public class CollectionUtil {
	
	private static Map<Integer, Product>  products=new HashMap<Integer, Product>();

	//Static block which will add the data to collection
	static {
				products.put(1001, new Product(1001, "iPhone"," Electronics", 35000));
				products.put(1002, new Product(1002, "LEDTV"," Electronics", 45000));	
	            products.put(1003, new Product(1003, "Teddy"," Toys", 800));	
	            products.put(1004, new Product(1004, "Telescope"," Toys", 5000));	

	      }
	//Getter-Setter for Products collection
	public static Map<Integer, Product> getProducts() {
		return products;
	}
	public static void setProducts(Map<Integer, Product> products) {
		CollectionUtil.products = products;
	}
}

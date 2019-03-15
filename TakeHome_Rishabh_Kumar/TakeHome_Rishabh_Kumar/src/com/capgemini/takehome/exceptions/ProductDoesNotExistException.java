package com.capgemini.takehome.exceptions;

@SuppressWarnings("serial")
public class ProductDoesNotExistException extends Exception {

	
	private int productCode;
	public ProductDoesNotExistException(int productCode) {
		// TODO Auto-generated constructor stub
		this.productCode=productCode;
	}

	@Override
	public String toString() {
		return "Sorry ! The Product Code "+ productCode +" is not Available";
	}
	
	
	
	

}

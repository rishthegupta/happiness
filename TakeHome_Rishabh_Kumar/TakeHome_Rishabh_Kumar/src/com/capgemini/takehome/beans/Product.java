package com.capgemini.takehome.beans;



public class Product {
	
	private int productID;
	private String productName;
	private String productCategory;
	private double productPrice;
	


	//Parameterizzed Constructor
	public Product(int productID, String productName, String productCategory, double productPrice) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.productCategory = productCategory;
		this.productPrice = productPrice;
	}
	//Getter-Setter Methods
	

	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	
	
	
	//TO STRING METHOD
	@Override
	public String toString() {
		return "Product [productID=" + productID + ", productName=" + productName + ", productCategory="
				+ productCategory + ", productPrice=" + productPrice + "]";
	}
	
	
	
	

}

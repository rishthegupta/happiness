package com.capgemini.takehome.UI;


import java.util.Scanner;



import com.capgemini.takehome.beans.Product;
import com.capgemini.takehome.dao.IProductDAO;
import com.capgemini.takehome.dao.ProductDAO;
import com.capgemini.takehome.exceptions.ProductDoesNotExistException;
import com.capgemini.takehome.service.ProductService;


public class Client {
	private static Scanner scanner =new Scanner(System.in);
	private static IProductDAO productDAO=new ProductDAO();
	private static ProductService productService= new ProductService(productDAO);

	//Main Method
	public static void main(String[] args) throws ProductDoesNotExistException {
		
		//Declerations
		int choice;

		//MENU
		while(true)
		{
			System.out.println();
			System.out.println("1) Generate Bill by entering Product code and qualtity");
			System.out.println("2) Exit");
			System.out.println("**** Enter your chioce ****");
			choice=scanner.nextInt();
			switch (choice) {
			case 1:generateBill();
					break;
			case 2:{
					System.exit(0);
					//Closing Scanner as there is no need oF this resource;
					scanner.close();
					}
					break;
			default:System.out.println("You have Choosed Wrong Choice ! ");
				break;
			}
		}
	}

	//Method For Generating Bill
	private static void generateBill() throws ProductDoesNotExistException {
		int productCode;
		int quantity = 0;
		Product product;
		
		System.out.println("Enter the product id");
		productCode=scanner.nextInt();
		while(!(productCode>1000 && productCode<9999))// assuming we have product code in this range only
		{
			System.out.println("Wrong product ID, Enter again");
			productCode=scanner.nextInt();
		}
		//When the product ID id null it will throw exception with a error message stating that this <Product ID> does not exist.
		product=productService.getProductDetails(productCode);
		//System.out.println(product);
		System.out.println("Enter quantity of "+ product.getProductName());
		quantity=scanner.nextInt();
		while(!(quantity>0))
		{
			System.out.println("Product Quantity can't be zero, Enter some value");
			quantity=scanner.nextInt();
		}
			
		generateAndPrint(product,quantity);
			
			
		
		
		
		
	}
	
	//Method to print the bill
	private static void generateAndPrint(Product product, int quantity) {
		
		double lineTotal=product.getProductPrice()*quantity;
		
		System.out.println("BILL");
		System.out.println("Product Details:   "+ product.getProductName());
		System.out.println("Product Category:  "+ product.getProductCategory());
		System.out.println("Product Price(Rs): "+ product.getProductPrice());
		System.out.println("Quantity:          "+ quantity);
		System.out.println("Line Total:        "+ lineTotal);
		
	
	}

	
	
	

}

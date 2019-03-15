package src.com.capgemini.beans;

import java.util.LinkedList;

public class Customer {

	private String name;
	private String mobileNumber;
	private Wallet wallet;
	private LinkedList<Transactions> l=new LinkedList<>();
	private Transactions transaction=new Transactions();
	
	
	

	public LinkedList<Transactions> getL() {
		return l;
	}
	public void setL(LinkedList<Transactions> l) {
		this.l = l;
	}
	
	public Transactions getTransaction() {
		return transaction;
	}
	public void setTransaction(Transactions transaction) {
		this.transaction = transaction;
	}
	//Getter-Setter Methods
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}
	
	
	
	//To String Method
	
	@Override
	public String toString() {
		return "Customer [name=" + name + ", mobileNumber=" + mobileNumber + ", wallet=" + wallet + "]";
	}
	
	


}

package src.com.capgemini.beans;

import java.math.BigDecimal;

public class Transactions {
	
	private int transactionId;
	private String mobileNumber;
	private String transactionType;
	private BigDecimal amount;
	
	
	
	
	//Getter-Setter Methods
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	
	
	@Override
	public String toString() {
		return "Transactions [transactionId=" + transactionId + ", mobileNumber=" + mobileNumber + ", transactionType="
				+ transactionType + ", amount=" + amount + "]"+"\n";
	}
	
	
	
	
	
}

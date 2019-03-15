package src.com.capgemini.service;

import java.math.BigDecimal;
import java.util.List;

import src.com.capgemini.beans.Customer;
import src.com.capgemini.beans.Transactions;
import src.com.capgemini.exception.FieldCannotBeNullException;
import src.com.capgemini.exception.InsufficientBalanceException;
import src.com.capgemini.exception.MobileNumberAlreadyExistsException;
import src.com.capgemini.exception.PhoneNumberDoesNotExistException;

public interface WalletService {
	
	public Customer createAccount(String name, String mobileNumber, BigDecimal amount) throws MobileNumberAlreadyExistsException, FieldCannotBeNullException;
	public Customer showBalance(String mobileNumber) throws PhoneNumberDoesNotExistException;
	public Customer depositAmount(String mobileNumber , BigDecimal amount) throws PhoneNumberDoesNotExistException;
	public Customer withdrawAmount(String mobileNumber , BigDecimal amount) throws InsufficientBalanceException, PhoneNumberDoesNotExistException;
	public Customer fundTransfer(String sourceMobileNumber ,String targetMobileNumber, BigDecimal amount) throws InsufficientBalanceException, PhoneNumberDoesNotExistException;
	public List<Transactions> showTransactions(String mobileNumber) throws PhoneNumberDoesNotExistException;
}

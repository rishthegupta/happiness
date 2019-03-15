package src.com.capgemini.repo;

import src.com.capgemini.beans.Customer;
import src.com.capgemini.exception.MobileNumberAlreadyExistsException;
import src.com.capgemini.exception.PhoneNumberDoesNotExistException;

public interface WalletRepo {
	
	public boolean save(Customer customer) throws MobileNumberAlreadyExistsException;
	public Customer findCustomer(String mobileNumber) throws PhoneNumberDoesNotExistException;

}

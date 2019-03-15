package src.com.capgemini.repo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import src.com.capgemini.beans.Customer;
import src.com.capgemini.exception.MobileNumberAlreadyExistsException;
import src.com.capgemini.exception.PhoneNumberDoesNotExistException;





public class WalletRepoImpl implements WalletRepo {

	private HashMap<String, Customer> userData=new HashMap<String, Customer>();

	@Override
	public boolean save(Customer customer) throws MobileNumberAlreadyExistsException {
		// TODO Auto-generated method stub
		if(userData.containsKey(customer.getMobileNumber()))
		{
			throw new MobileNumberAlreadyExistsException();
		}

		userData.put(customer.getMobileNumber(), customer);
	
		return true;
	}

	@SuppressWarnings("unused")
	@Override
	public Customer findCustomer(String mobileNumber) throws PhoneNumberDoesNotExistException {
		// TODO Auto-generated method stub
		
		Customer ctemp=userData.get(mobileNumber);
		
		
		/*Iterator<Entry<String, Customer>> dataTrav=userData.entrySet().iterator();
		while(dataTrav.hasNext())
		{
			Map.Entry<String, Customer> data=(Map.Entry<String, Customer>)dataTrav.next();
				if(data.getValue().getMobileNumber().equals(mobileNumber))
				{
					ctemp=data.getValue();
					return data.getValue();
				}	
		}	*/		
		
		if(ctemp!=null)
			return ctemp;
		else
			throw new PhoneNumberDoesNotExistException();
		
			}



}

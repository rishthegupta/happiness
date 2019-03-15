package src.com.capgemini.service;

import java.math.BigDecimal;

import java.util.List;

import src.com.capgemini.beans.Customer;
import src.com.capgemini.beans.Transactions;
import src.com.capgemini.beans.Wallet;
import src.com.capgemini.exception.FieldCannotBeNullException;
import src.com.capgemini.exception.InsufficientBalanceException;
import src.com.capgemini.exception.MobileNumberAlreadyExistsException;
import src.com.capgemini.exception.PhoneNumberDoesNotExistException;
import src.com.capgemini.repo.WalletRepo;





public class WalletServiceImpl implements WalletService  {
	
	static int transactionID=1;
	WalletRepo walletRepo;
	
	// Constructor
	public WalletServiceImpl(WalletRepo walletRepo) {
		super();
		this.walletRepo = walletRepo;
	}

	
	// ********** OVERRIDDEN METHODS *********
	//Method for creating and addinf account to hashmap
	@Override
	public Customer createAccount(String name, String mobileNumber, BigDecimal amount) throws FieldCannotBeNullException, MobileNumberAlreadyExistsException {
		
		
		if(name==null || mobileNumber==null ||amount==null )
		{
			throw new FieldCannotBeNullException();
		}
		Wallet wallet=new Wallet();
		wallet.setBalance(amount);
		Customer customer =new Customer();
		
		customer.setName(name);
		customer.setMobileNumber(mobileNumber);
		customer.setWallet(wallet);
		
		if(walletRepo.save(customer))
			return customer;
		
		return null;
	}

	//Method for showing balance
	@Override
	public Customer showBalance(String mobileNumber) throws PhoneNumberDoesNotExistException {
		
		Customer customer=walletRepo.findCustomer(mobileNumber);
		Transactions transaction= new Transactions();
		
		transaction.setAmount(customer.getWallet().getBalance());
		transaction.setMobileNumber(customer.getMobileNumber());
		transaction.setTransactionId(transactionID++);
		transaction.setTransactionType("Show balance");
		customer.getL().add(transaction);
		return customer;
	}

	
	//Method for deposit amount
	@Override
	public Customer depositAmount(String mobileNumber, BigDecimal amount) throws PhoneNumberDoesNotExistException {
		
		Customer customer=walletRepo.findCustomer(mobileNumber);
		if(customer==null)
		{
			System.out.println(customer);
			throw new NullPointerException();
		}
		customer.getWallet().setBalance(customer.getWallet().getBalance().add(amount));
		
		//Update transaction
		Transactions transaction= new Transactions();
		transaction.setAmount(customer.getWallet().getBalance());
		transaction.setMobileNumber(customer.getMobileNumber());
		transaction.setTransactionId(transactionID++);
		transaction.setTransactionType("Deposit");
		customer.getL().add(transaction);
		
		return customer;
	}

	//Method for amount Withdrawl
	@Override
	public Customer withdrawAmount(String mobileNumber, BigDecimal amount) throws InsufficientBalanceException, PhoneNumberDoesNotExistException {
		// TODO Auto-generated method stub
		Customer customer=walletRepo.findCustomer(mobileNumber);
		
		//Checking Exceptions
		if(customer.getWallet().getBalance().compareTo(amount)==-1)
		{
			throw new InsufficientBalanceException();
		}
		
		customer.getWallet().setBalance(customer.getWallet().getBalance().subtract(amount));
		
		//Update transaction
		Transactions transaction= new Transactions();
		transaction.setAmount(customer.getWallet().getBalance());
		transaction.setMobileNumber(customer.getMobileNumber());
		transaction.setTransactionId(transactionID++);
		transaction.setTransactionType("Withdraw");
		customer.getL().add(transaction);
		
		return customer;
	}

	
	//Method for fund Transfer
	@Override
	public Customer fundTransfer(String sourceMobileNumber, String targetMobileNumber, BigDecimal amount) throws InsufficientBalanceException, PhoneNumberDoesNotExistException {
		// TODO Auto-generated method stub
		Customer customer1=walletRepo.findCustomer(sourceMobileNumber);
		Customer customer2=walletRepo.findCustomer(targetMobileNumber);
		
		//Checking Exception
		if(customer1.getWallet().getBalance().compareTo(amount)==-1)
		{
			throw new InsufficientBalanceException();
		}
		
		customer1.getWallet().setBalance(customer1.getWallet().getBalance().subtract(amount));
		customer2.getWallet().setBalance(customer2.getWallet().getBalance().add(amount));
		
		//Update transaction
		//Remitter's account
		customer1.getTransaction().setAmount(customer1.getWallet().getBalance());
		customer1.getTransaction().setMobileNumber(customer1.getMobileNumber());
		customer1.getTransaction().setTransactionId(transactionID++);
		customer1.getTransaction().setTransactionType("Fund transfered");
		customer1.getL().add(customer1.getTransaction());
		
		//Reciever's account
		customer2.getTransaction().setAmount(customer2.getWallet().getBalance());
		customer2.getTransaction().setMobileNumber(customer2.getMobileNumber());
		customer2.getTransaction().setTransactionId(transactionID++);
		customer2.getTransaction().setTransactionType("Fund Recieved");
		customer2.getL().add(customer2.getTransaction());
		
		
		return customer1;
	}
	
	//Method for Show Transaction
	@Override
	public List<Transactions> showTransactions(String mobileNumber) throws PhoneNumberDoesNotExistException {
		
		return walletRepo.findCustomer(mobileNumber).getL();
	}
	
	

}

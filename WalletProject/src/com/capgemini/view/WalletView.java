package src.com.capgemini.view;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import src.com.capgemini.beans.Customer;
import src.com.capgemini.beans.Transactions;
import src.com.capgemini.exception.FieldCannotBeNullException;
import src.com.capgemini.exception.InsufficientBalanceException;
import src.com.capgemini.exception.MobileNumberAlreadyExistsException;
import src.com.capgemini.exception.PhoneNumberDoesNotExistException;
import src.com.capgemini.repo.WalletRepo;
import src.com.capgemini.repo.WalletRepoImpl;
import src.com.capgemini.service.WalletServiceImpl;



public class WalletView {
	private static Scanner scanner=new Scanner(System.in);
	private static WalletRepo walletRepo=new WalletRepoImpl();
	private static WalletServiceImpl walletService= new src.com.capgemini.service.WalletServiceImpl(walletRepo);

	public static void main(String[] args) throws InsufficientBalanceException, PhoneNumberDoesNotExistException, MobileNumberAlreadyExistsException, FieldCannotBeNullException {
		
		//Declerations
		
		int choice;
		
		//***************************************
		
	
		//Data Entry
		walletService.createAccount("ABC", "9999999999", new BigDecimal(500));
		walletService.createAccount("BCD", "8888888888", new BigDecimal(1000));
		walletService.createAccount("DEF", "7777777777", new BigDecimal(5000));
		
		
		
	
		while(true)
		{
			System.out.println();
			System.out.println("1: Create Account");
			System.out.println("2: Deposit Amount");
			System.out.println("3: Withdraw Amount");
			System.out.println("4: Fund Transefer");
			System.out.println("5: Show Balance");
			System.out.println("6: Show Transactions");
			System.out.println("7: Exit");
			choice=scanner.nextInt();
			
			switch(choice)
			{
				case 1:createAccount();
						break;
				case 2:deposit();
						break;
				case 3:withdraw();
						break;
				case 4: fundTransfer();
						break;
				case 5:showBalance();
						break;
				case 6:showTransaction();
						break;
				case 7:System.exit(0);
						break;
				default:System.out.println("***** WRONG CHOICE *****");
			
			}
		}
		
			
		
	}

	//***** METHOD FOR CREATING ACCOUNT *****
	private static void createAccount() throws MobileNumberAlreadyExistsException, FieldCannotBeNullException {
		
		
		System.out.println();
		System.out.println("Enter details of the Costumer");
		
		
		//Input For Costumer Name
			System.out.println("Enter name of the Customer");
			String name=scanner.next();
			while(!Pattern.matches("^[a-zA-Z\\\\s]*$", name)) 
			{
				System.out.println("Enter correct name within 20 character");
				name=scanner.next();
			}
			
		
		//Input for Phone Number
			System.out.println("Enter the phone number");
			String phoneNumber=scanner.next();
			while(!Pattern.matches("[789]{1}[0-9]{9}",phoneNumber))
			{
				System.out.println("Enter phone number again");
				phoneNumber=scanner.next();
			}
		
		
		//Balance Input
			System.out.println("Enter opening amount");
			double amount=scanner.nextDouble();
			
		Customer customer=walletService.createAccount(name, phoneNumber, new BigDecimal(amount));
		
		System.out.println(customer.getName()+" registered successfully !");
				
		//System.out.println("");
	
	}
	//*******************************************************************************
	
	//***** METHOD FOR DEPOSIT AMOUNT *****
	private static void deposit() throws PhoneNumberDoesNotExistException {
		
		
		
		//Input for Phone Number
				System.out.println("Enter the Phone Number associated with Wallet");
				String phoneNumber=scanner.next();
				while(!Pattern.matches("[789]{1}[0-9]{9}",phoneNumber))
				{
					System.out.println("Enter phone number again");
					phoneNumber=scanner.next();
				}
				
				
		//Inpout for amount		
				System.out.println("Enter the amount you wanna deposit");
				double amount=scanner.nextDouble();
		
				
		
				

		Customer customer=walletService.depositAmount(phoneNumber,new BigDecimal(amount));
		
		System.out.println("Balance Sucessfully Deposited in "+customer.getName()+"'s account");
	}
	//*******************************************************************************
	
	//***** METHOD FOR WITHDRAW AMOUNT *****
	private static void withdraw() throws InsufficientBalanceException, PhoneNumberDoesNotExistException {
		
		
		//Input for Phone Number
				System.out.println("Enter the Phone Number associated with Wallet");
				String phoneNumber=scanner.next();
				while(!Pattern.matches("[789]{1}[0-9]{9}",phoneNumber))
				{
					System.out.println("Enter phone number again");
					phoneNumber=scanner.next();
				}
				
				
		//Inpout for amount		
				System.out.println("Enter the amount you wanna withdraw");
				double amount=scanner.nextDouble();
		
				
		Customer customer=walletService.withdrawAmount(phoneNumber,new BigDecimal(amount));
		System.out.println("Balance Sucessfully Withdrawn from "+customer.getName()+"'s account");
		
	}
	//*******************************************************************************
	
	//***** METHOD FOR FUND TRANSFER *****
	private static void fundTransfer() throws InsufficientBalanceException, PhoneNumberDoesNotExistException {
		
		
		//Input for Phone Number
			System.out.println("Enter the phone number associated with Remitter's Wallet");
			String sourcePhoneNumber=scanner.next();
			while(!Pattern.matches("[789]{1}[0-9]{9}",sourcePhoneNumber))
			{
				System.out.println("Enter phone number again");
				sourcePhoneNumber=scanner.next();
			}
			
			
	
			
		//Input for Phone Number
			System.out.println("Enter the phone number associated with Reciever's Wallet");
			String targetPhoneNumber=scanner.next();
			while(!Pattern.matches("[789]{1}[0-9]{9}",targetPhoneNumber))
			{
				System.out.println("Enter phone number again");
				targetPhoneNumber=scanner.next();
			}
			
		//Inpout for amount		
			System.out.println("Enter the amount you wanna Transfer");
			double amount=scanner.nextDouble();
	
			
			walletService.fundTransfer(sourcePhoneNumber,targetPhoneNumber,new BigDecimal(amount));
			
			
			System.out.println(amount+" is successfully transfered from "+walletRepo.findCustomer(sourcePhoneNumber).getName()+"'s Wallet to "+ walletRepo.findCustomer(targetPhoneNumber).getName()+"'s Wallet");
		
	}
	//********************************************************************************
	
	//***** METHOD FOR SHOWING BALANCE *****
	private static void showBalance() throws PhoneNumberDoesNotExistException {
		
		//Input for Phone Number
			System.out.println("Enter the phone number associated with the Wallet");
			String phoneNumber=scanner.next();
			while(!Pattern.matches("[789]{1}[0-9]{9}",phoneNumber))
			{
				System.out.println("Enter phone number again");
				phoneNumber=scanner.next();
			}
			
			System.out.println("your current balance is "+walletService.showBalance(phoneNumber).getWallet().getBalance());
		
	}
	//********************************************************************************
	
	// ***** METHOD FOR PRINTING TRANSACTIONS *****
	private static void showTransaction() throws PhoneNumberDoesNotExistException {
		//Input for Phone Number
		System.out.println("Enter the phone number associated with the Wallet");
		String phoneNumber=scanner.next();
		while(!Pattern.matches("[789]{1}[0-9]{9}",phoneNumber))
		{
			System.out.println("Enter phone number again");
			phoneNumber=scanner.next();
		}
		
		List<Transactions> list =walletService.showTransactions(phoneNumber);
	
		for(Transactions i:list)
		{
			System.out.println(i);
		}
		
	}
	//********************************************************************************

}





















//EXTRAS

/*		Customer c1=walletService.createAccount("ABC", "25622111458", new BigDecimal(500));
Customer c2=walletService.createAccount("BCD", "1231231234", new BigDecimal(1000));
Customer c3=walletService.createAccount("DEF", "1203254621", new BigDecimal(5000));
Customer c4=walletService.createAccount("EFG", "3698547588", new BigDecimal(2000));


//System.out.println(c1);


System.out.println("Intial Balance of 1231231234 "+walletService.showBalance("1231231234").getWallet().getBalance());

System.out.println("After Deposit 1000 in 1231231234 "+walletService.depositAmount("1231231234",new BigDecimal(1000)).getWallet().getBalance());


System.out.println("After withdrawl 500 from 1231231234 "+walletService.withdrawAmount("1231231234",new BigDecimal(500)).getWallet().getBalance());


System.out.println("Intial Balance of 1203254621 "+walletService.showBalance("1203254621").getWallet().getBalance());
System.out.println("After Fund Transfer balance in 1231231234 "+walletService.fundTransfer("1231231234","1203254621",new BigDecimal(1000)).getWallet().getBalance());




System.out.println("After Fund Transfer in 1203254621 "+walletService.showBalance("1203254621").getWallet().getBalance());

}*/


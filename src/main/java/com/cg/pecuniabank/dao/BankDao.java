package com.cg.pecuniabank.dao;
import com.cg.pecuniabank.entity.Account;
import com.cg.pecuniabank.entity.Customer;


public interface BankDao {

		
		public boolean addCustomer(Customer cust);
		
		public boolean addAccount(Account account);
		
		public boolean editAccount(Account account);
		
		public boolean deleteCustomer(Customer cust);
		
		public boolean deleteAccount(Account account);

		public Account viewAccount(String accId);
		
		public Customer viewCustomer(String aadhar_number);



}

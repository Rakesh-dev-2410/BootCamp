package com.cg.pecuniabank.service;

import com.cg.pecuniabank.dto.BankForm;
import com.cg.pecuniabank.dto.EditForm;
import com.cg.pecuniabank.entity.Account;
import com.cg.pecuniabank.exceptions.InvalidAccountException;
import com.cg.pecuniabank.exceptions.InvalidCustomerException;

public interface BankService {

	public boolean editAccount(EditForm edtfrm) throws InvalidAccountException;
	
	public boolean deleteAccount(String accountId) throws InvalidAccountException;

	public Account viewAccount(String accId) throws InvalidAccountException;
	
	public String addAccount(BankForm bankForm) throws InvalidCustomerException;

}

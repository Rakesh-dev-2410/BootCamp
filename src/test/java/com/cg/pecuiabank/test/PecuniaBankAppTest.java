package com.cg.pecuiabank.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.pecuniabank.dto.BankForm;
import com.cg.pecuniabank.dto.EditForm;
import com.cg.pecuniabank.entity.Account;
import com.cg.pecuniabank.exceptions.InvalidAccountException;
import com.cg.pecuniabank.exceptions.InvalidCustomerException;
import com.cg.pecuniabank.service.BankService;
import com.example.demo.PecuniaBank12Application;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes = PecuniaBank12Application.class)
@AutoConfigureMockMvc
public class PecuniaBankAppTest {

	@Mock
	private BankService bankService;
	
	@Mock
	private BankForm bankForm;
	
	@Mock
	private EditForm editForm;
	
	@Mock
	private Account account;
	
	@Rule
    public ExpectedException expectedThrown = ExpectedException.none();
	
	@Test
	public void addAccountTest() throws InvalidCustomerException {
		when(bankService.addAccount(bankForm)).thenReturn("AccountAddedSuccessful");
		assertEquals("AccountAddedSuccessful", bankService.addAccount(bankForm));
	}
	
	@Test
	public void editAccount() throws InvalidAccountException {
		when(bankService.editAccount(editForm)).thenReturn(true);
		assertEquals(true, bankService.editAccount(editForm));
	}
	
	@Test
	public void deleteAccount() throws InvalidAccountException {
		when(bankService.deleteAccount("79886720091024")).thenReturn(true);
		assertEquals(true, bankService.deleteAccount("79886720091024"));
	}
	
	@Test
	public void viewAccount() throws InvalidAccountException {
		when(bankService.viewAccount("79886720091029")).thenReturn(account);
		assertEquals(account, bankService.viewAccount("79886720091029"));
	}
	/*
	@Test
	public void addAccountTest1() throws InvalidCustomerException {
		expectedThrown.expect(InvalidCustomerException.class);
		//bankService.addAccount(bankForm);
	}
	*/

	
	/*@Test
	public void deleteAccountTest1() throws InvalidAccountException {
		when(bankService.deleteAccount("123456")).thenReturn(false);
       Assert.assertTh
	}
	
	*/
	
	
}

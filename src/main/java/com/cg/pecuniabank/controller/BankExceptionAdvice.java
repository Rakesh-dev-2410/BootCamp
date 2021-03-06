package com.cg.pecuniabank.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.pecuniabank.dto.AccountMessage;
import com.cg.pecuniabank.exceptions.InvalidAccountException;
import com.cg.pecuniabank.exceptions.InvalidCustomerException;
import com.cg.pecuniabank.util.AccountConstants;

@RestControllerAdvice
public class BankExceptionAdvice {

		Logger logger = LoggerFactory.getLogger(BankExceptionAdvice.class);

		@ExceptionHandler(value = { InvalidAccountException.class, InvalidCustomerException.class })
		@ResponseStatus(code = HttpStatus.NOT_FOUND)
		public AccountMessage handleException2(Exception ex) {
			logger.error(ex.getMessage());
			return new AccountMessage(ex.getMessage());
		}

		@ExceptionHandler(value = { DataIntegrityViolationException.class })
		@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = AccountConstants.ACCOUNT_ALREADY_EXISTS)
		public void handleException6(Exception ex) {
			logger.error(ex.getMessage());

		}

}


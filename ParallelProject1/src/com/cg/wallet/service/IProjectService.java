package com.cg.wallet.service;

import com.cg.wallet.bean.Account;
import com.cg.wallet.exception.ProjectException;

public interface IProjectService {
	String createAccount(Account acc) throws ProjectException;
	double showBalance(String moileNo) throws ProjectException;
	Account deposit(String mobileNo, double depositAmt) throws ProjectException;
	Account withdraw(String mobileNo, double withdrawAmt) throws ProjectException;
	boolean fundTransfer(String sourceMobileNo,String destMobileNo,double transferAmt) throws ProjectException;
	Account printTransactionDetails(String mobileNo) throws ProjectException;
	
}

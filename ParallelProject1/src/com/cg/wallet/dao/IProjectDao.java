package com.cg.wallet.dao;

import com.cg.wallet.bean.Account;
import com.cg.wallet.exception.ProjectException;

public interface IProjectDao {
	String createAccount(Account acc) throws ProjectException;
	double showBalance(String moileNo) throws ProjectException;
	Account deposit(String mobileNo) throws ProjectException;
	Account withdraw(String mobileNo) throws ProjectException;
	Account printTransactionDetails(String mobileNo) throws ProjectException;
}

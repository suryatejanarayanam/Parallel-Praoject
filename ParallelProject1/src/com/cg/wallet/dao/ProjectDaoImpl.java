package com.cg.wallet.dao;

import java.util.HashMap;

import com.cg.wallet.bean.Account;
import com.cg.wallet.db.ProjectDb;
import com.cg.wallet.exception.ProjectException;

public class ProjectDaoImpl implements IProjectDao {
	private static HashMap<String, Account> projectMap=ProjectDb.getProjectDb();
	
 	@Override
	public String createAccount(Account acc) throws ProjectException {
		
 		 projectMap.put(acc.getMobileNo(), acc);
		return acc.getMobileNo();
	}

	@Override
	public double showBalance(String moileNo) throws ProjectException {
		
		Account acc = projectMap.get(moileNo);
		if(acc==null){
			throw new ProjectException("The Mobile Number does not exist");
		}
		return acc.getBalance();
	}

	@Override
	public Account deposit(String mobileNo) throws ProjectException {
		
		Account acc = projectMap.get(mobileNo);
		if(acc==null){
			throw new ProjectException("The Mobile Number does not exist");
		}
		return acc;
	}

	@Override
	public Account withdraw(String mobileNo) throws ProjectException {
		
		Account acc = projectMap.get(mobileNo);
		if(acc==null){
			throw new ProjectException("The Mobile Number does not exist");
		}
		return acc;
	}

	@Override
	public Account printTransactionDetails(String mobileNo)
			throws ProjectException {
		
		Account acc = projectMap.get(mobileNo);
		if(acc==null){
			throw new ProjectException("The Mobile Number does not exist");
		}
		return acc;
	}

}

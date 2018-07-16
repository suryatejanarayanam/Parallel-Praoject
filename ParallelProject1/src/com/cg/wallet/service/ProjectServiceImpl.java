package com.cg.wallet.service;

import java.time.LocalDateTime;

import com.cg.wallet.bean.Account;
import com.cg.wallet.dao.IProjectDao;
import com.cg.wallet.dao.ProjectDaoImpl;
import com.cg.wallet.exception.ProjectException;

public class ProjectServiceImpl implements IProjectService {
	IProjectDao impl = new ProjectDaoImpl();

	@Override
	public String createAccount(Account acc) throws ProjectException {
		
		if(!acc.getMobileNo().matches("\\d{10}")){
			throw new ProjectException("Mobile Number Should contains 10 digits");
		}
		if(acc.getName().isEmpty() || acc.getName() == null){
			throw new ProjectException("Name cannot be empty");
		}else{
			if(!acc.getName().matches("[A-Z][A-Za-z]{3,}")){
			throw new ProjectException("Name should start with capital letters and should contain atleast 3 letters");
			}
			if(acc.getEmail().matches("[a-z0-9]+@[a-z]+\\.com")){
			throw new ProjectException("Enter valid EmailId");
			}
			if(acc.getBalance() <= 0){
			throw new ProjectException("Balance should be greater than zero");
			}
		}
		return impl.createAccount(acc);
	}

	@Override
	public double showBalance(String moileNo) throws ProjectException {
		
		if(!moileNo.matches("\\d{10}")){
			throw new ProjectException("Mobile Number Should contains 10 digits");
		}		
		return impl.showBalance(moileNo);
	}

	@Override
	public Account deposit(String mobileNo, double depositAmt) throws ProjectException {

		if(!mobileNo.matches("\\d{10}")){
			throw new ProjectException("Mobile Number Should contains 10 digits");
		}	
		Account acc =impl.deposit(mobileNo);
		if(depositAmt <= 0){
			throw new ProjectException("Deposit balance must be greater than zero");
		}
		acc.setBalance(acc.getBalance()+depositAmt);
		acc.setDate(LocalDateTime.now());
		return acc;
	}

	@Override
	public Account withdraw(String mobileNo,double withdrawAmt) throws ProjectException {
		if(!mobileNo.matches("\\d{10}")){
			throw new ProjectException("Mobile Number Should contains 10 digits");
		}
		Account acc = impl.withdraw(mobileNo);
		if(withdrawAmt > acc.getBalance() || withdrawAmt <= 0){
			throw new ProjectException("The amount to be withdrawn should be greater than available balance and greater than zero");
		}
		acc.setBalance(acc.getBalance() - withdrawAmt);
		acc.setDate(LocalDateTime.now());
		return acc;
	}

	@Override
	public boolean fundTransfer(String sourceMobileNo, String destMobileNo,
			double transferAmt) throws ProjectException {
		
		if(!sourceMobileNo.matches("\\d{10}")){
			throw new ProjectException("Mobile Number Should contains 10 digits");
		}
		if(!destMobileNo.matches("\\d{10}")){
			throw new ProjectException("Mobile Number Should contains 10 digits");
		}
		IProjectService ser=new ProjectServiceImpl();
		Account acc1 = ser.withdraw(sourceMobileNo, transferAmt);
		Account acc2 = ser.deposit(destMobileNo, transferAmt);
		return false;
	}

	@Override
	public Account printTransactionDetails(String mobileNo)
			throws ProjectException {
		// TODO Auto-generated method stub
		return impl.printTransactionDetails(mobileNo);
	}

}

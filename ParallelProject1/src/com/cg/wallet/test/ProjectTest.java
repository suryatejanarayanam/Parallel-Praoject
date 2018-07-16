package com.cg.wallet.test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.cg.wallet.bean.Account;
import com.cg.wallet.exception.ProjectException;
import com.cg.wallet.service.IProjectService;
import com.cg.wallet.service.ProjectServiceImpl;

public class ProjectTest {
	private IProjectService service;

	@Before
	public void init() {
		service = new ProjectServiceImpl();
	}

	@Test
	public void testCreateAccountForMobile() {
		Account ac = new Account();
		ac.setMobileNo("1234");
		ac.setName("Mary");
		ac.setEmail("mary@gmail.com");
		ac.setBalance(200.0);
		try {
			service.createAccount(ac);
		} catch (ProjectException e) {
			assertEquals("Mobile Number Should contains 10 digits", e.getMessage());
		}
	}

	
	@Test
	public void testCreateAccountForName() {
		Account ac = new Account();
		ac.setMobileNo("1234567890");
		ac.setName("mark34");
		ac.setEmail("mark@gmail.com");
		ac.setBalance(500.0);
		try {
			service.createAccount(ac);
		} catch (ProjectException e) {
			assertEquals("Name should start with capital letters and should contain atleast 3 letters", e.getMessage());
		}
	}


	@Test
	public void testCreateAccountForNameIsEmpty() {
		Account ac = new Account();
		ac.setMobileNo("1234567890");
		ac.setName("");
		ac.setEmail("deepu@gmail.com");
		ac.setBalance(200.0);
		try {
			service.createAccount(ac);
		} catch (ProjectException e) {
			assertEquals("Name cannot be empty", e.getMessage());
		}
	}


	@Test
	public void testCreateAccountForEmailId() {
		Account ac = new Account();
		ac.setMobileNo("1234567890");
		ac.setName("DeepikaS");
		ac.setEmail("deepu@@23gmail.com");
		ac.setBalance(200.0);
		try {
			service.createAccount(ac);
		} catch (ProjectException e) {
			assertEquals("Enter valid emailid", e.getMessage());
		}
	}


	@Test
	public void testCreateAccount() {
		Account ac = new Account();
		ac.setMobileNo("1234567890");
		ac.setName("Deepika");
		ac.setEmail("deepu@gmail.com");
		ac.setBalance(200.0);
		try {
				String s=service.createAccount(ac);
				assertNotNull(s);
			} catch (ProjectException e) {
			//System.out.println(e.getMessage());
			}
	}

	@Test
	public void testShowBalanceForMobileNo() {
		/*Account ac=new Account();
		ac.setMobileNo("95059345");*/
		try {
			service.showBalance("95059");
		} catch (ProjectException e) {
			assertEquals("Mobile Number Should contains 10 digits",e.getMessage());
		}
	}

	@Test
	public void testShowBalanceForMobileNoDoesNotExist() {
		/*Account ac=new Account();
		ac.setMobileNo("95059");*/
		try {
			service.showBalance("9505928505");
		} catch (ProjectException e) {
			assertEquals("The Mobile Number does not exist",e.getMessage());
		}
	}


	@Test
	public void testShowBalanceForName() {
		Account ac=new Account();
		ac.setMobileNo("9505929555");
		try {
			service.showBalance(ac.getMobileNo());
			assertEquals("Deepika", ac.getName());
		} catch (ProjectException e) {
			assertEquals("The Mobile Number does not exist",e.getMessage());
		}
	}

	@Test
	public void testDepositForMobileNo() {
		Account ac=new Account();
		ac.setMobileNo("95059345");
		try {
			service.deposit(ac.getMobileNo(), 230);
		} catch (ProjectException e) {
			assertEquals("Mobile Number Should contains 10 digits",e.getMessage());
		}
	}

	@Test
	public void testDepositForMobileNoDoesNotExist() {
		Account ac=new Account();
		ac.setMobileNo("9505934512");
		try {
			service.deposit(ac.getMobileNo(), 230);
		} catch (ProjectException e) {
			assertEquals("The Mobile Number does not exist",e.getMessage());
		}
	}

	@Test
	public void testDepositForDepositAmt() {
		Account ac=new Account();
		ac.setMobileNo("9704814343");
		try {
			service.deposit(ac.getMobileNo(), -230);
		} catch (ProjectException e) {
			assertEquals("Deposit balance must be greater than zero",e.getMessage());
		}
	}


	@Test
	public void testDeposit() {
		Account ac=new Account();
		ac.setMobileNo("9505928555");
		try {
			Account ac1=service.deposit(ac.getMobileNo(), 230);
			assertNotNull(ac1);
		} catch (ProjectException e) {
			System.out.println(e.getMessage());
		}
	}
	

	@Test
	public void testWithDrawForMobileNo() {
		Account ac=new Account();
		ac.setMobileNo("95059345");
		try {
			service.withdraw(ac.getMobileNo(), 230);
		} catch (ProjectException e) {
		assertEquals("Mobile Number Should contains 10 digits",e.getMessage());
		}
	}

	@Test
	public void testWithdrawForMobileNoDoesNotExist() {
		Account ac=new Account();
		ac.setMobileNo("9505934512");
		try {
			service.withdraw(ac.getMobileNo(), 230);
		} catch (ProjectException e) {
			assertEquals("The Mobile Number does not exist",e.getMessage());
		}
	}

	@Test
	public void testWithdrawForAmt() {
		Account ac=new Account();
		ac.setMobileNo("9704814343");
		try {
			service.withdraw(ac.getMobileNo(), -230);
		} catch (ProjectException e) {
			assertEquals("The amount to be withdrawn should be greater than available balance and greater than zero",e.getMessage());
		}
	}

	@Test
	public void testFundTransferForMobileNo() {
		Account ac=new Account();
		Account ac2=new Account();
		ac.setMobileNo("95059345");
		ac2.setMobileNo("1234");
		try {
			service.fundTransfer(ac.getMobileNo(),ac2.getMobileNo(), 230);
		} catch (ProjectException e) {
			assertEquals("Mobile Number Should contains 10 digits",e.getMessage());
		}
	}

	@Test
	public void testFundTransferForMobileNoDoesNotExist() {
		Account ac=new Account();
		Account ac2=new Account();
		ac.setMobileNo("9505934512");
		ac2.setMobileNo("9505934782");
		try {
			service.fundTransfer(ac.getMobileNo(), ac2.getMobileNo(),  230);
		} catch (ProjectException e) {
			Assert.assertEquals("The Mobile Number does not exist",e.getMessage());
		}
	}
	
	@Test
	public void testFundTransferForAmt() {
		Account ac=new Account();
		Account ac2=new Account();
		ac.setMobileNo("9704814343");
		ac2.setMobileNo("9704814346");
		try {
			service.fundTransfer(ac.getMobileNo(), ac2.getMobileNo(),  -230);
		} catch (ProjectException e) {
			Assert.assertEquals("The amount to be withdrawn should be greater than available balance and greater than zero",e.getMessage());
		}
	}

	@Test
	public void testFundTransfer() { 
		Account ac=new Account();
		Account ac2=new Account();
		ac.setMobileNo("9505928555");
		ac2.setMobileNo("9848468242");
		try {
			assertTrue(service.fundTransfer(ac.getMobileNo(), ac2.getMobileNo(),  230));
		} catch (ProjectException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testPrinttransactionDetails() {
		Account ac=new Account();
		ac.setMobileNo("9848468242");
		try {
			Account acc=service.printTransactionDetails(ac.getMobileNo());
			assertNotNull(acc);
		} catch (ProjectException e) {
			System.out.println(e.getMessage());
		}
	}
}

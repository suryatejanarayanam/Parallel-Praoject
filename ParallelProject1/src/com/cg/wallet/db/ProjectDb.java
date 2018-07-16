package com.cg.wallet.db;

import java.time.LocalDateTime;
import java.util.HashMap;

import com.cg.wallet.bean.Account;

public class ProjectDb {
	private static HashMap<String,Account> projectDb= new HashMap<String,Account>();

	public static HashMap<String, Account> getProjectDb() {
		return projectDb;
	}
	Account acc = new Account();
	static{
		projectDb.put("9704814343", new Account("9704814343", "Sai", "sai@gmail.com", 3000.00, LocalDateTime.now()));
		projectDb.put("9704814344", new Account("9704814344", "Moru", "moru@gmail.com", 2500.00, LocalDateTime.now()));
		projectDb.put("9704814345", new Account("9704814345", "Small", "small@gmail.com", 1500.00, LocalDateTime.now()));
		projectDb.put("9704814346", new Account("9704814346", "Kumar", "kumar@gmail.com", 2000.00, LocalDateTime.now()));
	}

}

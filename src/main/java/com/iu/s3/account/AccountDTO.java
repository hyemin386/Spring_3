package com.iu.s3.account;

import java.sql.Date;

public class AccountDTO {

	private String accountNumber;
	private int accountBalance;
	private Date accountDate;
	private String id;
	private int bookNumber;
	
	
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public int getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(int accountBalance) {
		this.accountBalance = accountBalance;
	}
	public Date getAccountDate() {
		return accountDate;
	}
	public void setAccountDate(Date accountDate) {
		this.accountDate = accountDate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getBookNumber() {
		return bookNumber;
	}
	public void setBookNumber(int bookNumber) {
		this.bookNumber = bookNumber;
	}
	

}

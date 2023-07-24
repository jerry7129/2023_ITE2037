package account;

import java.time.LocalDate;

public class Account {
	private String name;
	private double yearlyInterest;
	private double balance;
	private LocalDate created;
	
	public Account(String name, double yearlyInterest, LocalDate created) {
		this.name = name;
		this.yearlyInterest = yearlyInterest;
		this.created = created;
		this.balance = 0;
	}
	public double getBalance() {
		return balance;
	}
	public LocalDate getCreated() {
		return created;
	}
	public void increaseYearlyInterest(int Percent) {
		yearlyInterest += Percent;
	}
	public void receiveIncome(double income) {
		balance += income;
	}
	public void receiveInterest() {
		balance += (balance*yearlyInterest)/12/100;
	}
	public String toString() {
		String str = "";
		str += "이름 : ";
		str += name;
		str += " 연이자 : " ;	
		str += yearlyInterest;
		str += " 잔고 : ";
		str += balance;
		str += " 가입일: ";
		str += created;
		return str;
	}
}

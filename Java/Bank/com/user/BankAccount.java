package com.user;

import java.util.Random;

public class BankAccount {
	private String numberAccount;
	private double balance, savingBalance;
	private static int totalAccounts;
	private static double totalBalance;
	
	public BankAccount() {
		this.totalAccounts ++;
		this.numberAccount = generateNumberAccount();
	}
	private String generateNumberAccount() {
		String numberAccount = "";
		int aux = 0;
		for (int i = 0; i < 10; i++) {
			if (aux == 4) {
				numberAccount += " ";
				aux = 0;
			}
			aux++;
			numberAccount += randomNumber();
		}
		return numberAccount;
	}
	
	private int randomNumber() {
		Random rand = new Random();
		return rand.nextInt(9); 
	}
	public void display(){
		System.out.println("Numero de cuenta = "+ this.numberAccount);
		System.out.println("Cuenta Corriente : $"+this.balance);
		System.out.println("Cuenta de Ahorro : $"+this.savingBalance);
	}
	public double getBalance() {
		
		return balance;
	}
	public double getSavingBalance() {
		return savingBalance;
	}
	public void saveBalance(double cash) {
		System.out.println("Fueron depositados :"+cash+" en la cuenta corriente");
		this.balance += cash;
		double total = BankAccount.getTotalBalance();
		BankAccount.setTotalBalance( total + cash);
	}
	public void saveSavingsBalance(double cash) {
		System.out.println("Fueron depositados :"+cash+" en la cuenta de ahorro");
		this.savingBalance+= cash;
	}
	public void withdrawFunds(double cant) {
	if (cant > this.balance) {
		System.out.println("Fondos insuficientes");
		System.out.println(this.balance);
	}else {
		System.out.println("Se han retirado "+cant+" de la cuenta corriente");
		this.balance -= cant;
		display();
	}
	}
	public void withdrawSavingFunds(double cant) {
		if (cant > this.savingBalance) {
			System.out.println("Fondos insuficientes");
			System.out.println(this.savingBalance);
		}else {
			System.out.println("Se han retirado "+cant+" de la cuenta de ahorro");
			this.savingBalance -= cant;
			display();
		}
		
	}
	public static void setTotalBalance(double d) {
		BankAccount.totalBalance = d;
	}
	public static double getTotalBalance() {
		return totalBalance;
	}
	public static int getTotalAccounts() {
		return totalAccounts;
	}
}

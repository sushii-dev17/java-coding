package com.learning.synchronization;

public class BankAccount {

    private double balance;

    private String name;
    public BankAccount(String name,double balance) {
        this.balance = balance;
        this.name=name;
    }

    public double getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        synchronized (this) {
            this.name = name;
            System.out.println("updated name = " + this.name);
        }
    }

    public  synchronized void deposit(double amount){
        try {
            System.out.println("deposit talking to the teller at the bank.....");
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
       // synchronized (this) {
            double origiBal = balance;
            balance += amount;
            System.out.printf("Starting balance : %.0f, Deposit (%.0f)" +
                    ":New Balance = %.0f%n", origiBal, amount, balance);
        }
  //  }

    public synchronized void withdraw(double amount) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        double origiBal = balance;
        if (amount <= balance) {
            balance -= amount;
            System.out.printf("Starting balance : %.0f, Withdrawl (%.0f)" +
                    ":New Balance = %.0f%n", origiBal, amount, balance);
        }else {
            System.out.printf("Starting balance : %.0f, Withdrawl (%.0f)" +
                    ":Insufficient fund!", origiBal, amount);
        }
    }
}

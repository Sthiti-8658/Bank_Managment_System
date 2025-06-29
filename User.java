package java_projects;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String accountNumber;
    private String name;
    private String pin;
    private double balance;
    private List<Transaction> miniStatement;

    public User(String accountNumber, String name, String pin, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.pin = pin;
        this.balance = balance;
        this.miniStatement = new ArrayList<>();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public String getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        miniStatement.add(new Transaction("Deposit", amount));
    }

    public boolean withdraw(double amount) {
        if (amount > balance) return false;
        balance -= amount;
        miniStatement.add(new Transaction("Withdraw", amount));
        return true;
    }

    public void printMinistatement() {
        System.out.println("Mini Statement for " + name + ":");
        for (Transaction t : miniStatement) {
            System.out.println(t);
        }
    }

    public void showBalance() {
        System.out.printf("Balance: $%.2f\n", balance);
    }

}

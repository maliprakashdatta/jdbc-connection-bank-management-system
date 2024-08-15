package com.swsa.service;
import com.swsa.model.Account;
import com.swsa.model.Customer;
import com.swsa.repository.AccountRepository;
import com.swsa.repository.CustomerRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class AccountService {

    private static final AccountRepository ACCOUNT_REPOSITORY = new AccountRepository();
    private static final CustomerRepository CUSTOMER_REPOSITORY = new CustomerRepository();

    public List<Account> retrieveAccount() {
        return (List<Account>) ACCOUNT_REPOSITORY.retrieveAccount();
    }


    public static void insertAccount() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();

        System.out.print("Enter account holder name: ");
        String accountHolderName = scanner.nextLine();

        System.out.print("Enter initial(Opening)deposit amount: ");
        double balance = scanner.nextDouble();

        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Pls enter Customer ID:");
        int customerId = Integer.parseInt(scanner1.nextLine());
        scanner.nextLine();  // Consume newline

        Customer customer = CUSTOMER_REPOSITORY.retrieveCustomer(customerId);
        Account account1 = new Account(accountNumber, accountHolderName, balance, customer);

        try {
            if (ACCOUNT_REPOSITORY.insertAccount(account1)) {
                System.out.println(" Account Open  successfully!");
            } else {
                System.out.println(" Account not Open .");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    //==================Deposit================================

    public static void insertdepositMoney() throws SQLException {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();

        System.out.print("Enter account holder name: ");
        String accountHolderName = scanner.nextLine();

        System.out.print("Enter Add deposit amount: ");
        double amount = scanner.nextDouble();

        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Pls enter Customer ID:");
        int customerId = Integer.parseInt(scanner1.nextLine());
        scanner.nextLine();  // Consume newline

        Customer customer = CUSTOMER_REPOSITORY.retrieveCustomer(customerId);
        Account account1 = new Account(accountNumber, accountHolderName, amount, customer);

        if ( amount > 0) {
            account1.setBalance(account1.getBalance() + amount);
            System.out.println("Deposited $" + amount + " into account " + account1.getAccountNumber());
        } else {
            System.out.println("Deposit amount must be positive.");
        }
        try {
            if (ACCOUNT_REPOSITORY.insertAccount(account1)) {
                System.out.println(" Deposit Amount   successfully!");
            } else {
                System.out.println(" Account not Open .");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



    public void withdrawMoney() {
    }

    public static void insertwithdrawMoney() {
        double amount;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();

        System.out.print("Enter withdrawal amount: ");
        amount = scanner.nextDouble();

        scanner.nextLine();  // Consume newline
        Account account3 = new Account(accountNumber, amount);

        if (amount > 0 && account3.getBalance() >= amount) {
            account3.setBalance(account3.getBalance() - amount);
            System.out.println("Withdrew $" + amount + " from account " + account3.getAccountNumber());
        } else if (amount > 0 && account3.getBalance() < amount) {
            System.out.println("Insufficient funds for withdrawal.");
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }

        try {
            if (ACCOUNT_REPOSITORY.insertwithdrawMoney(account3)) {
                System.out.println("  withdraw Money  successfully!");
            } else {
                System.out.println("Not withdraw Money  .");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

/*
        public double checkBalance () {
            return 0;
        }

        public static double checkBalance (Account account)
        {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter account number: ");
            String accountNumber = scanner.nextLine();
            // scanner.nextLine();  // Consume newline
            Account account4 = new Account(accountNumber);
            scanner.nextLine();  // Consume newline
            double balance = checkBalance(account);
            System.out.println("The current balance for account " + account.getAccountNumber() + " is $" + balance);
            System.out.println("The balance of account " + account.getAccountNumber() + " is $" + account.getBalance());
            return account4.getBalance();

        }

    }
*/
}














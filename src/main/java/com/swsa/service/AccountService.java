package com.swsa.service;
import com.swsa.model.Account;
import com.swsa.repository.AccountRepository;
import java.sql.SQLException;
import java.util.Scanner;

public class AccountService {

    private static final AccountRepository ACCOUNT_REPOSITORY = new AccountRepository();

    public static void insertCustomerAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();

        System.out.print("Enter account holder name: ");
        String accountHolderName = scanner.nextLine();

        System.out.print("Enter initial deposit amount: ");
        double balance = scanner.nextDouble();

        scanner.nextLine();  // Consume newline
        Account account1 = new Account(accountNumber, accountHolderName, balance);

        try {
            if (ACCOUNT_REPOSITORY.insertCustomerAccount(account1)) {
                System.out.println(" Account Open  successfully!");
            } else {
                System.out.println(" Account not Open .");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public static void insertdepositMoney() {
        double amount;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();

        System.out.print("Enter deposit amount: ");
        amount = scanner.nextDouble();
        scanner.nextLine();
        Account account = new Account(accountNumber, amount);
        try {
            if (ACCOUNT_REPOSITORY.insertdepositMoney(account)) {
                System.out.println(" Deposit Amount  successfully!");
            } else {
                System.out.println(" Account not Open .");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void withdrawMoney()
    {
    }
    public static void insertwithdrawMoney()
    {
        double amount;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();

        System.out.print("Enter withdrawal amount: ");
        amount = scanner.nextDouble();

        scanner.nextLine();  // Consume newline
        Account account3 = new Account(accountNumber, amount);
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


}












package com.swsa.service;
import com.swsa.model.Account;
import com.swsa.repository.AccountRepository;
import java.sql.SQLException;
import java.util.Scanner;

public class AccountService {

    private static final AccountRepository ACCOUNT_REPOSITORY = new AccountRepository();


        public static void insertNewCustomer()        {
            Scanner scanner=new Scanner(System.in);
            System.out.print("Enter account number: ");
            String accountNumber = scanner.nextLine();
            System.out.print("Enter account holder name: ");
            String accountHolderName = scanner.nextLine();
            System.out.print("Enter initial deposit amount: ");
            double amount=scanner.nextDouble();
            scanner.nextLine();  // Consume newline
          Account account1=new Account(accountNumber,accountHolderName,amount);

        try {
            if (ACCOUNT_REPOSITORY.insertNewCustomer(account1)) {
                System.out.println(" Account Open  successfully!");
            } else {
                System.out.println(" Account not Open .");
            }
        } catch (SQLException e)
    {
            throw new RuntimeException(e);
        }

    }}
//
//    private static void depositMoney(double amount)
//    {
//        Scanner scanner=new Scanner(System.in);
//        System.out.print("Enter account number: ");
//        String accountNumber = scanner.nextLine();
//        System.out.print("Enter deposit amount: ");
//        amount = scanner.nextDouble();
//        scanner.nextLine();  // Consume newline
//        Account account=new Account(accountNumber,amount);
//        try {
//            if (ACCOUNT_REPOSITORY.depositMoney( account)) {
//                System.out.println(" Deposit Amount  successfully!");
//            } else {
//                System.out.println(" Account not Open .");
//            }
//        } catch (SQLException e)
//        {
//            throw new RuntimeException(e);
//        }
//
//    }
//
//    private static void withdrawMoney(double amount)
//    {
//        Scanner scanner=new Scanner(System.in);
//        System.out.print("Enter account number: ");
//        String accountNumber = scanner.nextLine();
//        System.out.print("Enter withdrawal amount: ");
//        amount = scanner.nextDouble();
//        scanner.nextLine();  // Consume newline
//        Account account2=new Account(accountNumber,amount);
//        try {
//            if (ACCOUNT_REPOSITORY.withdrawMoney(account2)) {
//                System.out.println("  withdraw Money  successfully!");
//            } else {
//                System.out.println("Not withdraw Money  .");
//            }
//        } catch (SQLException e)
//        {
//            throw new RuntimeException(e);
//        }
//
//    }
//
//
//
//}








package com.swsa.service;
import com.swsa.model.Account;
import com.swsa.repository.AccountRepository;
import java.sql.SQLException;
import java.util.Scanner;

public class AccountService {

        private static final AccountRepository accountRepository= new AccountRepository();

        public static void insertNewAccount() {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Pls enter accountNo:");
            long accountNo = scanner.nextLong();

            System.out.println("Pls enter balance :");//Deposit and withdraw
            double balance = scanner.nextDouble();

            System.out.println("Pls enter mobileNo:");
            long mobileNo = scanner.nextLong();

            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Select account type Saving/Current (S/C): ");
            String accountTypeInput = scanner1.nextLine().trim().toUpperCase();

            String accountType;
            switch (accountTypeInput) {
                case "S":
                    accountType = "Saving";
                    break;
                case "C":
                    accountType = "Current";
                    break;
                default:
                    accountType = "Unspecified";
                    System.out.println("Invalid input, account type set to Unspecified.");
                    break;
            }

            // Output the selected account type
            System.out.println("Selected account type: " + accountType);

           Scanner scanner2 = new Scanner(System.in);
            System.out.println("Pls enter branchName:");
            String branchName = scanner2.nextLine();

           Scanner scanner3 = new Scanner(System.in);
            System.out.println("Pls enter accountHolderName:");
            String accountHolderName = scanner3.nextLine();

           Scanner scanner4 = new Scanner(System.in);

            // Prompt the user for gender selection
            System.out.println("Select gender (M/F/O): ");
            String genderInput = scanner4.nextLine().trim().toUpperCase();

            String gender;
            switch (genderInput) {
                case "M":
                    gender = "Male";
                    break;
                case "F":
                    gender = "Female";
                    break;
                case "O":
                    gender = "Other";
                    break;
                default:
                    gender = "Unspecified";
                    System.out.println("Invalid input, gender set to Unspecified.");
                    break;
            }
            // Output the selected gender
            System.out.println("Selected gender: " + gender);

            Scanner scanner5 = new Scanner(System.in);
            System.out.println("Pls enter bob:");
            String dob = scanner5.nextLine();

            Scanner scanner6 = new Scanner(System.in);
            System.out.println("Pls enter address:");
            String address = scanner6.nextLine();

            Scanner scanner7 = new Scanner(System.in);
            System.out.println("Pls enter EmailId:");
            String emailId = scanner7.nextLine();
            Scanner scanner8 = new Scanner(System.in);
            System.out.println("Pls enter AadhaarNo");
            long aadhaarNo = scanner8.nextLong();

            Account account = new Account(accountNo, balance, mobileNo, accountType, branchName, accountHolderName, gender, dob, address, emailId, aadhaarNo);

            try {
                if (accountRepository.insertNewAccount(account)) {
                    System.out.println(" Account data inserted successfully!");
                } else {
                    System.out.println("Failed to insert CAccount data.");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
}




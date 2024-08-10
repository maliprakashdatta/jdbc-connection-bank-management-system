package com.swsa;
import com.swsa.service.CardService;
import com.swsa.service.ConnectionService;
import com.swsa.service.CustomerService;

import java.io.IOException;
import java.util.Scanner;

public class App {

    private static final ConnectionService connectionService = new ConnectionService();

    public static void main(String[] args) throws IOException {

        CardService cardService=new CardService();
        //AccountService accountService=new AccountService();

        CustomerService customerService=new CustomerService();
        Scanner scanner = new Scanner(System.in);
        int  choice = 0;
        do {

            System.out.println("*** SWAMISAMARTH BANK MANAGEMENT SYSTEM ***");
            System.out.println("_______________________________");
            System.out.println("Select operation:");
            System.out.println("1. Applying Card");
            System.out.println("2. Open New Customer Account");
            System.out.println("3. Deposit Account ");
            System.out.println("4. Withdraw Amount");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            //choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {

                case 1:
                    System.out.println("Applying For Card");
                    cardService.insertCard();
                    break;
                case 2:
                    System.out.println("Applying for new Customer");
                    customerService.insertNewCustomer();

                    break;
                case 3:
                    System.out.println("Deposit Account/Debit ");
                   // accountService.depositMoney();
                    break;
                case 4:
                    System.out.println("Withdraw Account/Credit ");
                    // accountService.insertWithdrawAccount();
                    break;
                case 0:
                    System.out.println("Exiting program");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 0);
        scanner.close();
    }
}
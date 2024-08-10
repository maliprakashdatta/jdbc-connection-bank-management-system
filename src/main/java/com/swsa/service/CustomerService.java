package com.swsa.service;
import com.swsa.model.Customer;
import com.swsa.repository.CustomerRepository;
import java.sql.SQLException;
import java.util.Scanner;
public class CustomerService {


    private static final CustomerRepository CUSTOMER_REPOSITORY = new CustomerRepository();
        public static void insertNewCustomer()
        {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Pls enter accountHolderName:");
            String accountHolderName = scanner.nextLine();

            // Prompt the user for gender selection
            System.out.println("Select gender (M/F/O): ");
            String genderInput = scanner.nextLine().trim().toUpperCase();

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

            System.out.println("Pls enter mobileNo:");
            long mobileNo = scanner.nextLong();

            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Pls enter bob:");
            String dob = scanner1.nextLine();

            Scanner scanner2 = new Scanner(System.in);
            System.out.println("Pls enter address:");
            String address = scanner2.nextLine();

            Scanner scanner3 = new Scanner(System.in);
            System.out.println("Pls enter EmailId:");
            String emailId = scanner3.nextLine();

            Scanner scanner4 = new Scanner(System.in);
            System.out.println("Pls enter AadhaarNo");
            long aadhaarNo = scanner4.nextLong();


           Customer customer=new Customer(accountHolderName,gender,mobileNo,dob,address,emailId,aadhaarNo);

            try {
                if (CUSTOMER_REPOSITORY.insertNewCustomer(customer))
                {
                    System.out.println("Customer data inserted successfully!");
                } else {
                    System.out.println("Failed to Customer info data.");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }

    }







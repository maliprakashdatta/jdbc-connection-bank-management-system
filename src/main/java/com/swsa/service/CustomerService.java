package com.swsa.service;
import com.swsa.model.Customer;
import com.swsa.repository.CustomerRepository;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
public class CustomerService {


    private static final CustomerRepository CUSTOMER_REPOSITORY = new CustomerRepository();

    public List<Customer> retrieveCustomer() {
        return CUSTOMER_REPOSITORY.retrieveCustomer();

    }
    /*
        public static void insertNewCustomer()
        {
            *//*int customerId;
            String name;
            long mobileNo;
            String address;
            String emailId;
            long aadhaarNo;*//*

            Scanner scanner = new Scanner(System.in);
            System.out.println("Pls enter Customer ID:");
            int customerId=scanner.nextInt();

            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Pls enter name :");
            String name = scanner1.nextLine();

            System.out.println("Pls enter mobileNo:");
            long mobileNo = scanner.nextLong();

            Scanner scanner2= new Scanner(System.in);
            System.out.println("Pls enter address:");
            String address = scanner2.nextLine();

            Scanner scanner3= new Scanner(System.in);
            System.out.println("Pls enter EmailId:");
            String emailId = scanner3.nextLine();

            System.out.println("Pls enter AadhaarNo");
            long aadhaarNo = scanner.nextLong();


           Customer customer=new Customer(customerId,name,mobileNo,address,emailId,aadhaarNo);

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
*/
    }







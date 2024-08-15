package com.swsa.repository;
import com.swsa.model.Account;
import com.swsa.model.Customer;
import com.swsa.service.ConnectionService;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class AccountRepository {
    private Connection connection = null;

    private void initConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = new ConnectionService().getConnection();
        }
    }

    public Customer retrieverCustomer(int customerId) {
        return null;
    }

    public Account retrieverAccount(String accountNumber ) {
        return null;
    }

    public List<Account> retrieverAccount() {
        List<Account> accounts = new ArrayList<>();
        // Use the connection to execute SQL queries and interact with the database
        try {
            this.initConnection();
            // Your database operations here...
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM account");
            // Iterate over the result set
            while (resultSet.next()) {

                String accountNumber = resultSet.getString("AccountNumber");
                String accountHolderName = resultSet.getString("AccountHolderName");
                double balance = resultSet.getLong("balance");
                int customerId = resultSet.getInt("customerId");

                // Do something with the data, e.g., print it
                Account account = new Account(accountNumber, accountHolderName, balance, customerId);
                accounts.add(account);
            }
        } catch (SQLException e) {
            System.err.println("SQL error: " + e.getMessage());
        } finally {
            // Close the connection when done
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.err.println("Error closing connection: " + e.getMessage());
                }
            }
        }
        return accounts;
    }


    // Method to update user data into the database
    public boolean insertAccount(Account account) throws SQLException {
        this.initConnection();
        //   int amount = 0;
        String query = "INSERT INTO account VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, account.getAccountNumber());
            preparedStatement.setString(2, account.getAccountHolderName());
            preparedStatement.setDouble(3, account.getBalance());
            preparedStatement.setInt(4, account.getCustomer().getCustomerId());
            System.out.println("  Account created  data successfully .. : " + account);

            int rowsInserted = preparedStatement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Account retrieveAccount() {
        Account account = null;
        // Use the connection to execute SQL queries and interact with the database
        try {
            this.initConnection();
            // Your database operations here...
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM account where accountNumber = " + account);
            // Iterate over the result set
            while (resultSet.next()) {

                String accountNumber = resultSet.getString("AccountNumber");
                String accountHolderName = resultSet.getString("AccountHolderName");
                double balance = resultSet.getLong("balance");
                int customerId = resultSet.getInt("customerId");

                // Do something with the data, e.g., print it
                account = new Account(accountNumber, accountHolderName, balance, customerId);
            }
        } catch (SQLException e) {
            System.err.println("SQL error: " + e.getMessage());
        } finally {
            // Close the connection when done
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.err.println("Error closing connection: " + e.getMessage());
                }
            }
        }
        return account;
    }


    // Method to update user data into the database
    public boolean updateAccount(Account account) throws SQLException {
        this.initConnection();

        String query = "UPDATE account SET   AccountNumber= ?, AccountHolderName= ?, Balance= ?, CustomerId=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, account.getAccountNumber());
            preparedStatement.setString(2, account.getAccountHolderName());
            preparedStatement.setDouble(3, account.getBalance());
            preparedStatement.setInt(4, account.getCustomer().getCustomerId());

            System.out.println("updating  Account data to table: " + account);

            int rowsInserted = preparedStatement.executeUpdate();

            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;




}

    public Object insertAccount(int customerId) {
        return null;
    }

//============================================================================
    //---------------DEPOSIT ACOUNT-----------------------------
//=============================================================================





/*

    public List<Account> retrievedeposit()

    {
        List<Account> accounts = new ArrayList<>();

        // Use the connection to execute SQL queries and interact awith the database
        try {
            this.initConnection();

            // Your database operations here...
            Statement statement = connection.createStatement();
            ResultSet resultSet1 = statement.executeQuery("SELECT * FROM account");

            // Iterate over the result set
            while (ResultSet.next())
            {
                String accountNumber = resultSet1.getString("AccountNumber");
                String accountHolderName = resultSet1.getString("AccountHolderName");
                double balance = resultSet1.getLong("balance");
                int customerId = resultSet1.getInt("customerId");

                // Do something with the data, e.g., print it
                Account account = new Account(accountNumber, balance);
                accounts.add(account);
            }
        } catch (SQLException e) {
            System.err.println("SQL error: " + e.getMessage());
        } finally {
            // Close the connection when done
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.err.println("Error closing connection: " + e.getMessage());
                }
            }
        }
        return accounts;
    }
*/


    // Method to update user data into the database
    public boolean insertdepositMoney(Account account) throws SQLException {
        this.initConnection();
        int amount = 0;
        String query = "INSERT INTO account VALUES (?, ?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, account.getAccountNumber());
            preparedStatement.setString(2, account.getAccountHolderName());
            preparedStatement.setDouble(3, account.getBalance());
            preparedStatement.setInt(4, account.getCustomer().getCustomerId());

            System.out.println("Deposit Money successfully .... : " + account);

            int rowsInserted = preparedStatement.executeUpdate();
            if (amount > 0) {
                account.setBalance(account.getBalance() + amount);
                System.out.println("Deposited $" + amount + " into account " + account.getAccountNumber());
            } else {
                System.out.println("Deposit amount must be positive.");
            }
            return rowsInserted > 0;


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    // Method to update user data into the database
        public boolean updatedepositMoney(Account account) throws SQLException {
            this.initConnection();

            String query = "UPDATE account  SET   AccountNumber= ?,AccountHolderName(),Balance = Amount +  ?,CustomerId=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query))
            {
                preparedStatement.setString(1, account.getAccountNumber());
                preparedStatement.setString(2, account.getAccountHolderName());
                preparedStatement.setDouble(3, account.getBalance());
                preparedStatement.setDouble(4, account.getCustomer().getCustomerId());

                System.out.println("updating  Deposit Money Account data to table: " + account);

                int rowsInserted = preparedStatement.executeUpdate();

               return rowsInserted > 0;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
        }





    public Account retrieverDeposit( String accountNumber) {
        Account account = null;
        // Use the connection to execute SQL queries and interact with the database
        try {
            this.initConnection();
            // Your database operations here...
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM account where accountNumber = " +  accountNumber);
            // Iterate over the result set
            while (resultSet.next()) {

                accountNumber = resultSet.getString("AccountNumber");
                String accountHolderName = resultSet.getString("AccountHolderName");
                double balance = resultSet.getLong("balance");
                int customerId = resultSet.getInt("customerId");

                // Do something with the data, e.g., print it
                account = new Account(accountNumber, balance,accountHolderName,customerId);
            }
        } catch (SQLException e) {
            System.err.println("SQL error: " + e.getMessage());
        } finally {
            // Close the connection when done
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.err.println("Error closing connection: " + e.getMessage());
                }
            }
        }
        return account;
    }


    //================================================================
    //---------------Withdraw Amount -----------------------------
  //====================================================================




    // Method to update user data into the database
    public boolean insertwithdrawMoney(Account account) throws SQLException {
        this.initConnection();
        String query = "INSERT INTO account VALUES (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, account.getAccountNumber());
            preparedStatement.setDouble(2, account.getBalance());
            // preparedStatement.setDouble(4, account.getCustomer().getCustomerId());

            System.out.println("Withdraw Amount successfully .. : " + account);

            int rowsInserted = preparedStatement.executeUpdate();

            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


/*
//----------------CHECK BALANCE-------------

    // Method to update user data into the database
    public boolean checkBalance(Account account) throws SQLException {
        this.initConnection();
        String query = "INSERT INTO account VALUES (?,)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, account.getAccountNumber());

            System.out.println("Balance Check successfully .. : " + account);

            int rowsInserted = preparedStatement.executeUpdate();

            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
*/


}








       // Method to update user data into the database
//        public boolean updateAccount(Account account) throws SQLException {
//            this.initConnection();
//
//            String query = "UPDATE opennewaccount SET   AccountNumber= ?, AccountHolderName= ?, Balance = ?,Amount()";
//            try (PreparedStatement preparedStatement = connection.prepareStatement(query))
//            {
//                preparedStatement.setString(1, account.getAccountNumber());
//                preparedStatement.setString(2, account.getAccountHolderName());
//                preparedStatement.setDouble(3, account.getBalance());
//                preparedStatement.setDouble(4, account.getCustomer().getCustomerId());
//
//                System.out.println("updating  Account data to table: " + account);
//
//                int rowsInserted = preparedStatement.executeUpdate();
//
//                return rowsInserted > 0;
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//            return false;
//        }
//
//        // Method to delete user data into the database
//        public boolean deleteSavingAccount(long CardId) throws SQLException {
//            this.initConnection();
//
//            String query = "DELETE FROM savingaccount WHERE CardId = ?";
//            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
//                preparedStatement.setLong(1,CardId);
//
//                System.out.println("deleting saving account Successfully..: " + CardId);
//
//                int rowsInserted = preparedStatement.executeUpdate();
//
//                return rowsInserted > 0;
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//            return false;
//        }
//    }



package com.swsa.repository;
import com.swsa.model.Account;
import com.swsa.model.Customer;
import com.swsa.service.ConnectionService;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class AccountRepository {


    private static Connection connection = null;

    private void initConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = new ConnectionService().getConnection();
        }
    }

    public Customer retrieverCustomer(int customerId) {
        return null;
    }

    public List<Account> retrieverAccount()

    {
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
            System.out.println("insert  Account  data successfully .. : " + account);

            int rowsInserted = preparedStatement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Account retrieveAccount()
    {
       Account   account = null;
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
        return  account;
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
}




/*




    //---------------DEPOSIT ACOUNT-----------------------------

    public List<Account> retrieveDeposit()
    {
    List<Account> accounts = new ArrayList<>();
    // Use the connection to execute SQL queries and interact awith the database
        try {
        this.initConnection();

        // Your database operations here...
        Statement statement = connection.createStatement();
        ResultSet ResultSet1 = statement.executeQuery("SELECT * FROM account");

        // Iterate over the result set
        while (ResultSet1.next()) {
            String accountNumber = ResultSet1.getString("AccountNumber");
            double balance = ResultSet1.getDouble("balance");


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





// Method to update user data into the database
    public boolean depositMoney(Account account) throws SQLException {
        this.initConnection();
        int balance=0;
        String query = "INSERT INTO account VALUES (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, account.getAccountNumber());
            preparedStatement.setDouble(2, account.getBalance());
            // preparedStatement.setDouble(4, account.getCustomer().getCustomerId());

           System.out.println("insert  data successfully .... : " + account);

            int rowsInserted = preparedStatement.executeUpdate();

            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

/*
//---------------Withdraw Amount -----------------------------

    // Method to update user data into the database
    public boolean insertwithdrawMoney(Account account) throws SQLException {
        this.initConnection();
        String query = "INSERT INTO account VALUES (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, account.getAccountNumber());
            preparedStatement.setDouble(2, account.getBalance());
            // preparedStatement.setDouble(4, account.getCustomer().getCustomerId());

            System.out.println("inseret  data successfully .. : " + account);

            int rowsInserted = preparedStatement.executeUpdate();

            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


//----------------CHECK BALANCE-------------

// Method to update user data into the database
public boolean  checkBalance(Account account) throws SQLException {
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

}

*/




//}
//
//        // Method to update user data into the database
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



package com.swsa.repository;
import com.swsa.model.Account;
import com.swsa.model.Card;
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

    public List<Account> retrieveCard() {
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
                String accountHolderName = ResultSet1.getString("AccountHolderName");
                double balance = ResultSet1.getLong("balance");

                // Do something with the data, e.g., print it
                Account account = new Account(accountNumber, accountHolderName, balance);
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
    public boolean insertCustomerAccount(Account account) throws SQLException {
        this.initConnection();
        String query = "INSERT INTO account VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, account.getAccountNumber());
            preparedStatement.setString(2, account.getAccountHolderName());
            preparedStatement.setDouble(3, account.getBalance());
            // preparedStatement.setDouble(4, account.getCustomer().getCustomerId());

            System.out.println("inseret  data successfully .. : " + account);

            int rowsInserted = preparedStatement.executeUpdate();

            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    //---------------DEPOSIT ACOUNT-----------------------------


    // Method to update user data into the database
    public boolean insertdepositMoney(Account account) throws SQLException {
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



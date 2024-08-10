package com.swsa.repository;
import com.swsa.model.Account;
import com.swsa.service.ConnectionService;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class AccountRepository {


        private static Connection connection = null;

        private void initConnection() throws SQLException {
            if (connection == null || connection.isClosed()) {
                connection = new ConnectionService().getConnection();
            }
        }

//    public void addAccount(Account account) {
//        accounts.put(account.getAccountNumber(), account);
//    }
String accountNumber;
    String accountHolderName;
    double balance;
    double  amount;

    public Map<String,Account> retrieverAccount() {
          Map<String, Account> accountMap = new HashMap<>();
            // Use the connection to execute SQL queries and interact with the database
            try {
                this.initConnection();

                // Your database operations here...
                Statement statement= connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM account ");

                // Iterate over the result set
                while (resultSet.next()) {
                    String accountNumber=resultSet.getString("accountNo");
                    String accountHolderName=resultSet.getString("accountHolderName");
                    //double balance = resultSet.getDouble("balance");
                    double amount = resultSet.getDouble("amount");

                    // Do something with the data, e.g., print it
                    Account account= new Account(accountNumber,accountHolderName,amount);
                    accountMap.put(account.getAccountNumber(), account);
                    //accountMap.add(account);
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
            return accountMap;
        }

        // Method to update user data into the database
        public boolean insertNewCustomer(Account account) throws SQLException {
            this.initConnection();
            String query = "INSERT INTO account VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection. prepareStatement(query)) {

                preparedStatement.setString(1, account.getAccountNumber());
                preparedStatement.setString(2, account.getAccountHolderName());
                //preparedStatement.setDouble(3, account.getBalance());
                preparedStatement.setDouble(3, account.getAmount());

                System.out.println("inseret  data successfully .. : " + account);

                int rowsInserted = preparedStatement.executeUpdate();

                return rowsInserted > 0;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
        }


        // Method to update user data into the database
        public boolean updateAccount(Account account) throws SQLException {
            this.initConnection();

            String query = "UPDATE opennewaccount SET   AccountNumber= ?, AccountHolderName= ?, Balance = ?,Amount()";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query))
            {
                preparedStatement.setString(1, account.getAccountNumber());
                preparedStatement.setString(2, account.getAccountHolderName());
                preparedStatement.setDouble(3, account.getBalance());
                preparedStatement.setDouble(3, account.getAmount());

                System.out.println("updating  Account data to table: " + account);

                int rowsInserted = preparedStatement.executeUpdate();

                return rowsInserted > 0;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
        }

        // Method to delete user data into the database
        public boolean deleteSavingAccount(long CardId) throws SQLException {
            this.initConnection();

            String query = "DELETE FROM savingaccount WHERE CardId = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setLong(1,CardId);

                System.out.println("deleting saving account Successfully..: " + CardId);

                int rowsInserted = preparedStatement.executeUpdate();

                return rowsInserted > 0;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
        }
    }



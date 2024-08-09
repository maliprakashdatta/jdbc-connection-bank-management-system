package com.swsa.repository;
import com.swsa.model.Account;
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
        public List<Account> retrieverAccount() {
            List<Account> accounts = new ArrayList<>();
            // Use the connection to execute SQL queries and interact with the database
            try {
                this.initConnection();

                // Your database operations here...
                Statement statement= connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM account ");

                // Iterate over the result set
                while (resultSet.next()) {
                    long accountNo=resultSet.getLong("accountNo");
                    double balance = resultSet.getDouble("balance");
                    long mobileNo=resultSet.getLong("mobileNo");
                    String accountType=resultSet.getString("accountType");
                    String branchName = resultSet.getString("branchName");
                    String accountHolderName = resultSet.getString("accountHolderName");
                    String gender = resultSet.getString("gender");
                    String dob= resultSet.getString("dob");
                    String address = resultSet.getString("address");
                    String emailId = resultSet.getString("emailId");
                    long aadhaarNo = resultSet.getLong("aadhaarNo");

                    // Do something with the data, e.g., print it

                    Account account= new Account(accountNo, balance,mobileNo,accountType, branchName,accountHolderName, gender, dob, address,  emailId, aadhaarNo);

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
        public boolean insertNewAccount(Account account) throws SQLException {
            this.initConnection();
            String query = "INSERT INTO account VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection. prepareStatement(query)) {

                preparedStatement.setLong(1, account.getAccountNo());
                preparedStatement.setDouble(2, account.getBalance());
                preparedStatement.setLong(3,account.getMobileNo());
                preparedStatement.setString(4, account.getAccountType());
                preparedStatement.setString(5, account.getBranchName());
                preparedStatement.setString(6, account.getAccountHolderName());
                preparedStatement.setString(7,account.getGender());
                preparedStatement.setString(8,account.getDob());
                preparedStatement.setString(9,account.getEmailId());
                preparedStatement.setLong(10,account.getAadhaarNo());

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

            String query = "UPDATE opennewaccount SET   AccountNo= ?, balance= ?, MobileNo = ?," +
                    "AccountType = ?,BranchName= ?,AccountHolderName= ?,Gender= ?,dob= ?,EmailId= ?,AadhaarNo= ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query))
            {
                preparedStatement.setLong(1, account.getAccountNo());
                preparedStatement.setDouble(2, account.getBalance());
                preparedStatement.setLong(3,account.getMobileNo());
                preparedStatement.setString(4, account.getAccountType());
                preparedStatement.setString(5, account.getBranchName());
                preparedStatement.setString(6, account.getAccountHolderName());
                preparedStatement.setString(7,account.getGender());
                preparedStatement.setString(8,account.getDob());
                preparedStatement.setString(9,account.getEmailId());
                preparedStatement.setLong(10,account.getAadhaarNo());

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



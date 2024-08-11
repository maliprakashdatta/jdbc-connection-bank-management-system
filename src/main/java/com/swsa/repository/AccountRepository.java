package com.swsa.repository;
import com.swsa.model.Account;
import com.swsa.service.ConnectionService;
import java.sql.*;


public class AccountRepository {


        private static Connection connection = null;

        private void initConnection() throws SQLException {
            if (connection == null || connection.isClosed()) {
                connection = new ConnectionService().getConnection();
            }
        }

        // Method to update user data into the database
        public boolean insertCustomerAccount(Account account) throws SQLException {
            this.initConnection();
            String query = "INSERT INTO account VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection. prepareStatement(query)) {

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

    // Method to update user data into the database
    public boolean depositMoney(Account account) throws SQLException {
        this.initConnection();
        String query = "INSERT INTO account VALUES (?, ?)";
        try (PreparedStatement preparedStatement = connection. prepareStatement(query)) {

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



package controller;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.CustomerManagementDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerManagementController implements CustomerManagementService {

    @Override
    public void addCustomerDetails(CustomerManagementDetails customerManagementDetails) {
        String SQL="INSERT INTO Customer(CustID, CustTitle, CustName, DOB, salary, CustAddress, City, Province, PostalCode) VALUES(?,?,?,?,?,?,?,?,?);";
        try {
            Connection connection= DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setObject(1,customerManagementDetails.getId());
            preparedStatement.setObject(2,customerManagementDetails.getTitle());
            preparedStatement.setObject(3,customerManagementDetails.getName());
            preparedStatement.setObject(4,customerManagementDetails.getDOB());
            preparedStatement.setObject(5,customerManagementDetails.getSalary());
            preparedStatement.setObject(6,customerManagementDetails.getAddress());
            preparedStatement.setObject(7,customerManagementDetails.getCity());
            preparedStatement.setObject(8,customerManagementDetails.getProvince());
            preparedStatement.setObject(9,customerManagementDetails.getPostalcode());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteCustomerDetails(String id) {
        Connection connection=null;
        try {
            connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Customer WHERE CustId = ?");
            preparedStatement.setObject(1,id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public ObservableList<CustomerManagementDetails> getAllCustomerDetails() {

        ObservableList<CustomerManagementDetails>  customerManagementDetails= FXCollections.observableArrayList();
        try {
            Connection connection= DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement("Select * FROM Customer;");
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                customerManagementDetails.add(new CustomerManagementDetails(
                        resultSet.getString("CustID"),
                        resultSet.getString("CustTitle"),
                        resultSet.getString("CustName"),
                        resultSet.getDate("DOB").toLocalDate(),
                        resultSet.getDouble("salary"),
                        resultSet.getString("CustAddress"),
                        resultSet.getString("City"),
                        resultSet.getString("Province"),
                        resultSet.getString("PostalCode")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customerManagementDetails;

    }
}

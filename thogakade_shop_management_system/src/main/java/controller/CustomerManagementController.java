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
                        resultSet.getString("DOB"),
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

package controller;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.OrderDetailManagementDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDetailManagementController implements OrderDetailManagementService{
    @Override
    public ObservableList<OrderDetailManagementDetails> getAllOrderDetails() {
        ObservableList<OrderDetailManagementDetails>orderDetailManagementDetails= FXCollections.observableArrayList();
        try {
            Connection connection= DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM OrderDetail;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                orderDetailManagementDetails.add(new OrderDetailManagementDetails(
                        resultSet.getString("OrderID"),
                        resultSet.getString("ItemCode"),
                        resultSet.getInt("OrderQTY"),
                        resultSet.getInt("Discount")
                ));




            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orderDetailManagementDetails;
    }
}

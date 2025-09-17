package controller;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.OrderManagementDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderManagementController implements OrderManagementService{
    @Override
    public ObservableList<OrderManagementDetails> getAllOrderDetails() {
        ObservableList<OrderManagementDetails> orderManagementDetails1= FXCollections.observableArrayList();
        String SQL="SELECT * FROM Orders2";
        try {
            Connection connection= DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                orderManagementDetails1.add(new OrderManagementDetails(
                        resultSet.getString("OrderID"),
                        resultSet.getDate("OrderDate").toLocalDate(),
                        resultSet.getString("CustID")
                ));

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orderManagementDetails1;

    }
}

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

    @Override
    public void addOrderDetails(OrderManagementDetails orderManagementDetails) {
        String SQL="INSERT INTO Orders2(OrderID, OrderDate, CustID)VALUES(?,?,?);";
        try {
            Connection connection=DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setObject(1,orderManagementDetails.getId());
            preparedStatement.setObject(2,orderManagementDetails.getDate());
            preparedStatement.setObject(3,orderManagementDetails.getCustId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteOrderDetails(String id) {
        String SQL="DELETE FROM Orders2 WHERE OrderId = ?";
        try {
            Connection connection=DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setObject(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void updateOrderDetails(OrderManagementDetails orderManagementDetails) {
        String SQL="UPDATE Orders2 SET OrderDate = ?, CustID = ? WHERE OrderID = ?";
        try {
            Connection connection=DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setObject(1,orderManagementDetails.getDate());
            preparedStatement.setObject(2,orderManagementDetails.getCustId());
            preparedStatement.setObject(3,orderManagementDetails.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

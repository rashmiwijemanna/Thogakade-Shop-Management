package controller;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.ItemManagementDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemManagementController implements ItemManagementService{
    @Override
    public ObservableList<ItemManagementDetails> getAllItemDetails() {
        ObservableList<ItemManagementDetails> itemManagementDetails= FXCollections.observableArrayList();
        try {
            Connection connection= DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Itemm");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                itemManagementDetails.add(new ItemManagementDetails(
                        resultSet.getString("ItemCode"),
                        resultSet.getString("Description"),
                        resultSet.getString("PackSize"),
                        resultSet.getDouble("UnitPrice"),
                        resultSet.getString("QtyOnHand")

                ));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return itemManagementDetails;
    }

    @Override
    public void addItemDetails(ItemManagementDetails itemManagementDetails) {
        String SQL="INSERT INTO Itemm(ItemCode, Description, PackSize, UnitPrice, QtyOnHand) VALUES(?,?,?,?,?);";

        try {
            Connection connection= DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setObject(1,itemManagementDetails.getCode());
            preparedStatement.setObject(2,itemManagementDetails.getDescription());
            preparedStatement.setObject(3,itemManagementDetails.getPackSize());
            preparedStatement.setObject(4,itemManagementDetails.getUnitPrice());
            preparedStatement.setObject(5,itemManagementDetails.getQty());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteItemDetails(String code) {
        String SQL="DELETE FROM Itemm WHERE ItemCode = ?";
        Connection connection=null;
        try {
            connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setObject(1,code);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}

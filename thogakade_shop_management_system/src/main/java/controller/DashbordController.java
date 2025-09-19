package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class DashbordController {

    Stage customerManagemt=new Stage();
    Stage itemManagement=new Stage();
    Stage orderManagement=new Stage();
    Stage orderDetailManagement=new Stage();

    @FXML
    private Button custbtn;

    @FXML
    private Button itembtn;

    @FXML
    private Button orderbtn;

    @FXML
    private Button orderdetailbtn;

    @FXML
    void custbtnact(ActionEvent event) {
        try {
            customerManagemt.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/customerManagement.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        customerManagemt.show();


    }

    @FXML
    void itembtnact(ActionEvent event) {
        try {
            itemManagement.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/itemManagement.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        itemManagement.show();


    }

    @FXML
    void orderbtnact(ActionEvent event) {
        try {
            orderManagement.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/orderManagement.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        orderManagement.show();


    }

    @FXML
    void orderdetailbtnact(ActionEvent event) {
        try {
            orderDetailManagement.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/orderDetailManagement.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        orderDetailManagement.show();


    }

}

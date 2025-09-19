package controller;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.OrderManagementDetails;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Locale;
import java.util.ResourceBundle;

public class OrderManagementFormController implements Initializable {
    ObservableList<OrderManagementDetails>orderManagementDetails= FXCollections.observableArrayList();
    OrderManagementService orderManagementService=new OrderManagementController();

    @FXML
    private Button ADD;

    @FXML
    private Button CLEAR;

    @FXML
    private Button DELETE;

    @FXML
    private Button UPDATE;

    @FXML
    private TableColumn<?, ?> colCustId;

    @FXML
    private TableColumn<?, ?> colDate;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableView<OrderManagementDetails> orderManagementTbl;

    @FXML
    private TextField txtCustId;

    @FXML
    private DatePicker txtDate;

    @FXML
    private TextField txtId;

    @FXML
    void addBtn(ActionEvent event) {
        String id=txtId.getText();
        LocalDate date=txtDate.getValue();
        String cust_id=txtCustId.getText();

        OrderManagementDetails orderManagementDetails1=new OrderManagementDetails(
                txtId.getText(),
                txtDate.getValue(),
                txtCustId.getText()
        );
        orderManagementService.addOrderDetails(orderManagementDetails1);
        loadOrderTbl();


    }

    @FXML
    void clearBtn(ActionEvent event) {
        txtId.setText(null);
        txtDate.setValue(null);
        txtCustId.setText(null);

    }

    @FXML
    void deletBtn(ActionEvent event) {
        orderManagementService.deleteOrderDetails(txtId.getText());
        loadOrderTbl();


    }

    @FXML
    void updateBtn(ActionEvent event) {
        String order_id=txtId.getText();
        LocalDate order_date=txtDate.getValue();
        String cust_id=txtCustId.getText();


        OrderManagementDetails orderManagementDetails1=new OrderManagementDetails(
                txtId.getText(),
                txtDate.getValue(),
                txtCustId.getText()

        );
        orderManagementService.updateOrderDetails(orderManagementDetails1);

        loadOrderTbl();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colCustId.setCellValueFactory(new PropertyValueFactory<>("custId"));

        loadOrderTbl();
        
        orderManagementTbl.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue,   newValue) -> {
            if (newValue != null){
                setSelectedValue(newValue);
            }
        });



    }
    private void setSelectedValue(OrderManagementDetails selectedValue){
        txtId.setText(selectedValue.getId());
        txtDate.setValue(selectedValue.getDate());
        txtCustId.setText(selectedValue.getCustId());
    }

    private void loadOrderTbl(){
//        String SQL="INSERT INTO Orders2(OrderID, OrderDate, CustID)VALUES(?,?,?);";
        orderManagementDetails.clear();
        orderManagementTbl.setItems(orderManagementService.getAllOrderDetails());

    }
}

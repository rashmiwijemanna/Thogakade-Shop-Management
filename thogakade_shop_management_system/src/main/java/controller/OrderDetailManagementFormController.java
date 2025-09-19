package controller;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.OrderDetailManagementDetails;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class OrderDetailManagementFormController implements Initializable {
    ObservableList<OrderDetailManagementDetails>orderDetailManagementDetails= FXCollections.observableArrayList();
    OrderDetailManagementService orderDetailManagementService= new OrderDetailManagementController();

    @FXML
    private Button ADD;

    @FXML
    private Button CLEAR;

    @FXML
    private Button DELETE;

    @FXML
    private Button UPDATE;

    @FXML
    private TableColumn<?, ?> colDiscount;

    @FXML
    private TableColumn<?, ?> colItemCode;

    @FXML
    private TableColumn<?, ?> colOrderId;

    @FXML
    private TableColumn<?, ?> colOrderQty;

    @FXML
    private TableView<OrderDetailManagementDetails> orderDetailManagementTbl;

    @FXML
    private TextField txtDiscount;

    @FXML
    private TextField txtItemCode;

    @FXML
    private TextField txtOrderId;

    @FXML
    private TextField txtOrderQty;

    @FXML
    void btnAdd(ActionEvent event) {

        OrderDetailManagementDetails orderDetailManagementDetails1=new OrderDetailManagementDetails(
                txtOrderId.getText(),
                 txtItemCode.getText(),
                  Integer.parseInt(txtOrderQty.getText()),
                 Integer.parseInt(txtDiscount.getText())
        );
        orderDetailManagementService.addOrderDetail(orderDetailManagementDetails1);
        loadOrderDetail();


    }

    @FXML
    void btnClear(ActionEvent event) {

    }

    @FXML
    void btnDelete(ActionEvent event) {
        orderDetailManagementService.deleteOrderDetails(txtOrderId.getText());
        loadOrderDetail();

    }

    @FXML
    void btnUpdate(ActionEvent event) {
        String order_id=txtOrderId.getText();
        String item_code=txtItemCode.getText();
        int order_qty=Integer.parseInt(txtOrderQty.getText());
        int discount=Integer.parseInt(txtDiscount.getText());
        OrderDetailManagementDetails orderDetailManagementDetails2=new OrderDetailManagementDetails(
                txtOrderId.getText(),
                txtItemCode.getText(),
                Integer.parseInt(txtOrderQty.getText()),
                Integer.parseInt(txtDiscount.getText())
        );
        orderDetailManagementService.updateOrderDetails(orderDetailManagementDetails2);
        loadOrderDetail();

    }
    private void setSelectedValue(OrderDetailManagementDetails selectedValue){
        txtOrderId.setText(selectedValue.getId());
        txtItemCode.setText(selectedValue.getItemCode());
        txtOrderQty.setText(String.valueOf(selectedValue.getQty()));
        txtDiscount.setText(String.valueOf(selectedValue.getDiscount()));

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colOrderId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colItemCode.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        colOrderQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colDiscount.setCellValueFactory(new PropertyValueFactory<>("discount"));
        loadOrderDetail();
        orderDetailManagementTbl.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) ->{
            if (newValue != null){
                setSelectedValue(newValue);
            }
        } );

    }
    private void loadOrderDetail(){
        orderDetailManagementDetails.clear();
        orderDetailManagementTbl.setItems(orderDetailManagementService.getAllOrderDetails());
    }
}

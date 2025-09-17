package controller;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.ItemManagementDetails;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ItemManagementFormController implements Initializable {
    ObservableList<ItemManagementDetails>itemManagementDetails= FXCollections.observableArrayList();
    ItemManagementService itemManagementService=new ItemManagementController();

    @FXML
    private Button ADD;

    @FXML
    private Button DELETE;

    @FXML
    private Button CLEAR;

    @FXML
    private Button UPDATE;

    @FXML
    private TableColumn<?, ?> colCode;

    @FXML
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colPackSize;

    @FXML
    private TableColumn<?, ?> colQty;

    @FXML
    private TableColumn<?, ?> colUnitPrice;

    @FXML
    private TableView<ItemManagementDetails> itemManagementTbl;

    @FXML
    private TextField txtCode;

    @FXML
    private TextField txtDescription;

    @FXML
    private TextField txtPackSize;



    @FXML
    private TextField txtQty;

    @FXML
    private TextField txtUnitPrice;

    @FXML
    void addBtn(ActionEvent event) {
        String item_code=txtCode.getText();
        String description=txtDescription.getText();
        String pack_size=txtPackSize.getText();
        double unit_price= Double.parseDouble(txtUnitPrice.getText());
        String QTY=txtQty.getText();

        ItemManagementDetails itemManagementDetails1=new ItemManagementDetails(
                txtCode.getText(),
                txtDescription.getText(),
                txtPackSize.getText(),
                Double.parseDouble(txtUnitPrice.getText()),
                txtQty.getText()
        );

        itemManagementService.addItemDetails(itemManagementDetails1);

        loadItemDetails();


    }

    @FXML
    void clearBtn(ActionEvent event) {
        txtCode.setText(null);
        txtDescription.setText(null);
        txtPackSize.setText(null);
        txtUnitPrice.setText(null);
        txtQty.setText(null);

    }

    @FXML
    void updateBtn(ActionEvent event) {
        String item_code=txtCode.getText();
        String description=txtDescription.getText();
        String pack_size=txtPackSize.getText();
        double unit_price=Double.parseDouble(txtUnitPrice.getText());
        String QTY=txtQty.getText();

        ItemManagementDetails itemManagementDetails1=new ItemManagementDetails(
                txtCode.getText(),
                txtDescription.getText(),
                txtPackSize.getText(),
                Double.parseDouble(txtUnitPrice.getText()),
                txtQty.getText()
        );
        itemManagementService.updateItemDetails(itemManagementDetails1);
        loadItemDetails();


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colCode.setCellValueFactory(new PropertyValueFactory<>("code"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colPackSize.setCellValueFactory(new PropertyValueFactory<>("packSize"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));

        loadItemDetails();

        itemManagementTbl.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            if (newValue != null){
                setSelectedValue(newValue);
            }
        });




    }

    private void loadItemDetails(){
        itemManagementDetails.clear();
        itemManagementTbl.setItems(itemManagementService.getAllItemDetails());

    }

    private void setSelectedValue(ItemManagementDetails selectedValue){
        txtCode.setText(selectedValue.getCode());
        txtDescription.setText((selectedValue.getDescription()));
        txtPackSize.setText(selectedValue.getPackSize());
        txtUnitPrice.setText(String.valueOf(selectedValue.getUnitPrice()));
        txtQty.setText(selectedValue.getQty());


    }


    public void deleteBtn(ActionEvent actionEvent) {

        itemManagementService.deleteItemDetails(txtCode.getText());

        loadItemDetails();
    }
}

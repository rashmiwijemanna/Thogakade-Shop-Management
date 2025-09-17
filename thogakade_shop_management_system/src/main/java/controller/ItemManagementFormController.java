package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.ItemManagementDetails;

import java.net.URL;
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


    }

    @FXML
    void clearBtn(ActionEvent event) {

    }

    @FXML
    void updateBtn(ActionEvent event) {

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
    }
}

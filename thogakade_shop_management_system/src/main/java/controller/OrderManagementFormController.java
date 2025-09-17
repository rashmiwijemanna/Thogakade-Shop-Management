package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import model.OrderManagementDetails;

public class OrderManagementFormController  {
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
    private TextField txtCustId;

    @FXML
    private DatePicker txtDate;

    @FXML
    private TextField txtId;

    @FXML
    void addBtn(ActionEvent event) {

    }

    @FXML
    void clearBtn(ActionEvent event) {

    }

    @FXML
    void deletBtn(ActionEvent event) {

    }

    @FXML
    void updateBtn(ActionEvent event) {

    }

}

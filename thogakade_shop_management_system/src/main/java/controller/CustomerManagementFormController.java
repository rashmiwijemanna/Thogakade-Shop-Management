package controller;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.CustomerManagementDetails;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class CustomerManagementFormController implements Initializable {
    ObservableList<CustomerManagementDetails> customerManagementDetails=FXCollections.observableArrayList();
    CustomerManagementService customerManagementService=new CustomerManagementController();

    @FXML
    private Button ADD;

    @FXML
    private TableColumn<?, ?> ADDRESS;

    @FXML
    private TableColumn<?, ?> CITY;

    @FXML
    private Button CLEAR;

    @FXML
    private Button DELETE;

    @FXML
    private TableColumn<?, ?> DOB;

    @FXML
    private TableColumn<?, ?> ID;

    @FXML
    private TableColumn<?, ?> NAME;

    @FXML
    private TableColumn<?, ?> POSTALCODE;

    @FXML
    private TableColumn<?, ?> PROVINCE;

    @FXML
    private TableColumn<?, ?> SALARY;

    @FXML
    private TableColumn<?, ?> TITLE;

    @FXML
    private Button UPDATE;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtCity;

    @FXML
    private DatePicker txtDOB;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPostalCode;

    @FXML
    private TextField txtProvince;

    @FXML
    private TextField txtSalary;

    @FXML
    private TableView<CustomerManagementDetails> customerManagementTbl;

    @FXML
    private ComboBox<String> txtTitle;

    @FXML
    void btnClear(ActionEvent event) {

    }

    @FXML
    void btnDelete(ActionEvent event) {

    }

    @FXML
    void btnUpdate(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> titleTypes= FXCollections.observableArrayList(
                "Mr",
                "Mrs",
                "Miss"
        );
        txtTitle.setItems(titleTypes);

        ID.setCellValueFactory(new PropertyValueFactory<>("id"));
        TITLE.setCellValueFactory(new PropertyValueFactory<>("title"));
        NAME.setCellValueFactory(new PropertyValueFactory<>("name"));
        DOB.setCellValueFactory(new PropertyValueFactory<>("DOB"));
        SALARY.setCellValueFactory(new PropertyValueFactory<>("salary"));
        ADDRESS.setCellValueFactory(new PropertyValueFactory<>("address"));
        CITY.setCellValueFactory(new PropertyValueFactory<>("city"));
        PROVINCE.setCellValueFactory(new PropertyValueFactory<>("province"));
        POSTALCODE.setCellValueFactory(new PropertyValueFactory<>("postalcode"));

       loadCustomerDetails();

       customerManagementTbl.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
           if (newValue != null){
               setSelectedValue(newValue);
           }
       } );



    }

    private void setSelectedValue(CustomerManagementDetails selectedValue){
        txtId.setText(String.valueOf(selectedValue.getId()));
        txtTitle.setValue(selectedValue.getTitle());
        txtName.setText(selectedValue.getName());
        txtDOB.setValue(selectedValue.getDOB());
        txtSalary.setText(String.valueOf(selectedValue.getSalary()));
        txtAddress.setText(selectedValue.getAddress());
        txtCity.setText(selectedValue.getCity());
        txtProvince.setText(selectedValue.getProvince());
        txtPostalCode.setText(selectedValue.getPostalcode());




    }

    private void loadCustomerDetails(){
        customerManagementDetails.clear();
        customerManagementTbl.setItems(customerManagementService.getAllCustomerDetails());
    }

    public void btnAdd(ActionEvent actionEvent) {
        String custId=txtId.getText();
        String custTitle=txtTitle.getValue();
        String custName=txtName.getText();
        LocalDate custDOB=txtDOB.getValue();
        double custSalary=Double.parseDouble(txtSalary.getText());
        String custAddress=txtAddress.getText();
        String custCity=txtCity.getText();
        String custProvince=txtProvince.getText();
        String custPostalCode=txtPostalCode.getText();

        CustomerManagementDetails customerManagementDetails1=new CustomerManagementDetails(
                txtId.getText(),
                txtTitle.getValue(),
                txtName.getText(),
                txtDOB.getValue(),
                Double.parseDouble(txtSalary.getText()),
                txtAddress.getText(),
                txtCity.getText(),
                txtProvince.getText(),
                txtPostalCode.getText()




        );

        customerManagementService.addCustomerDetails(customerManagementDetails1);
        loadCustomerDetails();




    }
}

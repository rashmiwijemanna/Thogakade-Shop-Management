package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.CustomerManagementDetails;

import java.net.URL;
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

    }

    private void loadCustomerDetails(){
        customerManagementDetails.clear();
        customerManagementTbl.setItems(customerManagementService.getAllCustomerDetails());
    }

    public void btnAdd(ActionEvent actionEvent) {


    }
}

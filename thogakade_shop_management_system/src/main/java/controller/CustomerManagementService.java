package controller;

import javafx.collections.ObservableList;
import model.CustomerManagementDetails;

public interface CustomerManagementService {
   ObservableList<CustomerManagementDetails> getAllCustomerDetails();
}

package controller;

import javafx.collections.ObservableList;
import model.CustomerManagementDetails;

public interface CustomerManagementService {
   void addCustomerDetails(CustomerManagementDetails customerManagementDetails);
   void deleteCustomerDetails(String id);
   void updateCustomerDetails(CustomerManagementDetails customerManagementDetails);
   ObservableList<CustomerManagementDetails> getAllCustomerDetails();
}

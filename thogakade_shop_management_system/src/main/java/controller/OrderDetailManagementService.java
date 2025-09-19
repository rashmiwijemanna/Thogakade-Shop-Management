package controller;

import javafx.collections.ObservableList;
import model.OrderDetailManagementDetails;

public interface OrderDetailManagementService {
    ObservableList<OrderDetailManagementDetails>getAllOrderDetails();
}

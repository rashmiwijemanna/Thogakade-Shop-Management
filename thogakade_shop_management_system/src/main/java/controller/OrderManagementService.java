package controller;

import javafx.collections.ObservableList;
import model.OrderManagementDetails;

public interface OrderManagementService {
    ObservableList<OrderManagementDetails>getAllOrderDetails();
}

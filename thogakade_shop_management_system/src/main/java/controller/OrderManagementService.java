package controller;

import javafx.collections.ObservableList;
import model.OrderManagementDetails;

public interface OrderManagementService {
    ObservableList<OrderManagementDetails>getAllOrderDetails();
    void addOrderDetails(OrderManagementDetails orderManagementDetails);
    void deleteOrderDetails(String id);
    void updateOrderDetails(OrderManagementDetails orderManagementDetails);
}

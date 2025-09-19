package controller;

import javafx.collections.ObservableList;
import model.OrderDetailManagementDetails;

public interface OrderDetailManagementService {
    ObservableList<OrderDetailManagementDetails>getAllOrderDetails();
    void addOrderDetail(OrderDetailManagementDetails orderDetailManagementDetails);
    void deleteOrderDetails(String id);
    void updateOrderDetails(OrderDetailManagementDetails orderDetailManagementDetails);
}

package controller;

import javafx.collections.ObservableList;
import model.ItemManagementDetails;

public interface ItemManagementService {
    public ObservableList<ItemManagementDetails> getAllItemDetails();
    void  addItemDetails(ItemManagementDetails itemManagementDetails);
    void deleteItemDetails(String itemCode);
    void updateItemDetails(ItemManagementDetails itemManagementDetails);
}

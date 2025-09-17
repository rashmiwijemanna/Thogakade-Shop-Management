package controller;

import javafx.collections.ObservableList;
import model.ItemManagementDetails;

public interface ItemManagementService {
    public ObservableList<ItemManagementDetails> getAllItemDetails();
}

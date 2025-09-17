package model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString


public class ItemManagementDetails {
    private String code;
    private String description;
    private String packSize;
    private double unitPrice;
    private String qty;

}

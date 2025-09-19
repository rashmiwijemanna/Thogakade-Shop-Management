package model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString


public class OrderDetailManagementDetails {
    private String id;
    private String itemCode;
    private int qty;
    private int discount;
}

package model;

import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class OrderManagementDetails {
    private String id;
    private LocalDate date;
    private String custId;

}

package model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class CustomerManagementDetails {
    private String id;
    private String title;
    private String name;
    private LocalDate DOB;
    private double salary;
    private String address;
    private String city;
    private String province;
    private String postalcode;

}

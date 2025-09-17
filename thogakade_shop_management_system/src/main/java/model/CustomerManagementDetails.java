package model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class CustomerManagementDetails {
    private String id;
    private String title;
    private String name;
    private String DOB;
    private double salary;
    private String address;
    private String city;
    private String province;
    private String postalcode;

}

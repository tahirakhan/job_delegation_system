package com.zealsoft.jds.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class Place {
    @Id
    private String id;
    private String name;
    private String type;
    private String city;
    private String country;
    private String postalCode;
    private String address;
    private Location location;

}

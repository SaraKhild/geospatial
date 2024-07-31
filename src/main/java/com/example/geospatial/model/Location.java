package com.example.geospatial.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
public class Location {

    private String id;
    private String city;
    private double latitude;
    private double longitude;
    private String name;
    private String hotel_name;
    private String zip;

}
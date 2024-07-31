package com.example.geospatial.util;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.example.geospatial.model.Location;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Util {

    public static List<Location> getLocations() {

        Vector<InputStream> inputStreams = new Vector<>();
        InputStream restaurantJson = Util.class.getClassLoader().getResourceAsStream("restaurants.json");
        InputStream hotelJson = Util.class.getClassLoader().getResourceAsStream("hotels.json");

        if (restaurantJson != null) {
            inputStreams.add(restaurantJson);
        }
        if (hotelJson != null) {
            inputStreams.add(hotelJson);
        }

        ObjectMapper mapper = new ObjectMapper();
        List<Location> combinedList = new ArrayList<>();

        try {
            for (InputStream inputStream : inputStreams) {
                List<Location> list = mapper.readValue(inputStream, new TypeReference<List<Location>>() {
                });
                combinedList.addAll(list);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally {
            for (InputStream inputStream : inputStreams) {
                try {
                    inputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return combinedList;
    }

}

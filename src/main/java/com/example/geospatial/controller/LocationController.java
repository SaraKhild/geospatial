package com.example.geospatial.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.geospatial.model.Location;
import com.example.geospatial.service.LocationServcie;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/location")
public class LocationController {

    private final LocationServcie locationServcie;

    @GetMapping("{lo}/{la}")
    public Mono<List<Location>> getLocations(@PathVariable double lo, @PathVariable double la) {

        return locationServcie.geoSearchByLongandLati(lo, la);
    }

    @GetMapping("{zip}")
    public Flux<Location> getRestaurants(@PathVariable String zip) {

        return locationServcie.geoSearchByZipCode(zip);
    }

}
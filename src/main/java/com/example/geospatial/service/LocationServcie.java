package com.example.geospatial.service;

import java.util.List;

import org.redisson.api.GeoUnit;
import org.redisson.api.RGeoReactive;
import org.redisson.api.RMapReactive;
import org.redisson.api.RedissonReactiveClient;
import org.redisson.api.geo.GeoSearchArgs;
import org.redisson.codec.TypedJsonJacksonCodec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.geospatial.model.Location;
import com.example.geospatial.util.Util;

import jakarta.annotation.PostConstruct;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class LocationServcie {

    private final RGeoReactive<Location> geo;
    private final RMapReactive<String, Location> map;

    @Autowired
    public LocationServcie(RedissonReactiveClient client) {

        this.geo = client.getGeo("locations", new TypedJsonJacksonCodec(Location.class));
        this.map = client.getMap("zipcode-locations", new TypedJsonJacksonCodec(String.class, Location.class));
    }

    @PostConstruct
    private void setUpGeospatial() {

        Flux.fromIterable(Util.getLocations())
                .flatMap(location -> geo.add(location.getLongitude(), location.getLatitude(), location)
                        .thenReturn(location))
                .flatMap(location -> map.fastPut(location.getZip(), location))
                .subscribe();
    }

    public Mono<List<Location>> geoSearchByLongandLati(double lo, double la) {

        return geo.search(GeoSearchArgs.from(lo, la)
                .radius(5, GeoUnit.MILES));
    }

    /******************Another Way************************
    public Flux<Location> geoSearch(double lo, double la) {

        return geo.search(GeoSearchArgs.from(lo, la)
                .radius(5, GeoUnit.KILOMETERS)).flatMapIterable(Function.identity());
    }
    */

    public Flux<Location> geoSearchByZipCode(String zipCode) {

        return map.get(zipCode)
                .flatMap(location -> this.geoSearchByLongandLati(location.getLongitude(), location.getLatitude()))
                .flatMapIterable(results -> results);
    }

}

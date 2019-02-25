package com.example.sikubo.model;

public class Route {
    private String id;
    private String code;
    private String name;
    private double lat;
    private double lon;

    public Route(String id, String code, String name, double lat, double lon) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.lat = lat;
        this.lon = lon;
    }

    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }
}

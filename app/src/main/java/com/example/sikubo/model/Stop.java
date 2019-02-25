package com.example.sikubo.model;

public class Stop {
    private String id;
    private String name;
    private double lat;
    private double lon;
    private int locationType;
    private int wheelchairBoarding;
    private int vehicleType;
    private int vehicleTypeSet;

    public Stop(String id, String name, double lat, double lon, int locationType, int wheelchairBoarding, int vehicleType, int vehicleTypeSet) {
        this.id = id;
        this.name = name;
        this.lat = lat;
        this.lon = lon;
        this.locationType = locationType;
        this.wheelchairBoarding = wheelchairBoarding;
        this.vehicleType = vehicleType;
        this.vehicleTypeSet = vehicleTypeSet;
    }

    public String getId() {
        return id;
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

    public int getLocationType() {
        return locationType;
    }

    public int getWheelchairBoarding() {
        return wheelchairBoarding;
    }

    public int getVehicleType() {
        return vehicleType;
    }

    public int getVehicleTypeSet() {
        return vehicleTypeSet;
    }
}

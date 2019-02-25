package com.example.sikubo.model;

public abstract class PublicTransportMotorVehicle {
    private String id;
    private String shortName;
    private String longName;
    private String mode;
    private String color;
    private String agencyName;

    private PublicTransportMotorVehicle(String id, String shortName, String longName, String mode, String color, String agencyName) {
        this.id = id;
        this.shortName = shortName;
        this.longName = longName;
        this.mode = mode;
        this.color = color;
        this.agencyName = agencyName;
    }

    public String getId() {
        return id;
    }

    public String getShortName() {
        return shortName;
    }

    public String getLongName() {
        return longName;
    }

    public String getMode() {
        return mode;
    }

    public String getColor() {
        return color;
    }

    public String getAgencyName() {
        return agencyName;
    }
}

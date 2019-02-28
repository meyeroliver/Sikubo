package com.example.sikubo.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "public_transport_table")
public abstract class PublicTransportMotorVehicle {

    @PrimaryKey
    private String id;
    private String shortName;
    private String longName;
    private String mode;
    private String color;
    private String agencyName;

    public PublicTransportMotorVehicle(String id, String shortName, String longName, String mode, String color, String agencyName) {
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

    public void setId(String id) {
        this.id = id;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }
}

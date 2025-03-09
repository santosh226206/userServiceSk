package com.layp.userService.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


public class Hotel {

    // Attributes
    private String id;
    private String name;
    private String location;
    private int starRating;
    private boolean hasPool;
    private int numberOfRooms;
    private double pricePerNight;

    // Default constructor


    public Hotel() {
    }

    public Hotel(String id, String name, String location, int starRating, boolean hasPool, int numberOfRooms, double pricePerNight) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.starRating = starRating;
        this.hasPool = hasPool;
        this.numberOfRooms = numberOfRooms;
        this.pricePerNight = pricePerNight;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getStarRating() {
        return starRating;
    }

    public void setStarRating(int starRating) {
        this.starRating = starRating;
    }

    public boolean isHasPool() {
        return hasPool;
    }

    public void setHasPool(boolean hasPool) {
        this.hasPool = hasPool;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", starRating=" + starRating +
                ", hasPool=" + hasPool +
                ", numberOfRooms=" + numberOfRooms +
                ", pricePerNight=" + pricePerNight +
                '}';
    }
}


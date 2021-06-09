package com.ilCarro.qa14.models;

public class Car {
    private String country;
    private String address;
    private String distance;
    private String vin;
    private String brand;


    public Car setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    // setters
    public Car setCountry(String country) {
        this.country = country;
        return this;
    }

    public Car setAddress(String address) {
        this.address = address;
        return this;
    }

    public Car setDistance(String distance) {
        this.distance = distance;
        return this;
    }

    public Car setVin(String vin) {
        this.vin = vin;
        return this;
    }

    // getters
    public String getCountry() {
        return country;
    }

    public String getAddress() {
        return address;
    }

    public String getDistance() {
        return distance;
    }

    public String getVin() {
        return vin;
    }

    public String getBrand() {
        return brand;
    }

}

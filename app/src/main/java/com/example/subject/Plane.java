package com.example.subject;

public class Plane {

    private String Brand;
    private int maxSpeed;

    public Plane(String brand, int maxSpeed) {
        Brand = brand;
        this.maxSpeed = maxSpeed;
    }

    public String getBrand() {
        return Brand;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "Brand='" + Brand + '\'' +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}

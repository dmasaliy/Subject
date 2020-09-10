package com.example.subject;

public class Plane2 {
    public String name;
    public int maxSpeed;
    public int lowSpeed;

    public Plane2(String name, int maxSpeed, int lowSpeed) {
        this.name = name;
        this.maxSpeed = maxSpeed;
        this.lowSpeed = lowSpeed;
    }

    public String getName() {
        return name;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getLowSpeed() {
        return lowSpeed;
    }

    @Override
    public String toString() {
        return "Plane2{" +
                "name='" + name + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", lowSpeed=" + lowSpeed +
                '}';
    }


}

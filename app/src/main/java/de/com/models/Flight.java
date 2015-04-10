package com.models;

import java.util.Date;

public class Flight {
    public String flightNumber;

    public Flight(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    @Override
    public String toString(){
        return flightNumber;
    }
}

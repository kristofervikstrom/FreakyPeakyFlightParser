package com.services;

import com.models.Flight;

import java.util.List;

public interface FlightScanService {

    List<Flight> findFlights();
}

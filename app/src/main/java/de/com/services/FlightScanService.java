package de.com.services;


import java.util.List;

import de.com.models.Flight;

public interface FlightScanService {

    List<Flight> findFlights();
}

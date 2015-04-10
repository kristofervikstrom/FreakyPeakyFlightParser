package com.services.hardcoded;

import com.models.Flight;
import com.services.FlightScanService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class HardCodedFlightScan implements FlightScanService {

    @Override
    public List<Flight> findFlights() {
        List<Flight> flights = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat();
        flights.add(new Flight("ABC123"));
        flights.add(new Flight("JEF464"));
        flights.add(new Flight("IKI521"));
        flights.add(new Flight("NIB765"));
        return flights;
    }
}

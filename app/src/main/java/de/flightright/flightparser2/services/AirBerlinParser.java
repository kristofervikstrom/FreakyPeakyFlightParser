package de.flightright.flightparser2.services;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import de.flightright.flightparser2.model.DisplayObject;
import de.flightright.flightparser2.model.Flight;

/**
 * Created by kvikstrom on 10/04/15.
 */
public class AirBerlinParser implements Parser {

    public String content;

    public AirBerlinParser(String content) {
        this.content = content;
    }

    @Override
    public DisplayObject getDisplayObject() {

        DisplayObject displayObject = new DisplayObject();
        displayObject.reservationNumber = getReservationNumber(content);
        displayObject.flightList = getFlights(content);

        return displayObject;
    }

    private String getReservationNumber(String fileToString) {
        List<String> actual = new LinkedList<String>();
        Pattern pattern = Pattern.compile("<td><strong><span style=\"font-size: 14px;\">\\w{6}<br /><br /></span></strong></td>");
        Matcher matcher = pattern.matcher(fileToString);
        while (matcher.find()) {
            actual.add(matcher.group());
        }
        return actual.get(0);
    }

   private List<Flight> getFlights(String fileToString) {
        List<Flight> actual = new LinkedList<Flight>();
        Pattern pattern = Pattern.compile("<td><span style=\"font-size: 14px;\"><strong>\\w+-\\w+\\s-\\s\\w+-\\w+</strong><br />[0-9]{2}.[0-9]{2}.[0-9]{4}</span><br /><span style=\"font-size: 14px;\">\\w+\\s[0-9]{1,4}</span></td>");
        Matcher matcher = pattern.matcher(fileToString);
        while (matcher.find()) {
            Flight flight = new Flight();
            flight.departureAirport = matcher.group(0);
            flight.departureDate = matcher.group(1);
            flight.flightNumber = matcher.group(2);
            actual.add(flight);
        }
        return actual;
   }



}

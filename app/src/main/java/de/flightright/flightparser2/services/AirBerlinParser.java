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

    @Override
    public DisplayObject getDisplayObject() {

        DisplayObject displayObject = new DisplayObject();
        String fileToString = "";

        try {
            File file = new File("res/TestFiles/airberlin.txt");
            FileInputStream is = new FileInputStream(file);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            fileToString = new String(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }

        displayObject.reservationNumber = getReservationNumber(fileToString);
        displayObject.flightList = getFlights(fileToString);

        return displayObject;
    }

    private String getReservationNumber(String fileToString) {
        List<String> actual = new LinkedList<String>();
        Pattern pattern = Pattern.compile("<td width=\"200\"><span style=\"font-size: 14px;\"><strong>Your booking number:<br /><br /> </strong></span></td>\n" +
                "    <td><strong><span style=\"font-size: 14px;\">");
        Matcher matcher = pattern.matcher(fileToString);
        while (matcher.find()) {
            actual.add(matcher.group());
        }
        return actual.get(0);
    }

   private List<Flight> getFlights(String fileToString) {
        List<String> actual = new LinkedList<String>();
        Pattern pattern = Pattern.compile("<td><span style=\"font-size: 14px;\"><strong>Berlin-Tegel - Gothenburg-Landvetter</strong><br />20.12.2014 21:35</span><br /><span style=\"font-size: 14px;\">AB 8304</span></td>");
        Matcher matcher = pattern.matcher(fileToString);
        while (matcher.find()) {
            actual.add(matcher.group());
        }
        return null;
   }

}

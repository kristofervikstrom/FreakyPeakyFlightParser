package de.flightright.flightparser2.services;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by kvikstrom on 10/04/15.
 */
public class ParserFactory {

    public static Parser createParser(String content) {
        List<String> actual = new LinkedList<String>();
        Pattern pattern = Pattern.compile("From: \"airberlin Flight Information\" <preflight-info@backclick.airberlin.com>");
        Matcher matcher = pattern.matcher(content);
        if (matcher.find()) {
            return new AirBerlinParser(content);
        } else {
            return null;
        }

    }

}

/*
 * This code was developed by Edmundo Carrillo on java technologies.
 * Contact: edmundodev@gmail.com
 * Hope you'll find it useful.
 */
package com.tools.Url;

import java.net.MalformedURLException;
import java.net.URL;

public class URLCreator {

    private final String REQUEST_TYPE = "retrieve";
    private final String HOURS_BEFORE_NOW = "3";
    private final String MOST_RECENT = "true";
    private final String FORMAT = "xml";
    private DataSource DATA_SOURCE;

    public URLCreator() {
    }

    public URL getMostRecentAirportReport(String STATION_STRING, DataSource DATA_SOURCE) throws MalformedURLException {
        return new URL("https://aviationweather.gov/adds/dataserver_current/httpparam?"
                + "dataSource=" + DATA_SOURCE + "&"
                + "requestType=" + REQUEST_TYPE + "&"
                + "format=" + FORMAT + "&"
                + "hoursBeforeNow=" + HOURS_BEFORE_NOW + "&"
                + "mostRecent=" + MOST_RECENT + "&"
                + "stationString=" + STATION_STRING + "");
    }

    public URL getSurroundingStations(Double latitude, Double longitude) throws MalformedURLException {
        return new URL("http://api.wunderground.com/api/"
                + "" + DataSource.ACCESSKEY + "/"
                + "geolookup/q/"
                + "" + latitude + "," + longitude + ".xml");
    }

//    public static void main(String[] args) throws MalformedURLException {
//        URL url = new URLCreator().getSurroundingStations(4464.169854, -15.1699818);
//        System.out.println(url.toString());
//    }
}

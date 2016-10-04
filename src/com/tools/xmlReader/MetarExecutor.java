/*
 * This code was developed by Edmundo Carrillo on java technologies.
 * Contact: edmundodev@gmail.com
 * Hope you'll find it useful.
 */
package com.tools.xmlReader;

import com.geolookup.beans.*;
import com.geolookup.beans.NearbyStations;
import com.services.handler.ServiceResponse;
import com.stationReports.beans.Metar;
import com.stationReports.beans.TAF;
import com.tools.Url.URLCreator;
import com.tools.Url.DataSource;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class MetarExecutor {

    public static void main(String[] args) {
        try {
//            //URL url = new URL("https://aviationweather.gov/adds/dataserver_current/httpparam?dataSource=metars&requestType=retrieve&format=xml&stationString=KDEN&hoursBeforeNow=2");
//            URLCreator urlMetar = new URLCreator();
//            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
//            MetarHandler metarHandler = new MetarHandler();
//            xmlReader.setContentHandler(metarHandler);
//            //xmlReader.parse(new InputSource(url.openStream()));
//            xmlReader.parse(new InputSource(urlMetar.getMostRecentAirportReport("MMMX", DataSource.METAR).openStream()));
            ServiceResponse service = new ServiceResponse();
//            List<Metar> metarList = service.getMetarReport("MMMX");
//            
//            for (Metar metar : metarList) {
//                System.out.println(metar.toString());
//                // System.out.println(metar.getSkyConditionList().toString());
//            }

            // System.out.println(service.getNearbyStations(18.92187618976372, -99.21066284179688).getNearby_weather_stations().toString());
            Location loc = service.getNearbyStations(18.92187618976372, -99.21066284179688);
            NearbyStations nb = loc.getNearby_weather_stations();
            List<Station> a = nb.getAirport().getStation();
            List<Station> b = nb.getPws().getStation();

            System.out.println("Lista de aeropuertos cercanos:\n");
            for (Station st : a) {
                System.out.println("Neighborhood:" + st.getNeighborhood());
                System.out.println("City:" + st.getCity());
                System.out.println("State:" + st.getState());
                System.out.println("Country:" + st.getCountry());
                System.out.println("Station_id:" + st.getStation_id());
                System.out.println("Latitude:" + st.getLatitude());
                System.out.println("Longitude:" + st.getLongitude());
                System.out.println("Elevation_m:" + st.getElevation_m());
                System.out.println("Distance_km:" + st.getDistance_km());
                System.out.println("Distance_mi:" + st.getDistance_mi());
                System.out.println("\n\n");
            }

            System.out.println("Lista de pws cercanos:\n");
            for (Station st : b) {
                System.out.println("Neighborhood:" + st.getNeighborhood());
                System.out.println("City:" + st.getCity());
                System.out.println("State:" + st.getState());
                System.out.println("Country:" + st.getCountry());
                System.out.println("Station_id:" + st.getStation_id());
                System.out.println("Latitude:" + st.getLatitude());
                System.out.println("Longitude:" + st.getLongitude());
                System.out.println("Elevation_m:" + st.getElevation_m());
                System.out.println("Distance_km:" + st.getDistance_km());
                System.out.println("Distance_mi:" + st.getDistance_mi());
                System.out.println("\n\n");
            }
            List<TAF> tafList = service.getTAFReport("MMMX");
            
            for (TAF taf : tafList) {
                System.out.println(taf.toString());
                
            }
        } catch (MalformedURLException ex) {
            System.out.println(ex.toString());
        } catch (IOException | SAXException ex) {
            System.out.println(ex.toString());
        }
    }

}

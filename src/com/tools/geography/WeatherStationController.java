/*
 * This code was developed by Edmundo Carrillo on java technologies.
 * Contact: edmundodev@gmail.com
 * Hope you'll find it useful.
 */
package com.tools.geography;

import com.geolookup.beans.Location;
import com.geolookup.beans.Station;
import com.services.handler.ServiceResponse;
import com.stationReports.beans.Metar;
import com.stationReports.beans.TAF;
import com.weatherConditions.beans.BestForecast;
import com.weatherConditions.beans.CurrentObservation;
import java.io.IOException;
import java.util.List;
import org.xml.sax.SAXException;

public class WeatherStationController {

    private final Double latitude;
    private final Double longitude;

    private ServiceResponse serviceResponse;

    public WeatherStationController(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public void getTheMostNearbyStation() throws SAXException, IOException {
        ServiceResponse service = new ServiceResponse();
        Location location = service.getNearbyStations(latitude, longitude);
        Station airportStation = distanceCheck(location.getNearby_weather_stations().getAirport().getStation());
        Station pwsStation = distanceCheck(location.getNearby_weather_stations().getPws().getStation());
//        System.out.println(airportStation.toString());
//        System.out.println(pwsStation.toString());

        if (airportStation.getDistance_km() < pwsStation.getDistance_km()) {
            Metar metar = service.getMetarReport(airportStation.getStation_id()).get(0);
            TAF taf = service.getTAFReport(airportStation.getStation_id()).get(0);

        } else if (pwsStation.getDistance_km() < airportStation.getDistance_km()) {
            CurrentObservation bfObservation = service.getPwsConditions(pwsStation.getStation_id());
            BestForecast bestForecast = service.getPwsForecast(pwsStation.getStation_id());
        }

    }

    private Station distanceCheck(List<Station> stationList) {
        Station auxStation = stationList.get(0);
        for (Station station : stationList) {
            if (station.getDistance_km() < auxStation.getDistance_km()) {
                auxStation = station;
            }
        }
        return auxStation;
    }

    public static void main(String[] args) throws SAXException, IOException {
        new WeatherStationController(18.92187618976372, -99.21066284179688).getTheMostNearbyStation();
        //System.out.println(st.toString());
    }

}

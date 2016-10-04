/*
 * This code was developed by Edmundo Carrillo on java technologies.
 * Contact: edmundodev@gmail.com
 * Hope you'll find it useful.
 */
package com.tools.xmlReader;

import com.weatherConditions.beans.ForecastDay;
import com.weatherConditions.beans.SimpleForecastDay;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class ClasePrueba {

    public static void main(String[] args) throws MalformedURLException, SAXException, IOException {
        URL url = new URL("http://api.wunderground.com/api/5b6df701c02c630d/forecast/lang:SP/q/pws:ICUERNAV3.xml");
        // URLCreator urlMetar = new URLCreator();
        XMLReader xmlReader = XMLReaderFactory.createXMLReader();
        //MetarHandler metarHandler = new MetarHandler();
        BestForecastHandler bestHandler = new BestForecastHandler();
        xmlReader.setContentHandler(bestHandler);
        xmlReader.parse(new InputSource(url.openStream()));
        //System.out.println(bestHandler.getBestForecast().getTxt_forecast().getForecastdays().getForecastday());
        //  xmlReader.parse(new InputSource(urlMetar.getMostRecentAirportReport("MMMX", DataSource.METAR).openStream()));
        List<ForecastDay> bestList = bestHandler.getBestForecast().getTxt_forecast().getForecastdays().getForecastday();
        List<SimpleForecastDay> bestList2 = bestHandler.getBestForecast().getSimple_forecast().getSimpleForecastdays().getSimpleForecastDay();
        
        for (ForecastDay fDay : bestList){
            System.out.println(fDay.getPeriod());
            System.out.println(fDay.getIcon());
            System.out.println(fDay.getIcon_url());
            System.out.println(fDay.getTitle());
            System.out.println(fDay.getFcttext());
            System.out.println(fDay.getFcttext_metric());
            System.out.println(fDay.getPop());
        }
        
//        System.out.println(bestHandler.getBestForecast().getSimple_forecast().toString());
        for (SimpleForecastDay fDay2 : bestList2){
            System.out.println(fDay2.getPeriod());
            System.out.println(fDay2.getIcon());
            System.out.println(fDay2.getIcon_url());
            System.out.println(fDay2.getPop());
        }

    }
}

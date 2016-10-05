/*
 * This code was developed by Edmundo Carrillo on java technologies.
 * Contact: edmundodev@gmail.com
 * Hope you'll find it useful.
 */
package com.tools.xmlReader;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class ClasePrueba2 {

    public static void main(String[] args) throws MalformedURLException, SAXException, IOException {
        URL url = new URL("http://api.wunderground.com/api/5b6df701c02c630d/conditions/q/pws:ICUERNAV3.xml");    
        XMLReader xmlReader = XMLReaderFactory.createXMLReader();       
        ObservationHandler obHandler = new ObservationHandler();
        xmlReader.setContentHandler(obHandler);
        xmlReader.parse(new InputSource(url.openStream()));
        System.out.println(obHandler.getCurrentObservation().toString());
    }
}

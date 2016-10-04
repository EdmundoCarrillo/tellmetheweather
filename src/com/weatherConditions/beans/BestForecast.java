/*
 * This code was developed by Edmundo Carrillo on java technologies.
 * Contact: edmundodev@gmail.com
 * Hope you'll find it useful.
 */
package com.weatherConditions.beans;

public class BestForecast {

    private TxtForecast txt_forecast;
    private SimpleForecast simple_forecast;

    public TxtForecast getTxt_forecast() {
        return txt_forecast;
    }

    public void setTxt_forecast(TxtForecast txt_forecast) {
        this.txt_forecast = txt_forecast;
    }

    public SimpleForecast getSimple_forecast() {
        return simple_forecast;
    }

    public void setSimple_forecast(SimpleForecast simple_forecast) {
        this.simple_forecast = simple_forecast;
    }

    @Override
    public String toString() {
        return "BestForecast{" + "txt_forecast=" + txt_forecast + ", simple_forecast=" + simple_forecast + '}';
    }

}

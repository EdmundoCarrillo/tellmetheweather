/*
 * This code was developed by Edmundo Carrillo on java technologies.
 * Contact: edmundodev@gmail.com
 * Hope you'll find it useful.
 */
package com.stationReports.beans;

public class SkyCondition {

    private String sky_cover;
    private Integer cloud_base_ft_agl;

    public String getSky_cover() {
        return sky_cover;
    }

    public void setSky_cover(String sky_cover) {
        this.sky_cover = sky_cover;
    }

    public Integer getCloud_base_ft_agl() {
        return cloud_base_ft_agl;
    }

    public void setCloud_base_ft_agl(Integer cloud_base_ft_agl) {
        this.cloud_base_ft_agl = cloud_base_ft_agl;
    }

    @Override
    public String toString() {
        return "SkyCondition{" + "sky_cover=" + sky_cover + ", cloud_base_ft_agl=" + cloud_base_ft_agl + '}';
    }

}

package com.resinj.beanparam;

import jakarta.ws.rs.CookieParam;
import jakarta.ws.rs.MatrixParam;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;

public class SearchCriteria {
    @PathParam("propertyType")
    private String propertyType;
    @PathParam("city")
    private String city;
    @MatrixParam("area")
    private String area;
    @QueryParam("floor")
    private int floor;
    @QueryParam("facing")
    private String facing;
    @QueryParam("sqft")
    private int sqft;
    @CookieParam("activeSession")
    private String activeSession;

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getFacing() {
        return facing;
    }

    public void setFacing(String facing) {
        this.facing = facing;
    }

    public int getSqft() {
        return sqft;
    }

    public void setSqft(int sqft) {
        this.sqft = sqft;
    }

    public String getActiveSession() {
        return activeSession;
    }

    public void setActiveSession(String activeSession) {
        this.activeSession = activeSession;
    }

    @Override
    public String toString() {
        return "SearchCriteria{" +
                "propertyType='" + propertyType + '\'' +
                ", city='" + city + '\'' +
                ", area='" + area + '\'' +
                ", floor=" + floor +
                ", facing='" + facing + '\'' +
                ", sqft=" + sqft +
                ", activeSession='" + activeSession + '\'' +
                '}';
    }
}

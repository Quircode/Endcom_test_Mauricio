package com.quircode.test_endcom.Utilities;

public class estacionesVo {
    String Name="";
    String Empty_slots="";
    String Latitude="";
    String Longitude="";

    public estacionesVo(){

    }

    public estacionesVo(String name, String empty_slots, String latitude, String longitude) {
        Name = name;
        Empty_slots = empty_slots;
        Latitude = latitude;
        Longitude = longitude;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmpty_slots() {
        return Empty_slots;
    }

    public void setEmpty_slots(String empty_slots) {
        Empty_slots = empty_slots;
    }

    public String getLatitude() {
        return Latitude;
    }

    public void setLatitude(String latitude) {
        Latitude = latitude;
    }

    public String getLongitude() {
        return Longitude;
    }

    public void setLongitude(String longitude) {
        Longitude = longitude;
    }
}

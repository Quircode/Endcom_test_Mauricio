package com.quircode.test_endcom.Utilities;

public class allBikesInfo {
    private static allBikesInfo mInstance=null;

    String response="";

    public static allBikesInfo getInstance(){
        if(mInstance == null)
        {
            mInstance = new allBikesInfo();
        }
        return mInstance;
    }

    private allBikesInfo(){

    }


    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}

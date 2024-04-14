package com.wwi.api;

import jakarta.ws.rs.Path;

@Path("/parcel")
public class ParcelApiServiceImpl implements ParcelApiService {
    @Override
    public String track(String awbNo) {
        System.out.println("fetching the tracking information for awbNo: " + awbNo);
        return "in-transit";
    }
}

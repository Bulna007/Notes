package com.srl.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path(("/philipsCare"))
public class PhilipsCustomercareApiService {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{city}/locate")
    public String locateUs(@PathParam("city") String city) {
        return "City : " + city + " area: Kondapur";
    }

//    @Path("/stereo")
//    public PhilipsStereoCustomercareApiService stereoCustomercare() {
//        return new PhilipsStereoCustomercareApiService();
//    }
//
//    @Path("/homeAppliances")
//    public PhilipsHomeAppliancesCustomercareApiService homeAppliancesCustomercare() {
//        return new PhilipsHomeAppliancesCustomercareApiService();
//    }

    // dynamic dispatching
    @Path("/{division}")
    public Object locateCustomerCare(@PathParam("division") String division) {
        if(division.equals("stereo")) {
            return new PhilipsStereoCustomercareApiService();
        }else if(division.equals("homeAppliance")) {
            return new PhilipsHomeAppliancesCustomercareApiService();
        }
        return null;
    }

}

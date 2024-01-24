package com.ju5.core;

import java.security.SecureRandom;

public class GeoLocationService {
    public long distanceInKms(String sourceCoordinates, String targetCoordinates) {
        return new SecureRandom().nextLong(3848);
    }
}

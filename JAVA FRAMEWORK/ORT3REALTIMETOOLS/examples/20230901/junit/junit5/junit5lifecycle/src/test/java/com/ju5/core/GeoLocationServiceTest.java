package com.ju5.core;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GeoLocationServiceTest {
    GeoLocationService geoLocationService;

    @BeforeEach
    void init() {
        geoLocationService = new GeoLocationService();
    }

    @Test
    @Tag("functional")
    void testDistanceInKmsInCity() {
        String sourceCoordinates = "(10,34.3)";
        String targetCoordinates = "(11,37.3)";

        long actualDistanceInkms = geoLocationService.distanceInKms(sourceCoordinates, targetCoordinates);
        Assertions.assertTrue(actualDistanceInkms > 0);
    }

    @Test
    @Tag("stress")
    void testDistanceInKmsInState() {
        String sourceCoordinates = "(10,34.3)";
        String targetCoordinates = "(199,37.3)";

        long actualDistanceInkms = geoLocationService.distanceInKms(sourceCoordinates, targetCoordinates);
        Assertions.assertTrue(actualDistanceInkms > 0);
    }

    @Test
    @Tag("performance")
    void testDistanceInKmsInCountry() {
        String sourceCoordinates = "(10,344.3)";
        String targetCoordinates = "(113,374.3)";

        long actualDistanceInkms = geoLocationService.distanceInKms(sourceCoordinates, targetCoordinates);
        Assertions.assertTrue(actualDistanceInkms > 0);
    }

    @Test
    @Tag("performance")
    void testDistanceInKmsAcrossCountries() {
        String sourceCoordinates = "(101,342.3)";
        String targetCoordinates = "(111,372.3)";

        long actualDistanceInkms = geoLocationService.distanceInKms(sourceCoordinates, targetCoordinates);
        Assertions.assertTrue(actualDistanceInkms > 0);
    }

    @AfterEach
    void cleanup() {
        geoLocationService = null;
    }
}

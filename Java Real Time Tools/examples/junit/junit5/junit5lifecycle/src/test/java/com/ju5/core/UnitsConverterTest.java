package com.ju5.core;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledIf;

import java.io.IOException;
import java.util.Properties;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UnitsConverterTest {
    UnitsConverter unitsConverter;

    @BeforeEach
    void init() {
        unitsConverter = new UnitsConverter();
    }

    @Test
    //@EnabledOnOs(OS.WINDOWS)
    //@EnabledOnJre(JRE.JAVA_20)
    //@EnabledForJreRange(min = JRE.JAVA_17,max = JRE.JAVA_22)
    //@EnabledIfEnvironmentVariable(named = "units.feature", matches = "true")
    @EnabledIf("checkForUnitsFeature")
    void testKmsToMeters() {
        int kms = 2;
        long expectedMeters = 2000;

        long actualMeters = unitsConverter.kmsToMeters(kms);
        Assertions.assertEquals(expectedMeters, actualMeters);
    }


    @AfterEach
    void cleanUp() {
        unitsConverter = null;
    }

    public static boolean checkForUnitsFeature() throws IOException {
        Properties props = new Properties();
        props.load(UnitsConverterTest.class.getClassLoader().getResourceAsStream("application.properties"));
        return props.getProperty("units.feature").equals("true");
    }
}

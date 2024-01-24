package com.ju5mock.spy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RouteFinderTest {
    @Mock
    RouteVault routeVault;

    @InjectMocks
    RouteFinder routeFinder;

    List<Hop> expectedRoute;

    @BeforeEach
    void init() {
        Map<Integer, List<Hop>> routes = new HashMap<>();
        routes.put(1, Arrays.asList(new Hop[]{new Hop(1, 3), new Hop(4, 5)}));

        expectedRoute = Arrays.asList(new Hop[]{new Hop(1, 3), new Hop(4, 5)});

        doNothing().when(routeVault).addHopToRoute(1, 1, 3);
        doNothing().when(routeVault).addHopToRoute(2, 4, 3);
        when(routeVault.getRoutes()).thenReturn(routes);
    }

    @Test
    void testFindRoute() {
        routeVault.addHopToRoute(1, 1, 3);
        routeVault.addHopToRoute(2, 4, 3);

        Assertions.assertEquals(expectedRoute, routeFinder.get(1));
    }
}

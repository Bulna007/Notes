package com.ju5mock.spy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RouteVault {
    private Map<Integer, List<Hop>> routes;

    public RouteVault() {
        routes = new HashMap<>();
    }

    public void addHopToRoute(int routeNo, int start, int end) {
        Hop hop = new Hop(start, end);
        List<Hop> hops = routes.getOrDefault(routeNo, new ArrayList<>());
        hops.add(hop);
        routes.put(routeNo, hops);
    }

    public Map<Integer, List<Hop>> getRoutes() {
        return routes;
    }
}

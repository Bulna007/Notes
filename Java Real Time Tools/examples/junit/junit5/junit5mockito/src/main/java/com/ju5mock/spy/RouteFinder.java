package com.ju5mock.spy;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class RouteFinder {
    private RouteVault routeVault;


    public List<Hop> get(int routeNo) {
        return routeVault.getRoutes().get(routeNo);
    }

}

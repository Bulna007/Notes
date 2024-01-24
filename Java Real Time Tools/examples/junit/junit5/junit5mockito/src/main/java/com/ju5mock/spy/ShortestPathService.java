package com.ju5mock.spy;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Stream.of;

@AllArgsConstructor
public class ShortestPathService {
    private final HopComputeService hopComputeService;

    public long shortestPath(List<Hop[]> routes) {
        Hop[] route = null;
        long length = 0;
        List<Long> routeLengths = null;

        routeLengths = new ArrayList<>();
        for (int i = 0; i < routes.size(); i++) {
            length = 0;
            route = routes.get(i);
            length = of(route).map(hop -> {
                if (hopComputeService.isReverseHop(hop)) {
                    return Integer.MAX_VALUE;
                } else {
                    return hopComputeService.distance(hop);
                }
            }).mapToLong(n -> (long) n).sum();
            routeLengths.add(length);
        }
        return routeLengths.stream().sorted().findFirst().get();
    }
}

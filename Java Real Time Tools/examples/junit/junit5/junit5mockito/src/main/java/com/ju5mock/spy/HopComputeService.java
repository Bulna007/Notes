package com.ju5mock.spy;

public class HopComputeService {
    public int distance(Hop hop) {
        return Math.abs(hop.getEnd() - hop.getStart());
    }

    public boolean isReverseHop(Hop hop) {
        return hop.getEnd() < hop.getStart();
    }
}

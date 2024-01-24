package com.ju5mock.spy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ShortestPathServiceTest {
    @Spy
    HopComputeService hopComputeService;
    @InjectMocks
    ShortestPathService shortestPathService;
    List<Hop[]> routes;
    long expectedShortestPath;

    @BeforeEach
    void init() {
        routes = Arrays.asList(new Hop[][]{
                {new Hop(1, 3), new Hop(3, 8), new Hop(8, 5)},
                {new Hop(1, 3), new Hop(3, 4), new Hop(4, 5)}
        });
        expectedShortestPath = 4;

        Mockito.when(hopComputeService.distance(new Hop(1, 3))).thenReturn(2);
        Mockito.when(hopComputeService.distance(new Hop(3, 8))).thenReturn(5);
        Mockito.when(hopComputeService.distance(new Hop(3, 4))).thenReturn(1);
        Mockito.when(hopComputeService.distance(new Hop(4, 5))).thenReturn(1);
    }

    @Test
    public void shortestPathTest() {
        Assertions.assertEquals(expectedShortestPath, shortestPathService.shortestPath(routes));
    }

}

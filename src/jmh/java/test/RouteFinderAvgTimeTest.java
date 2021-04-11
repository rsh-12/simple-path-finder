package test;
/*
 * Date: 4/11/21
 * Time: 6:35 PM
 * */

import org.example.shortestpath.RouteFinder;
import org.example.shortestpath.RouteFinderImpl;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class RouteFinderAvgTimeTest {

    /*
     * With heuristic method:
     * (min, avg, max) = (12417.534, 13650.079, 14542.934)
     *
     * Without heuristic method:
     * (min, avg, max) = (23520.236, 25412.077, 27387.689)
     * */

    @Benchmark
    public void testAvgTime() {
        RouteFinder routeFinder = new RouteFinderImpl();
        routeFinder.findRoute(getMap());
    }

    private char[][] getMap() {
        return new char[][]{
                {'.', '.', '.', '.', '.', '.', '.', '.', '.', '#', '.', '#', '.', '.', '.'},
                {'#', '#', '#', '#', '#', '.', '#', '#', '.', '.', '.', '.', '.', '#', '@'},
                {'.', '#', '.', '.', '.', '#', '.', '.', '.', '.', '#', '.', '#', '.', '#'},
                {'.', '.', '.', '#', '.', '.', '.', '.', '.', '#', '.', '.', '.', '.', '.'},
                {'#', '.', '.', '.', '.', '.', '.', '#', '.', '.', '.', '.', '#', '.', '.'},
                {'.', '.', '#', '.', '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#'},
                {'.', '#', '.', '.', '.', '.', '.', '.', '#', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '#', '.', '.', '#', '.', '.', '.', '#', '.', '.', '.', '.'},
                {'#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '#', '.', '#', '.', '.', '#', '.', '.', '.', '#', '.', '.'},
                {'.', '.', '#', '.', '.', '.', '.', '.', '.', '.', '#', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '#', '.', '.', '.', '.', '.', '.', '.', '.', '#', '.'},
                {'.', '.', '.', '#', 'X', '#', '.', '.', '.', '#', '.', '.', '.', '.', '.'},
                {'.', '#', '.', '.', '.', '.', '.', '#', '.', '.', '.', '#', '.', '.', '#'}
        };
    }

}

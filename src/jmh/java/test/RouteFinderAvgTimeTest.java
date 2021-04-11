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
     *
     *
     * Without heuristic method:
     *
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

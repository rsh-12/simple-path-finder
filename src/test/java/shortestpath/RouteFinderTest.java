package shortestpath;

import org.example.shortestpath.RouteFinderImpl;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class RouteFinderTest extends HelperAbstractClass {

    RouteFinderImpl routeFinder;

    @Test
    public void testPathFound_Map1() {

        routeFinder = new RouteFinderImpl();

        char[][] map = getMap("map1");
        char[][] route = routeFinder.findRoute(map);

        assertNotNull(route);
        printMap(route);
    }


    @Test
    public void testPathNotFound_Map2() {

        routeFinder = new RouteFinderImpl();

        char[][] map = getMap("map2");
        char[][] route = routeFinder.findRoute(map);

        assertNull(route);
    }

    @Test
    public void testPathFound_Map3() {

        routeFinder = new RouteFinderImpl();

        char[][] map = getMap("map3");
        char[][] route = routeFinder.findRoute(map);

        assertNotNull(route);
        printMap(route);
    }


    @Test
    public void testPathFound_Map4() {

        routeFinder = new RouteFinderImpl();

        char[][] map = getMap("map4");
        char[][] route = routeFinder.findRoute(map);

        assertNotNull(route);
        printMap(route);
    }

    @Test
    public void testGenerateMatrix() {

        routeFinder = new RouteFinderImpl();
        char[][] map = generateMatrix(10_000, 10_000);
        char[][] route = routeFinder.findRoute(map);
        assertNotNull(route); // NOTE: if route == null then the shortest path does not exist
    }

}

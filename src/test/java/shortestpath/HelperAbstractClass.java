package shortestpath;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


abstract class HelperAbstractClass {

    void printMap(char[][] map) {
        for (char[] row : map) {
            System.out.println(row);
        }
    }

    protected char[][] getMap(String mapName) {
        char[][] map1 = {
                {'.', '.', '.', '@', '.'},
                {'.', '#', '#', '#', '#'},
                {'.', '.', '.', '.', '.'},
                {'#', '#', '#', '#', '.'},
                {'.', 'X', '.', '.', '.'}
        };


        char[][] map2 = {
                {'.', '.', 'X', '.', '.'},
                {'#', '#', '#', '#', '#'},
                {'.', '.', '.', '.', '.'},
                {'.', '@', '.', '.', '.'},
                {'.', '.', '.', '.', '.'}
        };

        char[][] map3 = {
                {'.', '.', '.', '.', '@'},
                {'#', '.', '#', '#', '#'},
                {'.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', 'X'},
                {'.', '.', '.', '.', '.'}
        };

        char[][] map4 = {
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

        Map<String, char[][]> maps = new HashMap<>() {{
            put("map1", map1);
            put("map2", map2);
            put("map3", map3);
            put("map4", map4);
        }};
        return maps.get(mapName);
    }

    protected char[][] generateMatrix(int row, int column) {

        char[][] map = new char[row][column];

        for (char[] i : map) {
            Arrays.fill(i, '.');
            for (int j = 1; j < column / 4; j++) {
                i[getRandomNum(column)] = '#';
            }
        }

        map[0][getRandomNum(column)] = '@';
        map[map.length - 1][getRandomNum(column)] = 'X';

        return map;
    }

    private int getRandomNum(int column) {
        return (int) (Math.random() * column);
    }

}

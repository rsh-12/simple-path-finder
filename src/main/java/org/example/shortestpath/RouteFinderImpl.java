package org.example.shortestpath;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class RouteFinderImpl implements RouteFinder {

    // For reconstructing the shortest path
    private final Map<Node, Node> pathStoreMap = new HashMap<>();
    private final Queue<Node> queue = new ArrayDeque<>();

    // Array used to track visited nodes
    private boolean[][] visited;

    // Direction vectors
    private final int[] dr = {-1, 1, 0, 0};
    private final int[] dc = {0, 0, 1, -1};

    // Starting point index
    private int startRow;
    private int startColumn;

    // End point index
    private int endRow;
    private int endColumn;

    // Var used to track whether the end point ever gets reached during the A*
    private boolean reachedEnd = false;

    @Override
    public char[][] findRoute(char[][] map) {

        if (map == null) {
            throw new IllegalArgumentException("Map cannot be null");
        }

        // A function that searches the '@' and the 'X' characters and initializes their indices
        findStartEndPoints(map);

        // Init with false values (ROW x COLUMN)
        visited = new boolean[map.length][map[0].length];
        visited[startRow][startColumn] = true;

        return searchPath(map, new Node(startRow, startColumn));
    }

    private char[][] searchPath(char[][] map, Node start) {

        // Define the end point ('@' or 'X')
        char destination = map[endRow][endColumn];

        queue.add(start);
        Node endNode = null;

        while (!queue.isEmpty()) {

            Node from = heuristic(queue);
            if (map[from.getRow()][from.getColumn()] == destination) {
                reachedEnd = true;
                break;
            }

            // Explore neighbours
            for (int i = 0; i < dr.length; i++) {
                int rr = from.getRow() + dr[i];
                int cc = from.getColumn() + dc[i];

                // Skip out of bounds locations
                if (rr < 0 || cc < 0) continue;
                if (rr >= map.length || cc >= map[0].length) continue;

                // Skip visited locations or blocked cells
                if (visited[rr][cc]) continue;
                if (map[rr][cc] == '#') continue;

                visited[rr][cc] = true;
                Node nextNode = new Node(rr, cc);
                queue.add(nextNode);
                pathStoreMap.put(nextNode, from);

                if (map[rr][cc] == destination) {
                    endNode = new Node(rr, cc);
                    reachedEnd = true;
                    break;
                }
            }
        }

        if (reachedEnd) {
            while (true) {
                Node fromNode = pathStoreMap.get(endNode);
                if (fromNode == start || fromNode == null) break;
                endNode = fromNode;
                map[fromNode.getRow()][fromNode.getColumn()] = '+';
            }
        }

        return reachedEnd ? map : null;
    }

    private Node heuristic(Queue<Node> queue) {

        if (queue.size() == 1) {
            return queue.poll();
        }

        int minCost = Integer.MAX_VALUE;
        Node bestNode = null;

        for (Node node : queue) {
            int costNodeToGoal = Math.abs(node.getRow() - endRow) + Math.abs(node.getColumn() - endColumn);
            int totalCost = node.getCost() + costNodeToGoal;

            if (minCost > totalCost) {
                minCost = totalCost;
                bestNode = node;
            }
        }
        queue.remove(bestNode);
        return bestNode;
    }

    private void findStartEndPoints(char[][] map) {
        outerloop:
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == '@' || map[i][j] == 'X') {
                    startRow = i;
                    startColumn = j;
                    break outerloop;
                }
            }
        }

        outerloop:
        for (int i = map.length - 1; i >= 0; i--) {
            for (int j = map[i].length - 1; j >= 0; j--) {
                if (map[i][j] == '@' || map[i][j] == 'X') {
                    endRow = i;
                    endColumn = j;
                    break outerloop;
                }
            }
        }
    }
}

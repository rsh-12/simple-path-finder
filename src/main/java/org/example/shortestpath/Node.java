package org.example.shortestpath;

final class Node {
    private final int row;
    private final int column;

    public Node(int row, int column) {
        this.row = row;
        this.column = column;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        if (row != node.row) return false;
        return column == node.column;
    }

    @Override
    public int hashCode() {
        int result = row;
        result = 31 * result + column;
        return result;
    }

    @Override
    public String toString() {
        return "Node{" +
                "row=" + row +
                ", column=" + column +
                '}';
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int getCost() {
        return 1;
    }
}

package org.example.shortestpath;

/*
 * Интерфейс поиска маршрута
 * */
public interface RouteFinder {
    /*
     * Поиск кратчайшего маршрута между двумя точками
     * @param map карта
     * @return карта с построенным маршрутом
     * */
    char[][] findRoute(char[][] map);
}

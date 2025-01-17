import structura.structurImpl.MyArrayListIml;

import structura.structurImpl.MyArrayListIml;

public class Main {
    public static void main(String[] args) {
        NavigatorImpl navigator = new NavigatorImpl();

        // Создание маршрутов
        MyArrayListIml<String> points1 = new MyArrayListIml<>();
        points1.add("A");
        points1.add("B");
        points1.add("C");
        Route route1 = new Route(points1, true, 10, 25.5, "1");

        MyArrayListIml<String> points2 = new MyArrayListIml<>();
        points2.add("D");
        points2.add("E");
        points2.add("F");
        Route route2 = new Route(points2, false, 5, 15.3, "2");

        MyArrayListIml<String> points3 = new MyArrayListIml<>();
        points3.add("A");
        points3.add("G");
        points3.add("H");
        Route route3 = new Route(points3, false, 15, 42.1, "3");

        MyArrayListIml<String> points4 = new MyArrayListIml<>();
        points4.add("X");
        points4.add("Y");
        points4.add("Z");
        Route route4 = new Route(points4, true, 2, 45.2, "4");

        // Добавление маршрутов в навигатор
        navigator.addRoute(route1);
        navigator.addRoute(route2);
        navigator.addRoute(route3);
        navigator.addRoute(route4);

        // Количество маршрутов
        System.out.println("Общее количество маршрутов: " + navigator.size());

        // Проверка наличия маршрута
        System.out.println("Содержит маршрут 1: " + navigator.contains(route1));

        // Удаление маршрута
        navigator.removeRoute("2");
        System.out.println("Количество маршрутов после удаления: " + navigator.size());

        // Получение маршрута по ID
        Route retrievedRoute = navigator.getRoute("3");
        System.out.println("Маршрут с ID 3: " + retrievedRoute);

        // Увеличение популярности маршрута
        navigator.chooseRoute("3");
        System.out.println("Популярность маршрута 3 после выбора: " + retrievedRoute.getPopularity());

        // Поиск маршрутов от A до C
        System.out.println("Маршруты от A до C:");
        for (Route route : navigator.searchRoutes("A", "C")) {
            System.out.println(route);
        }

        // Избранные маршруты, содержащие точку G
        System.out.println("Избранные маршруты с точкой G:");
        for (Route route : navigator.getFavoriteRoutes("G")) {
            System.out.println(route);
        }

        // Топ-3 маршрута по популярности
        System.out.println("Топ-3 маршрута по популярности:");
        for (Route route : navigator.getTop3Routes()) {
            System.out.println(route);
        }
    }
}

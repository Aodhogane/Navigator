package com.example.navigation;

import com.example.navigation.structura.structurImpl.MyArrayListIml;

public class Main {
    public static void main(String[] args) {
        NavigatorImpl navigator = new NavigatorImpl();

        MyArrayListIml<String> point1 = new MyArrayListIml<>();
        point1.add("Улан-Удэ");
        point1.add("Надым");
        point1.add("Москва");
        Route route1 = new Route("1", 8.2, 6, false, point1);

        MyArrayListIml<String> point2 = new MyArrayListIml<>();
        point2.add("Улан-Удэ");
        point2.add("Елец");
        point2.add("Варшава");
        point2.add("Москва");
        Route route2 = new Route("2", 8.2, 5, false, point2);

        MyArrayListIml<String> point3 = new MyArrayListIml<>();
        point3.add("Магнитогорск");
        point3.add("Москва");
        point3.add("Елец");
        point3.add("Сочи");
        Route route3 = new Route("3", 8.2, 6, false, point3);

        MyArrayListIml<String> point4 = new MyArrayListIml<>();
        point4.add("Улан-Удэ");
        point4.add("Москва");
        Route route4 = new Route("4", 8.2, 6, false, point4);

        MyArrayListIml<String> point5 = new MyArrayListIml<>();
        point5.add("Кипр");
        point5.add("Елец");
        point5.add("Пекин");
        Route route5 = new Route("5", 8.2, 6, false, point5);

        navigator.addRoute(route1);
        navigator.addRoute(route2);
        navigator.addRoute(route3);
        navigator.addRoute(route4);
        navigator.addRoute(route5);

        System.out.println("Полный список маршрутов:");
        for (int i = 0; i < navigator.size(); i++) {
            System.out.println(navigator.getRoute(String.valueOf(i + 1)));
        }
        System.out.println();

        System.out.println("Общее количество маршрутов: " + navigator.size() + "\n");

        System.out.println("Содержит ли указанный маршрута 5: " + navigator.contains(route5) + "\n");

        System.out.println("Найден маршрут с ID: ");
        Route foundRoute = navigator.getRoute("5");
        if (foundRoute != null) {
            System.out.println(foundRoute);
        }
        System.out.println();

        navigator.chooseRoute("2");
        System.out.println("Обновление популярности для маршрута ID = 2: " + route2.getPopularity() + "\n");

        System.out.println("Маршрут с Улан-Удэ до Москвы: ");
        Iterable<Route> searchResults = navigator.searchRoutes("Улан-Удэ", "Москва");
        for (Route r : searchResults) {
            System.out.println(r);
        }
        System.out.println();

        System.out.println("Избранные маршруты: ");
        Iterable<Route> favoriteRoutes = navigator.getFavoriteRoutes("Елец");
        for (Route r : favoriteRoutes) {
            System.out.println(r);
        }
        System.out.println();

        System.out.println("Топ-3 маршрута: ");
        Iterable<Route> topRoutes = navigator.getTop3Routes();
        for (Route r : topRoutes) {
            System.out.println(r);
        }
        System.out.println();

        navigator.removeRoute("2");
        System.out.println("Общее количество маршрутов после удаления: " + navigator.size() + "\n");
    }
}
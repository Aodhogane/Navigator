package com.example.navigation;

import com.example.navigation.structura.structurImpl.MyArrayListIml;

public class Main {
    public static void main(String[] args) {
        // Создаем экземпляр Navigator
        NavigatorImpl navigator = new NavigatorImpl();

        MyArrayListIml<String> point1 = new MyArrayListIml<>();
        point1.add("Москва");
        point1.add("Санкт-Петербург");
        point1.add("Надым");
        Route route1 = new Route("1", 10.2, 10, false, point1);

        MyArrayListIml<String> point2 = new MyArrayListIml<>();
        point2.add("Елец");
        point2.add("Варшава");
        Route route2 = new Route("2", 10.2, 10, true, point2);

        MyArrayListIml<String> point3 = new MyArrayListIml<>();
        point3.add("Магнитогорск");
        point3.add("Сочи");
        Route route3 = new Route("3", 10.2, 10, false, point3);

        MyArrayListIml<String> point4 = new MyArrayListIml<>();
        point4.add("Улан-Удэ");
        point4.add("Париж");
        Route route4 = new Route("4", 10.2, 10, false, point4);

        // Добавляем маршруты в Navigator
        navigator.addRoute(route1);
        navigator.addRoute(route2);
        navigator.addRoute(route3);
        navigator.addRoute(route4);

        // Выводим размер коллекции маршрутов
        System.out.println("Общее количество маршрутов: " + navigator.size() + "\n");

        // Проверка наличия маршрута
        System.out.println("Содержит ли маршрут 2: " + navigator.contains(route2) + "\n");

        // Получение маршрута по ID
        Route foundRoute = navigator.getRoute("2");
        if (foundRoute != null) {
            System.out.println("Найден маршрут с ID 2: " + foundRoute + "\n");
        } else {
            System.out.println("Маршрут с ID 2 не найден." + "\n");
        }

        // Выбор маршрута (увеличиваем популярность)
        navigator.chooseRoute("2");
        System.out.println("Обновленная популярность маршрута 2: " + route2.getPopularity() + "\n");

        // Поиск маршрутов по точкам старта и конца
        System.out.println("Маршрут с Москвы до Надыма: ");
        Iterable<Route> searchResults = navigator.searchRoutes("Москва", "Надым");
        for (Route r : searchResults) {
            System.out.println(r);
        }
        System.out.println("\n");

        // Получение избранных маршрутов для определенной точки назначения
        System.out.println("Избранные маршруты. ");
        Iterable<Route> favoriteRoutes = navigator.getFavoriteRoutes("Елец");
        for (Route r : favoriteRoutes) {
            System.out.println(r);
        }
        System.out.println("\n");

        // Получение 3 самых популярных маршрутов
        Iterable<Route> topRoutes = navigator.getTop3Routes();
        System.out.println("Топ 3 маршрутов: ");
        for (Route r : topRoutes) {
            System.out.println(r);
        }
        System.out.println("\n");


        // Удаление маршрута
        navigator.removeRoute("4");
        System.out.println("Общее количество маршрутов после удаления: " + navigator.size() + "\n");
    }
}
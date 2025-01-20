package com.example.navigation;

import com.example.navigation.structura.structurImpl.MyArrayListIml;
import com.example.navigation.structura.structurImpl.MyHashSetImpl;

import static com.example.navigation.callculator.calculatePoint;

public class NavigatorImpl implements Navigator {

    private final MyHashSetImpl<Route> routes = new MyHashSetImpl<>();

    @Override
    public void addRoute(Route route) {
        routes.add(route);
    }

    @Override
    public boolean contains(Route route) {
        return routes.contains(route);
    }

    @Override
    public void removeRoute(String routeID) {
        for (int i = 0; i < routes.size(); i++) {
            Route route1 = routes.get(i);
            if (route1 != null && route1.getId().equals(routeID)) {
                routes.remove(route1);
                return;
            }
        }
    }

    @Override
    public int size() {
        return routes.size();
    }

    @Override
    public Route getRoute(String routeId) {
        for (int i = 0; i < routes.size(); i++) {
            Route route = routes.get(i);
            if (route != null && route.getId().equals(routeId)) {
                return route;
            }
        }
        return null;
    }

    @Override
    public void chooseRoute(String routeId) {
        for (int i = 0; i < routes.size(); i++) {
            Route route = routes.get(i);
            if (route != null && route.getId().equals(routeId)) {
                route.increasePopularity();
                routes.remove(route);
                routes.add(route);
                return;
            }
        }
    }

    @Override
    public Iterable<Route> searchRoutes(String startPoint, String endPoint) {
        MyArrayListIml<Route> result = new MyArrayListIml<>();
        for (int i = 0; i < routes.size(); i++) {
            Route route = routes.get(i);
            if (route != null
                    && route.getPoint().contains(startPoint)
                    && endPoint.equals(route.getPoint().get(route.getPoint().size() - 1))) {
                result.add(route);
            }
        }

        result.sort((route1, route2) -> {
            if (route1.isFavorite() && !route2.isFavorite()) {
                return -1;
            }
            if (!route1.isFavorite() && route2.isFavorite()) {
                return 1;
            }

            int distance1 = calculatePoint(route1.getPoint(), startPoint, endPoint);
            int distance2 = calculatePoint(route2.getPoint(), startPoint, endPoint);

            int distantComparison = Integer.compare(distance1, distance2);
            if (distantComparison != 0) {
                return distantComparison;
            }

            return Integer.compare(route2.getPopularity(), route1.getPopularity());
        });

        return result;
    }

    @Override
    public Iterable<Route> getFavoriteRoutes(String destinationPoint) {
        MyArrayListIml<Route> result = new MyArrayListIml<>();
        for (int i = 0; i < routes.size(); i++) {
            Route route = routes.get(i);
            if (route != null
                    && route.getPoint().contains(destinationPoint)
                    && route.isFavorite())
            {
                result.add(route);
            }
        }

        result.sort((route1, route2) ->{
            int distant = Integer.compare(route1.getPoint().size(), route2.getPoint().size());
            if (distant != 0) {
                return distant;
            }
            return Integer.compare(route2.getPopularity(), route1.getPopularity());
        });

        return result;
    }

    @Override
    public Iterable<Route> getTop3Routes() {
        MyArrayListIml<Route> result = new MyArrayListIml<>();
        for (int i = 0; i < routes.size(); i++){
            result.add(routes.get(i));
        }

        result.sort((route1, route2) ->{
            if (route1.isFavorite() && !route2.isFavorite()) {
                return -1;
            }
            if (!route1.isFavorite() && route2.isFavorite()) {
                return 1;
            }

            int popular = Integer.compare(route2.getPopularity(), route1.getPopularity());
            if (popular != 0) {
                return popular;
            }

            int distance = Double.compare(route1.getDistance(), route2.getDistance());
            if (distance != 0) {
                return distance;
            }

            return Integer.compare(route1.getPoint().size(), route2.getPoint().size());
        });

        MyArrayListIml<Route> top3 = new MyArrayListIml<>();
        for (int i = 0; i < Math.min(5, result.size()); i++) {
            top3.add(result.get(i));
        }

        return top3;
    }
}
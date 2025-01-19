package com.example.navigation;

import com.example.navigation.structura.structurImpl.MyArrayListIml;
import com.example.navigation.structura.structurImpl.MyHashSetImpl;

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
    public void removeRoute(String route) {
        for (int i = 0; i < routes.size(); i++) {
            Route route1 = routes.get(i);
            if (route1 != null && route1.getId().equals(route)) {
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
            if (route != null && route.getPoint().contains(startPoint) && route.getPoint().contains(endPoint)) {
                result.add(route);
            }
        }

        result.sort((route1, route2) -> {
            if (route1.isFavorite() && !route2.isFavorite()){
                return -1;
            }

            if (!route1.isFavorite() && route2.isFavorite()){
                return 1;
            }

            int distant = Integer.compare(route1.getPoint().size(), route2.getPoint().size());
            if (distant !=0){
                return distant;
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
                    && route.getPoint().contains(destinationPoint))
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

            int popularityComparison = Integer.compare(route2.getPopularity(), route1.getPopularity());
            if (popularityComparison != 0) {
                return popularityComparison;
            }

            int distanceComparison = Double.compare(route1.getDistance(), route2.getDistance());
            if (distanceComparison != 0) {
                return distanceComparison;
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
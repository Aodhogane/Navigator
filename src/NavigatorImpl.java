import structura.structurImpl.MyArrayListIml;
import structura.structurImpl.MyHashSetImpl;
import structura.structurImpl.MyIteratorImpl;

import java.util.*;

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
    public void removeRoute(String routeId) {
        MyIteratorImpl<Route> iterator = new MyIteratorImpl<>(routes, t -> true);
        while (iterator.hasNext()) {
            Route route = iterator.next();
            if (route.getId().equals(routeId)) {
                routes.remove(route);
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
        MyIteratorImpl<Route> iterator = new MyIteratorImpl<>(routes, t -> true);
        while (iterator.hasNext()) {
            Route route = iterator.next();
            if (route.getId().equals(routeId)) {
                return route;
            }
        }
        return null;
    }

    @Override
    public void chooseRoute(String routeId) {
        MyIteratorImpl<Route> iterator = new MyIteratorImpl<>(routes, t -> true);
        while (iterator.hasNext()) {
            Route route = iterator.next();
            if (route.getId().equals(routeId)) {
                route.increasePopularity();
                return;
            }
        }
    }

    @Override
    public Iterable<Route> searchRoutes(String startPoint, String endPoint) {
        MyArrayListIml<Route> result = new MyArrayListIml<>();
        MyIteratorImpl<Route> iterator = new MyIteratorImpl<>(routes, t -> true);
        while (iterator.hasNext()) {
            Route route = iterator.next();
            if (route.getPoint().equals(startPoint) && route.getPoint().equals(endPoint)) {
                result.add(route);
            }
        }
        return result;
    }

    @Override
    public Iterable<Route> getFavoriteRoutes(String destinationPoint) {

    }

    @Override
    public Iterable<Route> getTop3Routes() {

    }
}

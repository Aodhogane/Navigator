import structura.structurImpl.MyIteratorImpl;

import java.util.*;

public class NavigatorImpl implements Navigator {

    private final HashSet<Route> routes = new HashSet<>();


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
        MyIteratorImpl<Route> iterator = new MyIteratorImpl<>(routesr, t->true)
    }

    @Override
    public int size() {
        return routes.size();
    }

    @Override
    public Route getRoute(String routeId) {
        for (Route route : routes){
            if (route.getId().equals(routeId)){
                return route;
            }
        }
        return null;
    }

    @Override
    public void chooseRoute(String routeId) {
        for (Route route : routes){
            if (route.getId().equals(routeId)){
                route.increasePopularity();
                return;
            }
        }
    }

    @Override
    public Iterable<Route> searchRoutes(String startPoint, String endPoint) {
        return null;
    }

    @Override
    public Iterable<Route> getFavoriteRoutes(String destinationPoint) {
        return null;
    }

    @Override
    public Iterable<Route> getTop3Routes() {
        return null;
    }
}

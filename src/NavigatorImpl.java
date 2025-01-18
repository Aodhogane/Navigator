import structura.MyList;
import structura.structurImpl.MyArrayListIml;
import structura.structurImpl.MyHashSetImpl;

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
        for (int i = 0; i < routes.size(); i++){
            Route route1 = routes.get(i);
            if (route1 != null && route1.getId().equals(route)){
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
        for (int i =0; i < routes.size(); i++){
            Route route = routes.get(i);
            if (route != null && route.getId().equals(routeId)){
                return route;
            }
        }
        return null;
    }

    @Override
    public void chooseRoute(String routeId) {
        for (int i = 0; i < routes.size(); i++){
            Route route = routes.get(i);
            if (route != null && route.getId().equals(routeId)){
                route.increasePopularity();
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
        return result;
    }

    @Override
    public Iterable<Route> getFavoriteRoutes(String destinationPoint) {
        MyArrayListIml<Route> result = new MyArrayListIml<>();
        for (int i = 0; i < routes.size(); i++) {
            Route route = routes.get(i);
            if (route != null && route.getPoint().contains(destinationPoint) && route.isFavorite()) {
                result.add(route);
            }
        }
        return result;
    }

    @Override
    public Iterable<Route> getTop3Routes() {
//        MyList<Route> routeList = new MyArrayListIml<>();
//        for (int i = 0; i < routes.size(); i++) {
//            routeList.add(routes.get(i));
//        }
//
//        routeList.sort((route1, route2) -> Integer.compare(route2.getPopularity(), route1.getPopularity()));
//
//        MyArrayListIml<Route> topRoutes = new MyArrayListIml<>();
//        for (int i = 0; i < Math.min(3, routeList.size()); i++) {
//            topRoutes.add(routeList.get(i));
//        }
//
//        return topRoutes;
//    }
        return null;
    }
}
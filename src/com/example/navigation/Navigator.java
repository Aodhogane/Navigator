package com.example.navigation;

public interface Navigator {

    void addRoute(Route route);

    void removeRoute(String route);

    boolean contains(Route route);

    int size();

    Route getRoute(String routeId);

    void chooseRoute(String routeId);

    Iterable<Route>searchRoutes(String startPoint, String endPoint);

    Iterable<Route>getFavoriteRoutes(String destinationPoint);

    Iterable<Route>getTop3Routes();
}


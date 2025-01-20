package com.example.navigation;

import com.example.navigation.structura.structurImpl.MyArrayListIml;
import java.util.Objects;


public class Route {
    private String id;
    private double distance;
    private int popularity;
    private boolean  isFavorite;
    private MyArrayListIml<String> point;

    public Route(String id, double distance, int popularity, boolean isFavorite, MyArrayListIml<String> point) {
        this.id = id;
        this.distance = distance;
        this.popularity = popularity;
        this.isFavorite = isFavorite;
        this.point = point;
    }

    public void increasePopularity() {
        this.popularity++;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public MyArrayListIml<String> getPoint() {
        return point;
    }

    public void setPoint(MyArrayListIml<String> point) {
        this.point = point;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Route route = (Route) o;

        return Double.compare(distance, route.distance) == 0
                && Objects.equals(point.getStartPoint(), route.point.getStartPoint())
                && Objects.equals(point.getEndPoint(), route.point.getEndPoint());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, distance, point.getStartPoint(), point.getEndPoint());
    }


    @Override
    public String toString() {
        return "Route{" +
                "id='" + id + '\'' +
                ", distance=" + distance +
                ", popularity=" + popularity +
                ", isFavorite=" + isFavorite +
                ", point=" + point +
                '}';
    }
}

import structura.structurImpl.MyArrayListIml;

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
        Route route = (Route) o;
        return Double.compare(route.distance, distance) == 0 &&
                popularity == route.popularity &&
                isFavorite == route.isFavorite &&
                id.equals(route.id) &&
                point.equals(route.point);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, distance, popularity, isFavorite, point);
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

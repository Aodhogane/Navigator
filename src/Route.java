import structura.MyList;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Route {
    private String id;
    private double distance;
    private int popularity;
    private boolean  isFavorite;
    private MyList<String> point;

    public Route(MyList<String> point, boolean isFavorite, int popularity, double distance, String id) {
        this.point = point;
        this.isFavorite = isFavorite;
        this.popularity = popularity;
        this.distance = distance;
        this.id = id;
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

    public MyList<String> getPoint() {
        return point;
    }

    public void setPoint(MyList<String> point) {
        this.point = point;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
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

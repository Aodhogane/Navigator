import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Route {
    private String id;
    private double distance;
    private int popularity;
    private boolean  isFavorite;
    private List<String> point;

    public Route(List<String> point, boolean isFavorite, int popularity, double distance, String id) {
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

    public List<String> getPoint() {
        return point;
    }

    public void setPoint(List<String> point) {
        this.point = point;
    }

    @Override
    public boolean equals(Object o) {
        Route route = (Route) o;

        return distance == route.distance
                && point.getFirst() == route.point.getFirst()
                && point.getLast() == route.point.getLast();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

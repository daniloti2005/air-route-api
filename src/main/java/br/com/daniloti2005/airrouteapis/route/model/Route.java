package br.com.daniloti2005.airrouteapis.route.model;

        import java.util.Objects;

        import javax.persistence.Entity;
        import javax.persistence.GeneratedValue;
        import javax.persistence.Id;

@Entity
public class Route {

    private @Id @GeneratedValue Long id;
    private String origin;
    private String destination;
    private Integer cost;


    public Route(String origin, String destination, Integer cost) {

        this.origin = origin;
        this.destination = destination;
        this.cost = cost;
    }

    public Route() {

    }

    public Long getId() {
        return this.id;
    }

    public String getOrigin() {
        return this.origin;
    }

    public String getDestination() {
        return this.destination;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOrigin(String name) {
        this.origin = name;
    }

    public void setDestination(String role) {
        this.destination = role;
    }

    public Integer getCost() { return cost; }

    public void setCost(Integer cost) { this.cost = cost; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return origin.equals(route.origin) && destination.equals(route.destination) && cost.equals(route.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(origin, destination, cost);
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", cost=" + cost +
                '}';
    }
}

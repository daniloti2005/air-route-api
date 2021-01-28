package br.com.daniloti2005.airrouteapis.route.model;

public class DijkstraResult {

    private String node;
    private String previoues;
    private Integer distanceFromOrigin;
    private Integer distanceFromPrevious;

    public DijkstraResult() {

    }

    public DijkstraResult(String node, String previoues, Integer distanceFromOrigin, Integer distanceFromPrevious) {
        this.node = node;
        this.previoues = previoues;
        this.distanceFromOrigin = distanceFromOrigin;
        this.distanceFromPrevious = distanceFromPrevious;
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    public String getPrevioues() {
        return previoues;
    }

    public void setPrevioues(String previoues) {
        this.previoues = previoues;
    }

    public Integer getDistanceFromOrigin() {
        return distanceFromOrigin;
    }

    public void setDistanceFromOrigin(Integer distanceFromOrigin) {
        this.distanceFromOrigin = distanceFromOrigin;
    }

    public Integer getDistanceFromPrevious() {
        return distanceFromPrevious;
    }

    public void setDistanceFromPrevious(Integer distanceFromPrevious) {
        this.distanceFromPrevious = distanceFromPrevious;
    }
}

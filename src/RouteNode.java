import java.math.BigInteger;
import java.util.HashSet;
import java.util.Objects;

public class RouteNode implements Comparable<RouteNode>{
    private final Node node;
    private final BigInteger costToNode;
    private final RouteNode previous;

    private RouteNode(Node node, BigInteger costToNode, RouteNode previous){
        this.node = node;
        this.costToNode = costToNode;
        this.previous = previous;
    }

    public static RouteNode of(Node node, BigInteger costToNode, RouteNode previous){
        Objects.requireNonNull(node);
        Objects.requireNonNull(costToNode);
        return new RouteNode(node, costToNode, previous);
    }

    public static RouteNode of(Edge edge, RouteNode previous){
        Objects.requireNonNull(edge);
        Objects.requireNonNull(previous);
        Objects.requireNonNull(previous.getCostToNode());
        return new RouteNode(edge.getDest(), previous.getCostToNode().add(edge.getCost()), previous);
    }

    public static RouteNode of(Node node){
        Objects.requireNonNull(node);
        return new RouteNode(node, null, null);
    }

    public final boolean isCostToNodeKnown(){
        return (costToNode != null);
    }

    public final BigInteger costAfterNode(){
        return costToNode.add(node.getCost());
    }

    @Override  //by arrival times then by airport
    public int compareTo(RouteNode o) {
        Objects.requireNonNull(o, "input is null");
        int comparedByCostToNode = this.costToNode.compareTo(o.costToNode);
        return (comparedByCostToNode!=0) ? comparedByCostToNode : node.compareTo(o.getNode());
    }

    public HashSet<Edge> getConnections(){
        return getNode().getEdges();
    }


    public Node getNode() {
        return node;
    }

    public BigInteger getCostToNode() {
        return costToNode;
    }

    public RouteNode getPrevious() {
        return previous;
    }
}

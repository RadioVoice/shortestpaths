import java.math.BigInteger;
import java.util.HashSet;
import java.util.Objects;

/**
 * Class representing a node with a cost to be reached attached to it.
 * @author Jack Bilotti
 */
public class RouteNode implements Comparable<RouteNode>{
    private final Node node;
    private final BigInteger costToNode;
    private final RouteNode previous;

    private RouteNode(Node node, BigInteger costToNode, RouteNode previous){
        this.node = node;
        this.costToNode = costToNode;
        this.previous = previous;
    }

    /**
     * Builder for the instantiation of a RouteNode
     * @param node represents the node of the RouteNode
     * @param costToNode represents the cost to be reached by the node
     * @param previous represents the previous node in the graph
     * @return Returns an instance of RouteNode
     */
    public static RouteNode of(Node node, BigInteger costToNode, RouteNode previous){
        Objects.requireNonNull(node);
        Objects.requireNonNull(costToNode);
        return new RouteNode(node, costToNode, previous);
    }

    /**
     * Builder for the instantiation of a RouteNode
     * @param edge represents the edge connecting the previous and current node
     * @param previous represents the previous node in the graph
     * @return Returns an instance of RouteNode
     */
    public static RouteNode of(Edge edge, RouteNode previous){
        Objects.requireNonNull(edge);
        Objects.requireNonNull(previous);
        Objects.requireNonNull(previous.getCostToNode());
        return new RouteNode(edge.getDest(), previous.getCostToNode().add(edge.getCost()), previous);
    }

    /**
     * Builder for the instantiation of a RouteNode
     * @param node represents the main node of the routeNode
     * @return Returns an instance of RouteNode
     */
    public static RouteNode of(Node node){
        Objects.requireNonNull(node);
        return new RouteNode(node, null, null);
    }

    /**
     *
     * @return Returns a truth value as to whether the costToNode value is null or not
     */
    public final boolean isCostToNodeKnown(){
        return (costToNode != null);
    }

    /**
     *
     * @return Returns a value representing
     */
    public final BigInteger costAfterNode(){
        return costToNode.add(node.getCost());
    }

    /**
     *
     * @param o represents the RouteNode to be compared to
     * @return Returns the value of comparing the RouteNode to the param. First compares value of the costToNode
     * then compares the nodes themselves
     */
    @Override  //by cost then node
    public int compareTo(RouteNode o) {
        Objects.requireNonNull(o, "input is null");
        boolean thisUnknown = !isCostToNodeKnown();
        boolean oUnknown = !o.isCostToNodeKnown();
        if(thisUnknown || oUnknown)
            return Boolean.compare(thisUnknown, oUnknown);
        else{
            int comparedByCostToNode = costToNode.compareTo(o.costToNode);
            return (comparedByCostToNode!=0) ? comparedByCostToNode : node.compareTo(o.getNode());
        }
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

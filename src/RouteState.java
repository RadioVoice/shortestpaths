import java.math.BigInteger;
import java.security.InvalidParameterException;
import java.util.*;

/**
 * ClassRoute a navigable graph of the nodes
 * @author Jack Bilotti
 */
final class RouteState {
    private Map<Node, RouteNode> nodeMap ;
    private final NavigableSet<RouteNode> unreached;

    private RouteState(Set<Node> nodes, Node origin, BigInteger startingCost){

        nodeMap = new HashMap<Node, RouteNode>();
        unreached = new TreeSet<RouteNode>();

        RouteNode startingNode = RouteNode.of(origin, startingCost, null);

        for(Node n : nodes) {
            RouteNode temp = RouteNode.of(n);
            nodeMap.put(n, temp);
        }

        this.replaceNode(startingNode);
    }

    /** Builder for the instantiation of a RouteState
     *
     * @param nodes represents the set of nodes in the graph
     * @param origin represents the starting point, or origin of the graph
     * @param startingCost represents the starting cost of the graph state
     * @return Returns an instance of RouteState
     */
    static RouteState of(Set<Node> nodes, Node origin, BigInteger startingCost){
        if(nodes.isEmpty()){
            throw new InvalidParameterException("Nodes should not be empty");
        }
        return new RouteState(nodes, origin, startingCost);
    }

    /** Adds or replaces the node in unreached; then replaces the node in nodeMap
     *
     * @param routeNode represents the RouteNode being replaced
     */
    final void replaceNode(RouteNode routeNode){
        Objects.requireNonNull(routeNode, "route node is null");

        Node node = routeNode.getNode();
        assert (node != null);

        RouteNode oldNode = nodeMap.get(node);
        assert (oldNode != null);

        if(unreached.contains(oldNode))
            unreached.remove(oldNode);
        unreached.add(routeNode);
        nodeMap.replace(node, routeNode);
    }

    /**Checks to see if all nodes in the graph have been reached
     *
     * @return Returns the truth value of the unreached set and whether or not it is empty
     */
    final boolean allReached(){
        return unreached.isEmpty();
    }

    /**Finds the closest node that hasn't been reached yet
     *
     * @return Returns the first node in the unreached set
     */
    final RouteNode closestUnreached() {
        if (allReached()) {
            throw new NoSuchElementException("all nodes have been reached");
        }
        return unreached.first();
    }

    /**Checks to see if given node exists as a key in the RouteState nodeMap
     *
     * @param node contains the node being checked
     * @return Returns the RouteNode value linked to the node key. Otherwise returns null
     */
    final RouteNode associatedRouteNode(Node node){
        Objects.requireNonNull(node, "node is null");
        if(nodeMap.containsKey(node)){
            return nodeMap.get(node);
        }
        return null;
    }

    /**Called when a node in the RouteState graph has been reached.
     *
     * @param routeNode represents the routeNode that is considered reached and is to be removed from the 'unreached' set
     */
    final void reached(RouteNode routeNode){
        Objects.requireNonNull(routeNode, "route node is null");
        unreached.remove(routeNode);
    }
}

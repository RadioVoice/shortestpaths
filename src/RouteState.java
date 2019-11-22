import java.math.BigInteger;
import java.util.*;

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
    static RouteState of(Set<Node> nodes, Node origin, BigInteger startingCost){
        Objects.requireNonNull(nodes, "set is null");
        Objects.requireNonNull(origin, "origin is null");
        Objects.requireNonNull(startingCost, "starting cost is null");
        return new RouteState(nodes, origin, startingCost);
    }

    //adds or replaces the node in unreached; just replaces in airportNodes
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

    final boolean allReached(){
        return unreached.isEmpty();
    }

    final RouteNode closestUnreached() {
        if (allReached()) {
            throw new NoSuchElementException("all nodes have been reached");
        }
        return unreached.first();
    }

    final RouteNode associatedRouteNode(Node node){
        Objects.requireNonNull(node, "node is null");
        if(nodeMap.containsKey(node)){
            return nodeMap.get(node);
        }
        return null;
    }

    final void reached(RouteNode routeNode){
        Objects.requireNonNull(routeNode, "route node is null");
        unreached.remove(routeNode);
    }
}

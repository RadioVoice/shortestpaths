import java.math.BigInteger;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * RouteFinder takes a set of vertices, and uses the associated edges with those vertices
 * to run Dijistra's Algorithm, giving the shortest path from one place to another
 * @author Jack Bilotti
 */
public class RouteFinder {
    private final Set<Node> nodes;

    private RouteFinder(Set<Node> nodes) {
        this.nodes = nodes;
    }

    /**
     * Builder for the instantiation of a RouteFinder
     * @param nodes Set of all nodes in the graph
     * @return Returns an instance of RouteFinder
     */
    public static RouteFinder of(Set<Node> nodes) {
        Objects.requireNonNull(nodes, "set is null");
        return new RouteFinder(nodes);
    }

    /**
     * Dijkstra's Algorithm
     * @param origin represents the beginning of Dijkstra's algorithm
     * @param destination represents the final place in the shortest path
     * @param startingCost represents the starting cost of the path
     * @return Returns RouteNode containing shortest path
     */
    public final RouteNode route(Node origin, Node destination, BigInteger startingCost) {
        Objects.requireNonNull(origin, "origin is null");
        Objects.requireNonNull(destination, "destination is null");
        Objects.requireNonNull(startingCost, "starting cost is null");
        RouteState routeState = RouteState.of(nodes, origin, startingCost);

        while (!routeState.allReached()) {
            RouteNode currentNode = routeState.closestUnreached();
            routeState.reached(currentNode);

            if (currentNode.getNode().equals(destination)) {
                return currentNode;
            }

            findNextNodes(routeState, currentNode);

        }
        return null;
    }

    /**
     *
     * @param routeState represents the current RouteState of the graph being searched
     * @param currentNode represents the currentNode of the graph the route algorithm is on
     */
    private void findNextNodes(RouteState routeState, RouteNode currentNode) {
        HashSet<Edge> connectionSet = currentNode.getConnections();

        for (Edge connection : connectionSet) {
            BigInteger costToNextNode = currentNode.costAfterNode().add(connection.getCost());
            RouteNode nextRouteNode = routeState.associatedRouteNode(connection.getDest());
            Objects.requireNonNull(nextRouteNode, "No associated RouteNode");

            if(!nextRouteNode.isCostToNodeKnown() || costToNextNode.compareTo(nextRouteNode.costAfterNode()) < 0){
                RouteNode newNode = RouteNode.of(connection, currentNode);
                routeState.replaceNode(newNode);
            }
        }
    }
}

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public final class RouteFinder {
    private final Set<Node> nodes;

    private RouteFinder(Set<Node> nodes) {
        this.nodes = nodes;
    }

    public static RouteFinder of(Set<Node> nodes) {
        Objects.requireNonNull(nodes, "set is null");
        return new RouteFinder(nodes);
    }

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

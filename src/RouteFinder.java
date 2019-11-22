import java.math.BigInteger;
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

    void findNextNodes(RouteState routeState, RouteNode currentNode) {
        for (Edge connection : currentNode.getConnections()) {
            RouteTime flightArrivalTime = new RouteTime(flight.arrivalTime());
            if (flightArrivalTime.compareTo(routeState.airportNode(flight.destination()).getArrivalTime()) < 0) {
                RouteNode newNode = RouteNode.of(flight, currentNode);
                routeState.replaceNode(newNode);
            }
        }
    }
}

import static org.junit.Assert.*;
import org.junit.Test;

import java.math.BigInteger;
import java.security.InvalidParameterException;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

public class RouteStateTest {

    //Code Coverage and Good Data
    @Test
    public void routeStateTest() {
        SimpleNode node = SimpleNode.of(new BigInteger("1"), new HashSet<Edge>(), new BigInteger("1000"));
        SimpleNode node2 = SimpleNode.of(new BigInteger("2"), new HashSet<Edge>(), new BigInteger("1000"));

        Set<Node> nodes = new HashSet<>();
        nodes.add(node);
        nodes.add(node2);

        RouteState routeState = RouteState.of(nodes, node, new BigInteger("2000"));
    }

    //Code Coverage and Branch Coverage
    @Test
    public void routeStateTestReplaceNode() {
        Set<Node> nodes = new HashSet<>();
        SimpleNode node = SimpleNode.of(new BigInteger("1"), new HashSet<Edge>(), new BigInteger("1000"));
        nodes.add(node);

        RouteState routeState = RouteState.of(nodes, node, new BigInteger("1000"));
        RouteNode routeNode = RouteNode.of(node, new BigInteger("1000"), null);
        routeState.replaceNode(routeNode);
    }

    //Bad Data - Invalid set of nodes
    @Test(expected = InvalidParameterException.class)
    public void routeStateTestEmptySet() {
        SimpleNode node = SimpleNode.of(new BigInteger("1"), new HashSet<Edge>(), new BigInteger("1000"));
        Set<Node> nodes = new HashSet<>();
        RouteState routeState = RouteState.of(nodes, node, new BigInteger("10"));
    }
    //Code Coverage
    @Test
    public void routeStateClosestUnreachedTest() {
        Set<Node> nodes = new HashSet<>();
        SimpleNode node = SimpleNode.of(new BigInteger("1"), new HashSet<Edge>(), new BigInteger("1000"));
        nodes.add(node);

        RouteState routeState = RouteState.of(nodes, node, new BigInteger("1000"));
        RouteNode routeNode = RouteNode.of(node, new BigInteger("1000"), null);
        assertTrue(routeNode.compareTo(routeState.closestUnreached()) == 0);
    }

    //Branch Coverage and bad Data - Set of nodes is empty
    @Test(expected = NoSuchElementException.class)
    public void routeStateClosestUnreachedTestAllReached() {
        Set<Node> nodes = new HashSet<>();
        SimpleNode node = SimpleNode.of(new BigInteger("1"), new HashSet<Edge>(), new BigInteger("1000"));
        nodes.add(node);

        RouteState routeState = RouteState.of(nodes, node, new BigInteger("1000"));
        RouteNode routeNode = RouteNode.of(node, new BigInteger("1000"), null);
        routeState.reached(routeNode);
        routeState.closestUnreached();
    }

    //Code Coverage and Branch Coverage
    @Test
    public void routeStateAssociatedRouteNodeTest() {
        Set<Node> nodes = new HashSet<>();
        SimpleNode node = SimpleNode.of(new BigInteger("1"), new HashSet<Edge>(), new BigInteger("1000"));
        nodes.add(node);

        RouteState routeState = RouteState.of(nodes, node, new BigInteger("1000"));
        RouteNode routeNode = RouteNode.of(node, new BigInteger("1000"), null);
        assertTrue(routeNode.compareTo(routeState.associatedRouteNode(node)) ==0);

        SimpleNode node2 = SimpleNode.of(new BigInteger("2"), new HashSet<Edge>(), new BigInteger("1000"));
        assertNull(routeState.associatedRouteNode(node2));
    }
}

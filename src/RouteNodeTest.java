import static org.junit.Assert.*;
import org.junit.Test;

import java.math.BigInteger;
import java.util.HashSet;

public class RouteNodeTest {

    //Code Coverage and Good Data
    @Test
    public void RouteNode() {
        SimpleNode node = SimpleNode.of(new BigInteger("1"), new HashSet<Edge>(), new BigInteger("1000"));
        SimpleNode node2 = SimpleNode.of(new BigInteger("2"), new HashSet<Edge>(), new BigInteger("1000"));

        SimpleEdge edge = SimpleEdge.of(new BigInteger("1"), new BigInteger("2000"), node, node2);
        RouteNode routeNode = RouteNode.of(node, new BigInteger("2000"), null);

        RouteNode routeNode2 = RouteNode.of(edge, routeNode);
    }

    //Code Coverage and Branch Coverage
    @Test
    public void RouteNodeIsCostToNodeKnownTest() {
        SimpleNode node = SimpleNode.of(new BigInteger("1"), new HashSet<Edge>(), new BigInteger("1000"));
        RouteNode routeNode = RouteNode.of(node, new BigInteger("2000"), null);
        RouteNode routeNode2 = RouteNode.of(node);

        assertTrue(routeNode.isCostToNodeKnown());
        assertFalse(routeNode2.isCostToNodeKnown());
    }

    //Code Coverage and Good Data
    @Test
    public void routeNodeCostAfterNodeTest() {
        SimpleNode node = SimpleNode.of(new BigInteger("1"), new HashSet<Edge>(), new BigInteger("1000"));
        RouteNode routeNode = RouteNode.of(node, new BigInteger("2000"), null);
        assertEquals(new BigInteger("3000"), routeNode.costAfterNode());
    }

    //Code Coverage and Branch Coverage
    @Test
    public void routeNodeCompareToTest() {
        SimpleNode node = SimpleNode.of(new BigInteger("1"), new HashSet<Edge>(), new BigInteger("1000"));
        SimpleNode node2 = SimpleNode.of(new BigInteger("2"), new HashSet<Edge>(), new BigInteger("1000"));
        RouteNode routeNode = RouteNode.of(node, new BigInteger("1000"), null);
        RouteNode routeNode2 = RouteNode.of(node2, new BigInteger("2000"), null);
        assertEquals(-1, routeNode.compareTo(routeNode2));
    }
}

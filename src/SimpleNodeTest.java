import org.junit.Test;

import java.math.BigInteger;
import java.util.HashSet;

import static org.junit.Assert.*;


public class SimpleNodeTest {

    @Test
    public void simpleNodeTest() {
        //Code Coverage and Good Data
        BigInteger id = new BigInteger("10001");
        HashSet<Edge> edges = new HashSet<>();
        BigInteger cost = new BigInteger("200");
        SimpleNode node = SimpleNode.of(id, edges, cost);

        SimpleNode node2 = SimpleNode.of(id, edges, cost);
        assertTrue(node.equals(node2));
        assertEquals(node.compareTo(node), 0);

    }

    //Bad Data - Null Id
    @Test(expected = NullPointerException.class)
    public void simpleNodeTestNoID() {
        SimpleNode simple = SimpleNode.of(null, new HashSet<Edge>(), new BigInteger("1"));
    }

    //Bad Data -- Null Edges
    @Test(expected = NullPointerException.class)
    public void simpleNodeTestNoEdges() {
        SimpleNode simple = SimpleNode.of(new BigInteger("1"), null, new BigInteger("1"));
    }

    //Bad Data -- Null cost
    @Test(expected = NullPointerException.class)
    public void simpleNodeTestNoCost() {
        SimpleNode simple = SimpleNode.of(new BigInteger("1"), new HashSet<Edge>(), null);
    }

    //Code Coverage and Branch Coverage
    @Test
    public void simpleNodeAddEdgeTest() {
       SimpleNode node = SimpleNode.of(new BigInteger("1"), new HashSet<Edge>(), new BigInteger("1000"));
       SimpleNode node2 = SimpleNode.of(new BigInteger("2"), new HashSet<Edge>(), new BigInteger("1000"));

       SimpleEdge edge = SimpleEdge.of(new BigInteger("1"), new BigInteger("1001"), node, node2);
       assertTrue(node.addEdge(edge));
       assertFalse(node.addEdge(edge));
    }

    //Bad Data - Null edge
    @Test(expected = NullPointerException.class)
    public void simpleNodeAddEdgeTestNull() {
        SimpleNode node = SimpleNode.of(new BigInteger("1"), new HashSet<Edge>(), new BigInteger("1000"));
        node.addEdge(null);
    }

    //Code Coverage and Branch Coverage
    @Test
    public void simpleNodeRemoveEdgeTest() {
        SimpleNode node = SimpleNode.of(new BigInteger("1"), new HashSet<Edge>(), new BigInteger("1000"));
        SimpleNode node2 = SimpleNode.of(new BigInteger("2"), new HashSet<Edge>(), new BigInteger("1000"));

        SimpleEdge edge = SimpleEdge.of(new BigInteger("1"), new BigInteger("1001"), node, node2);
        node.addEdge(edge);
        assertTrue(node.removeEdge(edge));
        assertFalse(node.removeEdge(edge));
    }

    //Bad Data - Null edge
    @Test(expected = NullPointerException.class)
    public void simpleNodeRemoveEdgeTestNull() {
        SimpleNode node = SimpleNode.of(new BigInteger("1"), new HashSet<Edge>(), new BigInteger("1000"));
        node.removeEdge(null);
    }

    ///Branch Coverage - Object not a node
    @Test
    public void simpleNodeEqualsTest() {
        SimpleNode node = SimpleNode.of(new BigInteger("1"), new HashSet<Edge>(), new BigInteger("1000"));
        assertFalse(node.equals("String"));
    }

    //Bad Data - Illegal Argument
    @Test(expected = IllegalArgumentException.class)
    public void simpleNodeCompareToTestNotNode() {
        SimpleNode node = SimpleNode.of(new BigInteger("1"), new HashSet<Edge>(), new BigInteger("1000"));
        node.compareTo("Not Node");
    }
}

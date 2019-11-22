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
        SimpleNode node = SimpleNode.of(id, edges, cost, null);

        SimpleNode node2 = SimpleNode.of(id, edges, cost, node);
        assertTrue(node.equals(node2));
        assertEquals(node.compareTo(node), 0);

    }

    //Bad Data - Null Id
    @Test(expected = NullPointerException.class)
    public void simpleNodeTestNoID() {
        SimpleNode simple = SimpleNode.of(null, new HashSet<Edge>(), new BigInteger("1"), null);
    }

    //Bad Data -- Null Edges
    @Test(expected = NullPointerException.class)
    public void simpleNodeTestNoEdges() {
        SimpleNode simple = SimpleNode.of(new BigInteger("1"), null, new BigInteger("1"), null);
    }

    //Bad Data -- Null cost
    @Test(expected = NullPointerException.class)
    public void simpleNodeTestNoCost() {
        SimpleNode simple = SimpleNode.of(new BigInteger("1"), new HashSet<Edge>(), null, null);
    }

    //Code Coverage and Branch Coverage
    @Test
    public void simpleNodeAddTest() {
       SimpleNode node = SimpleNode.of(new BigInteger("1"), new HashSet<Edge>(), new BigInteger("1000"), null);
       SimpleNode node2 = SimpleNode.of(new BigInteger("2"), new HashSet<Edge>(), new BigInteger("1000"), node);

       SimpleEdge edge = SimpleEdge.of(new BigInteger("1"), new BigInteger("1001"), node, node2);
       assertTrue(node.addEdge(edge));
       assertFalse(node.addEdge(edge));
    }

    //Bad Data - Null edge
    @Test(expected = NullPointerException.class)
    public void simpleNodeAddTestNull() {
        SimpleNode node = SimpleNode.of(new BigInteger("1"), new HashSet<Edge>(), new BigInteger("1000"), null);
        node.addEdge(null);
    }

    //Code Coverage and Branch Coverage
    @Test
    public void simpleNodeRemoveTest() {
        SimpleNode node = SimpleNode.of(new BigInteger("1"), new HashSet<Edge>(), new BigInteger("1000"), null);
        SimpleNode node2 = SimpleNode.of(new BigInteger("2"), new HashSet<Edge>(), new BigInteger("1000"), node);

        SimpleEdge edge = SimpleEdge.of(new BigInteger("1"), new BigInteger("1001"), node, node2);
        node.addEdge(edge);
        assertTrue(node.removeEdge(edge));
        assertFalse(node.removeEdge(edge));
    }

    //Bad Data - Null edge
    @Test(expected = NullPointerException.class)
    public void simpleNodeRemoveTestNull() {
        SimpleNode node = SimpleNode.of(new BigInteger("1"), new HashSet<Edge>(), new BigInteger("1000"), null);
        node.removeEdge(null);
    }

    //Bad Data - Illegal Argument
    @Test(expected = IllegalArgumentException.class)
    public void simpleNodeCompareToTestNotNode() {
        SimpleNode node = SimpleNode.of(new BigInteger("1"), new HashSet<Edge>(), new BigInteger("1000"), null);
        node.compareTo("Not Node");
    }
}

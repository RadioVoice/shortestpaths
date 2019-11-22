import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;


public class RouteFinderTest {

    public SimpleNode node1;
    public SimpleNode node2;
    public SimpleNode node3;
    public SimpleNode node4;
    public SimpleNode node5;
    public SimpleNode node6;
    public SimpleNode node7;
    public SimpleNode node8;
    public SimpleNode node9;

    public SimpleEdge edge1;
    public SimpleEdge edge2;
    public SimpleEdge edge3;
    public SimpleEdge edge4;
    public SimpleEdge edge5;
    public SimpleEdge edge6;
    public SimpleEdge edge7;
    public SimpleEdge edge8;
    public SimpleEdge edge9;



    @Before
    public void initRoutes() {

        /*
        HashSet<Edge> set1 = new HashSet<Edge>(Arrays.asList(edge1,edge2));
        HashSet<Edge> set2 = new HashSet<Edge>(Arrays.asList(edge3));
        HashSet<Edge> set3 = new HashSet<Edge>(Arrays.asList(edge4,edge9));
        HashSet<Edge> set4 = new HashSet<Edge>(Arrays.asList(edge6));
        HashSet<Edge> set5 = new HashSet<Edge>(Arrays.asList(edge5));
        HashSet<Edge> set6 = new HashSet<Edge>(Arrays.asList(edge7));
        HashSet<Edge> set7 = new HashSet<Edge>(Arrays.asList(edge8));
        HashSet<Edge> set8 = new HashSet<Edge>();
        HashSet<Edge> set9 = new HashSet<Edge>();
        */
        node1 = SimpleNode.of(new BigInteger("1"), new HashSet<Edge>(), new BigInteger("0"));
        node2 = SimpleNode.of(new BigInteger("2"), new HashSet<Edge>(), new BigInteger("2"));
        node3 = SimpleNode.of(new BigInteger("3"), new HashSet<Edge>(), new BigInteger("2"));
        node4 = SimpleNode.of(new BigInteger("4"), new HashSet<Edge>(), new BigInteger("3"));
        node5 = SimpleNode.of(new BigInteger("5"), new HashSet<Edge>(), new BigInteger("0"));
        node6 = SimpleNode.of(new BigInteger("6"), new HashSet<Edge>(), new BigInteger("0"));
        node7 = SimpleNode.of(new BigInteger("7"), new HashSet<Edge>(), new BigInteger("3"));
        node8 = SimpleNode.of(new BigInteger("8"), new HashSet<Edge>(), new BigInteger("0"));
        node9 = SimpleNode.of(new BigInteger("8"), new HashSet<Edge>(), new BigInteger("10"));

        edge1 = SimpleEdge.of(new BigInteger("1"), new BigInteger("5"), node1, node2);
        edge2 = SimpleEdge.of(new BigInteger("2"), new BigInteger("10"), node1, node3);
        edge3 = SimpleEdge.of(new BigInteger("3"), new BigInteger("7"), node2, node4);
        edge4 = SimpleEdge.of(new BigInteger("4"), new BigInteger("7"), node3, node4);
        edge5 = SimpleEdge.of(new BigInteger("5"), new BigInteger("3"), node5, node4);
        edge6 = SimpleEdge.of(new BigInteger("6"), new BigInteger("1"), node4, node6);
        edge7 = SimpleEdge.of(new BigInteger("7"), new BigInteger("1"), node6, node7);
        edge8 = SimpleEdge.of(new BigInteger("8"), new BigInteger("20"), node7, node8);
        edge9 = SimpleEdge.of(new BigInteger("9"), new BigInteger("10"), node3, node8);

        node1.addEdge(edge1);
        node1.addEdge(edge2);
        node2.addEdge(edge3);
        node3.addEdge(edge4);
        node3.addEdge(edge9);
        node4.addEdge(edge6);
        node5.addEdge(edge6);
        node6.addEdge(edge7);
        node7.addEdge(edge8);

    }

    //Code Coverage and Good Data
    @Test
    public void routeFinderTest() {
        SimpleNode node = SimpleNode.of(new BigInteger("1"), new HashSet<Edge>(), new BigInteger("1000"));
        SimpleNode node2 = SimpleNode.of(new BigInteger("2"), new HashSet<Edge>(), new BigInteger("1000"));

        Set<Node> nodes = new HashSet<>();
        nodes.add(node);
        nodes.add(node2);
        RouteFinder routeFinder = RouteFinder.of(nodes);
    }

    //Bad Data - Null Set
    @Test(expected = NullPointerException.class)
    public void routeFinderTestNull() {
        RouteFinder routeFinder = RouteFinder.of(null);
    }

    //Code Coverage
    @Test
    public void routeFinderRoute() {
        HashSet<Node> nodes = new HashSet<Node>(Arrays.asList(node1,node2,node3,node4,node5,node6,node7,node8,node9));
        RouteFinder routeFinder = RouteFinder.of(nodes);
        RouteNode fin = routeFinder.route(node1, node8, new BigInteger("0"));
        assertEquals(fin.getCostToNode(), new BigInteger("22"));

    }
}

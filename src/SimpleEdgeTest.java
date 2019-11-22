import org.junit.Test;

import java.math.BigInteger;
import java.security.InvalidParameterException;
import java.util.HashSet;

import static org.junit.Assert.*;

public class SimpleEdgeTest {

    //Code Coverage
    @Test
    public void simpleEdgeTest() {
        SimpleNode node = SimpleNode.of(new BigInteger("1"), new HashSet<Edge>(), new BigInteger("1000"), null);
        SimpleNode node2 = SimpleNode.of(new BigInteger("2"), new HashSet<Edge>(), new BigInteger("1000"), node);

        SimpleEdge edge = SimpleEdge.of(new BigInteger("1"), new BigInteger("1001"), node, node2);
    }
    //Bad Data - Origin and Dest are the same
    @Test(expected = InvalidParameterException.class)
    public void simpleEdgeTestBadNodes() {
        SimpleNode node = SimpleNode.of(new BigInteger("1"), new HashSet<Edge>(), new BigInteger("1000"), null);
        SimpleEdge edge = SimpleEdge.of(new BigInteger("1"), new BigInteger("1001"), node, node);
    }


}

import static org.junit.Assert.*;
import org.junit.Test;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class RouteStateTest {

    //Code Coverage and Good Data
    @Test
    public void routeStateTest() {
        SimpleNode node = SimpleNode.of(new BigInteger("1"), new HashSet<Edge>(), new BigInteger("1000"), null);
        SimpleNode node2 = SimpleNode.of(new BigInteger("2"), new HashSet<Edge>(), new BigInteger("1000"), node);

        Set<Node> nodes = new HashSet<>();
        nodes.add(node);
        nodes.add(node2);

        RouteState routeState = RouteState.of(nodes, node, new BigInteger("200"));
    }


}

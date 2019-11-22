import java.util.HashSet;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class RouteState {
    private Set<Node> nodeSet;
    private NavigableSet<Node> unreached;

    private RouteState(Set<Node> nodes, Node origin){
        nodeSet = new HashSet<Node>();
        unreached = new TreeSet<Node>();

    }
}

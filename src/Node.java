import java.math.BigInteger;
import java.util.HashSet;

public interface Node extends Comparable{

    BigInteger getId();
    HashSet<Edge> getEdges();
    BigInteger getCost();
    boolean addEdge(Edge outgoing);
    boolean removeEdge(Edge outgoing);
    boolean equals(Object o);
}

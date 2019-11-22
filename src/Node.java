import java.math.BigInteger;
import java.util.HashSet;

public interface Node extends Comparable{

    BigInteger getId();
    HashSet<Edge> getEdges();
    BigInteger getCost();
    boolean add(Edge outgoing);
    boolean remove(Edge outgoing);

}

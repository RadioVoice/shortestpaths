import java.math.BigInteger;
import java.util.LinkedList;

public interface Node extends Comparable{

    BigInteger getId();
    LinkedList<Edge> getEdges();
    BigInteger getCost();
    boolean add(Edge outgoing);
    boolean remove(Edge outgoing);

}
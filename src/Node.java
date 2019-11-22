import java.math.BigInteger;
import java.util.LinkedList;

public interface Node {

    BigInteger getId();
    LinkedList<Edge> getEdges();
    BigInteger getCost();
    boolean add(Edge e);
    boolean remove(Edge e);

}

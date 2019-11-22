import java.math.BigInteger;
import java.util.LinkedList;

public interface Node {

    abstract BigInteger getID();
    abstract LinkedList<Edge> getEdges();
    abstract BigInteger getCost();
    abstract boolean addEdge();
    abstract boolean removeEdge();

}

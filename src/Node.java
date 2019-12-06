import java.math.BigInteger;
import java.util.HashSet;

/** Interface representing a 'node' or vertex of a graph/data structure
 * Is implemented by other classes representing nodes.
 * Otherwise described as definitive entities carrying information
 * @author Jack Bilotti
 */
public interface Node extends Comparable{

    /**
     *
     * @return Returns the id of the Node
     */
    BigInteger getId();

    /**
     *
     * @return Returns a set of of all edges contained in the node
     */
    HashSet<Edge> getEdges();

    /**
     *
     * @return Returns the 'cost' or weight/value of a node
     */
    BigInteger getCost();

    /**
     *
     * @param outgoing The edge being added to the Nodes collection of edges
     * @return Returns a boolean of the truth value that the edge is one that is unique
     * and successfully added to the node's collection
     */
    boolean addEdge(Edge outgoing);

    /**
     *
     * @param outgoing The edge to be removed from the Node's collection
     * @return Returns a boolean of the truth value of the edge's successful
     * removal from the Node's collection
     */
    boolean removeEdge(Edge outgoing);

    /**
     *
     * @param o The Node to compared to
     * @return Returns whether the node param is equivalent to the
     * node calling the method.
     */
    boolean equals(Object o);
}

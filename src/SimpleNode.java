import java.math.BigInteger;
import java.util.HashSet;
import java.util.Objects;

/**
 * Class that allows for implementation of a node, so that Dijkstra's Algorithm can be properly tested
 * @author Jack Bilotti
 */
public class SimpleNode implements Node{

    private BigInteger id;
    private HashSet<Edge> edges;
    private BigInteger cost;

    private SimpleNode(BigInteger id, HashSet<Edge> edges, BigInteger cost) {
        this.id = id;
        this.edges = edges;
        this.cost = cost;
    }

    /**Builder for the instantiation of a SimpleNode
     *
     * @param id Represents the id of the node
     * @param edges Represents the collections of edges contained in a node
     * @param cost Represents the cost of the node
     * @return Returns an instance of SimpleNode
     */
    public static SimpleNode of(BigInteger id, HashSet<Edge> edges, BigInteger cost) {
        Objects.requireNonNull(id);
        Objects.requireNonNull(edges);
        Objects.requireNonNull(cost);

        return new SimpleNode(id, edges, cost);
    }

    /**
     *
     * @return Returns the node ID
     */
    public BigInteger getId() { return id; }

    /**
     *
     * @return Returns the collection of node edges
     */
    public HashSet<Edge> getEdges() { return edges; }

    /**
     *
     * @return Returns the cost of the node
     */
    public BigInteger getCost() { return cost; }

    /**
     *
     * @param outgoing The edge being added to the Nodes collection of edges
     * @return Returns the boolean value of the success of the addition of an edge to the node's collection
     */
    public boolean addEdge(Edge outgoing) {
        Objects.requireNonNull(outgoing);
        return edges.add(outgoing);
    }

    /**
     *
     * @param outgoing The edge to be removed from the Node's collection
     * @return Returns the boolean value of the success of the removal of an edge from the node's collection
     */
    public boolean removeEdge(Edge outgoing) {
        Objects.requireNonNull(outgoing);
        return edges.remove(outgoing);
    }

    /**
     *
     * @param o The Node to compared to
     * @return Returns the truth value of the two nodes equivalency
     */
    public boolean equals(Object o) {
        if (o instanceof Node){
            return this.getId().equals(((Node) o).getId());
        }
        return false;
    }

    /**
     *
     * @param o The object being compared to
     * @return Returns the value of the comparison of the two node's IDs
     */
    public int compareTo(Object o) {
        if(o instanceof Node){
            return this.getId().compareTo(((Node) o).getId());
        }
        throw new IllegalArgumentException("Object is not a valid Node");
    }

}

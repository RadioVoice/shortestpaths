import java.math.BigInteger;
import java.util.HashSet;
import java.util.Objects;

public class SimpleNode implements Node{

    private BigInteger id;
    private HashSet<Edge> edges;
    private BigInteger cost;

    private SimpleNode(BigInteger id, HashSet<Edge> edges, BigInteger cost) {
        this.id = id;
        this.edges = edges;
        this.cost = cost;
    }

    public static SimpleNode of(BigInteger id, HashSet<Edge> edges, BigInteger cost) {
        Objects.requireNonNull(id);
        Objects.requireNonNull(edges);
        Objects.requireNonNull(cost);

        return new SimpleNode(id, edges, cost);
    }

    public BigInteger getId() { return id; }

    public HashSet<Edge> getEdges() { return edges; }

    public BigInteger getCost() { return cost; }

    public boolean add(Edge outgoing) {
        Objects.requireNonNull(outgoing);
        return edges.add(outgoing);
    }

    public boolean remove(Edge outgoing) {
        Objects.requireNonNull(outgoing);
        return edges.remove(outgoing);
    }

    public boolean equals(Object o) {
        if (o instanceof Node){
            return this.getId().equals(((Node) o).getId());
        }
        return false;
    }

    public int compareTo(Object o) {
        if(o instanceof Node){
            return this.getId().compareTo(((Node) o).getId());
        }
        throw new IllegalArgumentException("Object is not a valid Node");
    }

}

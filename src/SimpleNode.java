import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Objects;

public class SimpleNode implements Node{

    private BigInteger id;
    private LinkedList<Edge> edges;
    private BigInteger cost;
    private Node previous;
    private BigInteger costToNode;

    private SimpleNode(BigInteger id, LinkedList<Edge> edges, BigInteger cost, Node previous) {
        this.id = id;
        this.edges = edges;
        this.cost = cost;
        this.previous = previous;
    }

    public SimpleNode of(BigInteger id, LinkedList<Edge> edges, BigInteger cost, Node previous) {
        Objects.requireNonNull(id);
        Objects.requireNonNull(edges);
        Objects.requireNonNull(cost);
        Objects.requireNonNull(previous);
        Objects.requireNonNull(costToNode);

        return new SimpleNode(id, edges, cost, previous);
    }

    public BigInteger getId() { return id; }

    public LinkedList<Edge> getEdges() { return edges; }

    public BigInteger getCost() { return cost; }

    public Node getPrevious() { return previous; }

    public BigInteger getCostToNode() { return costToNode; }

    public boolean add(Edge outgoing) {
        Objects.requireNonNull(outgoing);
        return edges.add(outgoing);
    }

    public boolean remove(Edge outgoing) {
        Objects.requireNonNull(outgoing);
        return edges.remove(outgoing);
    }
    public boolean equals(Node o) {
        Objects.requireNonNull(o);
        return this.getId().equals(o.getId());
    }

    public int compareTo(Object o) {
        Objects.requireNonNull(o);
        if(o instanceof Node){
            return this.getId().compareTo(((Node) o).getId());
        }
        throw new IllegalArgumentException("Object is not a valid Node");
    }

}

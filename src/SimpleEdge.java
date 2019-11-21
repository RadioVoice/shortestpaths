import java.math.BigInteger;
import java.security.InvalidParameterException;
import java.util.Objects;

public class SimpleEdge implements Edge{

    private BigInteger id;
    private BigInteger cost;
    private Node origin;
    private Node dest;

    private SimpleEdge(BigInteger id, BigInteger cost, Node origin, Node dest){
        this.id = id;
        this.cost = cost;
        this.origin = origin;
        this.dest = dest;
    }

    public static SimpleEdge of(BigInteger id, BigInteger cost, Node origin, Node dest){
        Objects.requireNonNull(id);
        Objects.requireNonNull(cost);
        Objects.requireNonNull(origin);
        Objects.requireNonNull(dest);
        if (origin.equals(dest)){
            throw new InvalidParameterException("Origin and Destination nodes must be different");
        }
        return new SimpleEdge(id, cost, origin, dest);
    }

    public BigInteger getID() {
        return id;
    }

    public Node getOrigin() {
        return origin;
    }

    public Node getDest() {
        return dest;
    }

    public BigInteger getCost() {
        return cost;
    }
}

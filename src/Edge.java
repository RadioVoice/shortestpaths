import java.math.BigInteger;

public interface Edge {
    public BigInteger getID();
    public Node getOrigin();
    public Node getDest();
    public BigInteger getCost();
}

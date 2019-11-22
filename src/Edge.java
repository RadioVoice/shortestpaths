import java.math.BigInteger;

public interface Edge {
    BigInteger getID();
    Node getOrigin();
    Node getDest();
    BigInteger getCost();
}

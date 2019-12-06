import java.math.BigInteger;

/** Interface representing an 'edge' or connection between two nodes.
 * is implemented by other classes representing edges
 * @author Jack Bilotti
 */
public interface Edge {

    /**
     *
     * @return Returns the id of the edge
     */
    BigInteger getID();

    /**
     *
     * @return Returns the origin node of the edge
     */
    Node getOrigin();

    /**
     *
     * @return Returns the destination node of the edge
     */
    Node getDest();

    /**
     *
     * @return Returns the 'cost' or weight/value to an edge
     */
    BigInteger getCost();
}

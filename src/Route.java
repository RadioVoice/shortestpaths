import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Objects;

public class Route {
    private LinkedList<Node> nodes;
    private LinkedList<Edge> edges;
    private BigInteger totalCost;

    public Route(){
        nodes = new LinkedList<Node>();
        edges = new LinkedList<Edge>();
        totalCost = new BigInteger("0");
    }

    public void add(Node node){
        Objects.requireNonNull(node);
        nodes.add(node);
    }

    public void add(Edge edge){
        Objects.requireNonNull(edge);
        edges.add(edge);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while(index < nodes.size() && index < edges.size()){
            sb.append(nodes.get(index));
            sb.append(edges.get(index));
        }
        return sb.toString();
    }



}

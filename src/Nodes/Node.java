package Nodes;
import java.util.Set;
/**
 * Created by kiwid on 2017/1/11.
 */
public interface Node {
    String inner();
    boolean hasChild();
    Set<Node> getChildren();
    static Node of(String id){
        throw new RuntimeException("No expected implemention was found",new NullPointerException());
    }
}

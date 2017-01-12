package Nodes;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by kiwid on 2017/1/11.
 */
public class ParentNode implements Node,Texts,Container{
    private HashMap<Index,Node> children;
    private Tags tag;
    {
        children=new HashMap<Index,Node>(32,0.9f);
    }
    private ParentNode(Tags tag) {
        this.tag=tag;
    }
    public static Node of(Tags tag){
        return new ParentNode(tag);
    }
    public String inner(){
        StringBuilder ret=new StringBuilder(64);
        for(Node n:children.values()){
            ret.append(n.toString());
        }
        return ret.toString();
    }
    public boolean hasChild(){
        return true;
    }
    public Set<Node> getChildren(){
        return new HashSet<Node>(children.values());
    }
    public static Node of(String id){
        return of(Tags.valueOf(id));
    }
    public String toString(){
        return String.format("<%1s>$2s</%1s>",tag,inner());
    }

    @Override
    public Node appendText(String txt) {
        this.appendChild(TextNode.of(txt));
        return this;
    }

    @Override
    public Node appendChild(Node n) {
        children.put(Index.of(children.size()),n);
        return this;
    }
}

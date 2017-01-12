package Nodes;

import java.util.Set;
/**
 * Created by kiwid on 2017/1/11.
 */
public class TextNode implements Node,Texts{
    private StringBuilder content;
    private TextNode(String con) {
        content=new StringBuilder(con);
    }
    private static final int BLANKLENGTH;
    private static final String BLANK;
    static {
        BLANKLENGTH=16;
        BLANK = "                ";
        assert BLANK.length()==BLANKLENGTH;
    }
    public String inner(){
        return content.toString();
    }
    public boolean hasChild(){
        return true;
    }
    public Set<Node> getChildren(){
        throw new UnsupportedOperationException();
    }
    public static Node of(String id){
        if(id==null){
            id=BLANK;
        }
        return new TextNode(id);
    }
    public String toString(){
        return inner();
    }

    @Override
    public Node appendText(String txt) {
        content.append(txt);
        return this;
    }
}

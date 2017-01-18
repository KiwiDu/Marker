package Nodes;

import java.util.Set;

/**
 * This is Marker,
 * which was created by kiwid on 2017/1/11.
 * All rights reserved.
 */
public class TextNode implements Node, Node.Texts {
    private StringBuilder content;

    private TextNode(String con) {
        content = new StringBuilder(con);
    }

    public static TextNode of(String id) {
        id = id == null ? "" : id;
        return new TextNode(id);
    }

    @Override
    public String inner() {
        return content.toString();
    }

    @Override
    public Tags getTag() {
        return Tags.TEXT;
    }

    public boolean hasChild() {
        return true;
    }

    public Set<Node> getChildrenSet() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return inner();
    }

    @Override
    public TextNode appendText(String txt) {
        content.append(txt);
        return this;
    }
}

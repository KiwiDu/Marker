package BasicNode;

import java.util.Collection;

/**
 * This is Marker,
 * which was created by kiwid on 2017/1/11.
 * All rights reserved.
 */
public final class TextNode implements Node {
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

    @Override
    public boolean canContain(Tags t) {
        return false;
    }

    @Override
    public Node appendChild(Node n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Node appendChildren(Node... c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Node appendChildren(Collection<Node> c) {
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

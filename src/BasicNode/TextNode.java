package BasicNode;

import Rendering.Tags;
import main.Unreachable;

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
    public Struct getType() {
        return Struct.Text;
    }

    @Override
    public boolean canContain(Struct type) {
        return false;
    }

    @Unreachable
    @Override
    public Node appendChild(Node n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return String.format("<TEXT>%s</TEXT>", inner());
    }

    @Override
    public TextNode appendText(String txt) {
        content.append(txt);
        return this;
    }

    @Override
    public String toRendered() {
        return inner();
    }
}

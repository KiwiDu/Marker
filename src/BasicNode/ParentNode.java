package BasicNode;

import Utils.Index;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;

/**
 * This is Marker,
 * which was created by kiwid on 2017/1/11.
 * All rights reserved.
 */
public class ParentNode implements Node {
    private LinkedHashMap<Index, Node> children;
    private Tags tag;

    {
        children = new LinkedHashMap<>(32, 0.9f);
    }

    private ParentNode(Tags tag) {
        this.tag = tag;
    }

    public static ParentNode of(Tags tag) {
        return new ParentNode(tag);
    }

    public static ParentNode of(String id) {
        return of(Tags.valueOf(id));
    }

    public String inner() {
        StringBuilder ret = new StringBuilder(64);
        for (Node n : children.values()) {
            ret.append(n.toString());
        }
        return ret.toString();
    }

    @Override
    public Tags getTag() {
        return tag;
    }

    @Override
    public boolean canContain(Tags t) {
        return true;
    }

    public String toString() {
        return String.format("<%1$s>%2$s</%1$s>", tag, inner());
    }

    @Override
    public ParentNode appendText(String txt) {
        Node n = children.get(Index.of(children.size()));
        if (n instanceof TextNode) {
            ((TextNode) n).appendText(txt);
        } else {
            this.appendChild(TextNode.of(txt));
        }
        return this;
    }

    @Override
    public ParentNode appendChild(Node n) {
        children.put(Index.of(children.size()), n);
        return this;
    }

    @Override
    public ParentNode appendChildren(Collection<Node> c) {
        c.forEach(this::appendChild);
        return this;
    }

    @Override
    public ParentNode appendChildren(Node... c) {
        Arrays.stream(c).forEach(this::appendChild);
        return this;
    }
}

package BasicNode;

import Rendering.DefaultRenderEngine;
import Utils.Index;

import java.util.LinkedHashMap;
import java.util.function.Function;

/**
 * This is Marker,
 * which was created by kiwid on 2017/1/11.
 * All rights reserved.
 */
public abstract class ParentNode implements Node {
    protected Struct type;
    private LinkedHashMap<Index, Node> children;

    {
        children = new LinkedHashMap<>(32, 0.9f);
    }

    protected ParentNode(Struct type) {
        this.type = type;
    }

    protected String rec(Function<Node,String> src){
        StringBuilder ret = new StringBuilder(64);
        for (Node n : children.values()) {
            ret.append(src.apply(n));
        }
        return ret.toString();
    }

    public String inner() {
        return rec(Node::toString);
    }

    @Override
    public Struct getType() {
        return type;
    }

    protected abstract String getTemplate(int... info);

    @Override
    public String toString() {
        return String.format(getTemplate(), type, inner());
    }

    @Override
    public String toRendered(){
        return String.format(getTemplate(), DefaultRenderEngine.getImpl(this),rec(Node::toRendered));
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
}

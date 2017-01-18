package Nodes;

import java.util.ArrayDeque;

/**
 * This is Marker,
 * which was created by kiwid on 2017/1/17.
 * All rights reserved.
 */
public class NodeTree2 {
    private ParentNode root;
    private ArrayDeque<ParentNode> stack, ROOT_ONLY;

    {
        root = ParentNode.of(Tags.body);
        ROOT_ONLY = new ArrayDeque<>();
        ROOT_ONLY.add(root);
        renew();
    }

    public ParentNode getRoot() {
        return root;
    }

    @Deprecated
    public NodeTree2 child(Tags t) {

        return this;
    }

    public NodeTree2 child(Node n) {
        ParentNode last = stack.getLast();
        //System.out.println(String.format("Node:(%s)is appended to(%s)", n, last));
        last.appendChild(n);
        stack.add((ParentNode) n);
        return this;
    }

    public NodeTree2 parent() {
        stack.removeLast();
        return this;
    }

    public void renew() {
        stack = new ArrayDeque<>(ROOT_ONLY);
    }
}

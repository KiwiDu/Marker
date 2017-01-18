package BasicNode;

import java.util.ArrayDeque;

/**
 * This is Marker,
 * which was created by kiwid on 2017/1/17.
 * All rights reserved.
 */
public class NodeTree {
    private ParentNode root;
    private ArrayDeque<Node> stack;

    {
        root = ParentNode.of(Tags.body);
        stack = new ArrayDeque<>();
        stack.add(root);
    }

    public ParentNode getRoot() {
        return root;
    }

    public NodeTree child(Node n) {
        Node last;
        do {
            last = stack.pollLast();
        }
        while (!last.canContain(n.getTag()) && !stack.isEmpty());

        stack.add(last);//put it back
        last.appendChild(n);
        stack.add(n);
        return this;
    }
}

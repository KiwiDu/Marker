package Nodes;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * This is Marker,
 * which was created by kiwidu on 2017/1/13.
 * All rights reserved.
 */
@Deprecated
public class NodeTree {
    private ParentNode root;
    private HashMap<Tags, STATUS> preparation;
    private ArrayDeque<ParentNode> stack;

    {
        root = ParentNode.of(Tags.body);
        preparation = new HashMap<>(32);
        stack = new ArrayDeque<>();
        stack.add(root);
    }

    public ParentNode getRoot() {
        return root;
    }

    private RETURN append(ParentNode parent, Node n) {
        if (n.equals(parent)) {
            return RETURN.FAILED;
        }
        if (n instanceof ParentNode) {
            parent.appendChild(n);
            return RETURN.CREATED;
        } else if (n instanceof TextNode) {
            parent.appendText(n.inner());
            return RETURN.MERGED;
        }
        return RETURN.FAILED;
    }

    public NodeTree child(Node n) {
        ParentNode last = stack.getLast();
        //System.out.println(String.format("Node:(%s)is appended to(%s)", n, last));
        RETURN ret = append(last, n);
        if (ret == RETURN.CREATED) {
            stack.add((ParentNode) n);
        }
        return this;
    }

    private Optional<Node[]> getTmp() {
        Node n = stack.getLast();
        if (n.getTag() == Tags.TEMP) {
            int length = n.getChildrenSet().size();
            Node[] tmp = new Node[length];
            stack.pollLast().getChildrenSet().toArray(tmp);
            return Optional.of(tmp);
        } else {
            return Optional.empty();
        }
    }

    public NodeTree prepare(Tags tag, Consumer<Tags> c) {
        return prepare(tag, c, STATUS.INLINE);
    }

    public NodeTree prepare(Tags tag, Consumer<Tags> c, STATUS s) {
        if (preparation.containsKey(tag)) {
            System.out.println(stack.getLast());
            Optional<Node[]> tmp = getTmp();//it must exists
            assert tmp.isPresent();//if it does not exists then the program acts wrong
            c.accept(tag);
            System.out.println(stack.getLast());
            System.out.println(Arrays.toString(tmp.get()));
            stack.getLast().appendChildren(tmp.get());
            System.out.println(stack.getLast());
            preparation.remove(tag);
        } else {
            preparation.put(tag, s);
            stack.add(ParentNode.of(Tags.TEMP));
        }
        return this;
    }

    public NodeTree relax() {
        Optional<Node[]> tmp = getTmp();
        tmp.ifPresent((n) -> stack.getLast().appendChildren(n));
        preparation.keySet().stream()
                .filter((key) -> preparation.get(key) == STATUS.INLINE)
                .forEach((key) -> preparation.remove(key));
        return this;
    }

    @Override
    public String toString() {
        return root.toString();
    }

    protected enum RETURN {
        CREATED, MERGED, FAILED
    }

    protected enum STATUS {
        INLINE, GLOBAL
    }
}

package Nodes;

import java.util.Collection;
import java.util.Set;

/**
 * This is Marker,
 * which was created by kiwid on 2017/1/11.
 * All rights reserved.
 */
public interface Node {
    @SuppressWarnings("unused")
    static Node of(String id) {
        throw new RuntimeException("No expected implementation was found", new NullPointerException());
    }

    String inner();

    Tags getTag();

    @SuppressWarnings("unused")
    boolean hasChild();

    @SuppressWarnings("unused")
    Set<Node> getChildrenSet();

    interface Container extends Node {
        Container appendChild(Node n);

        Container appendChildren(Node... c);

        Container appendChildren(Collection<Node> c);
    }

    interface Texts extends Node {
        Texts appendText(String txt);
    }
}

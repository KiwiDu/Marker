package BasicNode;

import java.util.Collection;

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

    boolean canContain(Tags t);

    Node appendChild(Node n);

    Node appendChildren(Node... c);

    Node appendChildren(Collection<Node> c);

    Node appendText(String txt);
}

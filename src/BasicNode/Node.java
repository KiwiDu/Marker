package BasicNode;

import Rendering.Renderable;
import main.Dicts;

import java.util.Objects;

/**
 * This is Marker,
 * which was created by kiwid on 2017/1/11.
 * All rights reserved.
 */
public interface Node extends Renderable {

    @SuppressWarnings("unused")
    static Node of(Struct type) {
        Objects.requireNonNull(type);
        try {
            return Dicts.impl(type).getConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new RuntimeException(String.format("No expected implementation for %s was found", type));
    }

    String inner();

    Struct getType();

    boolean canContain(Struct type);

    Node appendChild(Node n);

    Node appendText(String txt);
}

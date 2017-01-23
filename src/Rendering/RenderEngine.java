package Rendering;

import BasicNode.Struct;

import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * This is Marker,
 * which was created by kiwid on 2017/1/19.
 * All rights reserved.
 */
public class RenderEngine {
    StringBuilder pool = new StringBuilder(256);


    public RenderEngine accept(Renderable r) {
        pool.append(r.toRendered());
        return this;
    }

    public String render() {
        return pool.toString();
    }
}

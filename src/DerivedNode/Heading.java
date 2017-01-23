package DerivedNode;

import BasicNode.Struct;

/**
 * This is Marker,
 * which was created by kiwid on 2017/1/18.
 * All rights reserved.
 */
public class Heading extends SimpleNode {
    private int level;

    public Heading() {
        super(Struct.Heading);
    }

    public Heading(int level) {
        this();
        this.level = level;
    }

    @Override
    public boolean canContain(Struct type) {
        return false;
    }

    public int getLevel() {
        return level;
    }
}

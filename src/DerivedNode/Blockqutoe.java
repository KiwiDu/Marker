package DerivedNode;

import BasicNode.Struct;

/**
 * This is Marker,
 * which was created by kiwid on 2017/1/19.
 * All rights reserved.
 */
public class Blockqutoe extends SimpleNode {
    public Blockqutoe() {
        super(Struct.Blockqutoe);
    }

    @Override
    public boolean canContain(Struct type) {
        return true;
    }
}

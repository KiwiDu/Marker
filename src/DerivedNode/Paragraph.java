package DerivedNode;

import BasicNode.Struct;

/**
 * This is Marker,
 * which was created by kiwid on 2017/1/18.
 * All rights reserved.
 */
public class Paragraph extends SimpleNode {
    public Paragraph() {
        super(Struct.Paragraph);
    }

    @Override
    public boolean canContain(Struct type) {
        return type.isText();
    }
}

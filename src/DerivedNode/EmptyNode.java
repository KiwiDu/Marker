package DerivedNode;

import BasicNode.ParentNode;
import BasicNode.Struct;

/**
 * This is Marker,
 * which was created by kiwid on 2017/1/18.
 * All rights reserved.
 */
public abstract class EmptyNode extends ParentNode {
    public EmptyNode(Struct type) {
        super(type);
    }

    @Override
    protected String getTemplate(int... args) {
        return "<%s />\n";
    }

    @Override
    public boolean canContain(Struct type) {
        return false;
    }
}

package DerivedNode;

import BasicNode.ParentNode;
import BasicNode.Struct;

/**
 * This is Marker,
 * which was created by kiwid on 2017/1/19.
 * All rights reserved.
 */
public class RootNode extends ParentNode {
    public RootNode() {
        super(Struct.Root);
    }

    @Override
    protected String getTemplate(int... args) {
        return "<%1$s>\n%2$s</%1$s>";
    }

    @Override
    public boolean canContain(Struct type) {
        return true;
    }
}

package DerivedNode;

import BasicNode.ParentNode;
import BasicNode.Struct;

/**
 * This is Marker,
 * which was created by kiwid on 2017/1/18.
 * All rights reserved.
 */
public abstract class SimpleNode extends ParentNode {

    public SimpleNode(Struct type) {
        super(type);
    }

    @Override
    protected String getTemplate(int... args) {
        return "<%1$s>%2$s</%1$s>\n";
    }
}

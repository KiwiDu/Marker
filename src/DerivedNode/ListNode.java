package DerivedNode;

import BasicNode.Struct;

/**
 * This is Marker,
 * which was created by kiwid on 2017/1/19.
 * All rights reserved.
 */
public abstract class ListNode extends SimpleNode {
    public ListNode(Struct type) {
        super(type);
    }

    @Override
    public boolean canContain(Struct type) {
        return type == Struct.List_item;
    }
}

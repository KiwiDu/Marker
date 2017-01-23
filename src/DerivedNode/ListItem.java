package DerivedNode;

import BasicNode.Struct;

/**
 * This is Marker,
 * which was created by kiwid on 2017/1/19.
 * All rights reserved.
 */
public class ListItem extends SimpleNode {
    private Struct parentType;
    private char characteristic;
    public ListItem() {
        super(Struct.List_item);
    }

    public ListItem(Struct parentType,char characteristic) {
        this();
        this.parentType = parentType;
        this.characteristic = characteristic;
    }

    @Override
    public boolean canContain(Struct type) {
        switch (type) {
            case Paragraph:
            case Ordered_list:
            case Unordered_list:
                return true;
        }
        return false;
    }

    public char getCharacteristic() {
        return characteristic;
    }

    public Struct getParentType() {
        return parentType;
    }
}

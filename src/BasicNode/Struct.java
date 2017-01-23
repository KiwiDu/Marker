package BasicNode;

/**
 * This is Marker,
 * which was created by kiwid on 2017/1/11.
 * All rights reserved.
 */
@SuppressWarnings("unused")
public enum Struct {
    //for special use
    Text, Root, Simple,
    //the elements
    Heading,
    Bold, Italic, Plain, Code,
    Unordered_list, Ordered_list, List_item,
    Blockqutoe, Paragraph,
    //divisors
    Blank(TYPE.EMPTY), Rule(TYPE.EMPTY);

    TYPE type;

    Struct(TYPE _type) {
        type = _type;
    }

    Struct() {
        type = TYPE.NORMAL;
    }

    public Class<?> toClass() {
        try {
            return Class.forName(name());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Can not find the responding class,check naming.", e);
        }
    }

    public boolean isText() {
        switch (this) {
            case Text:
            case Bold:
            case Italic:
            case Code:
                return true;
        }
        return false;
    }

    enum TYPE {
        EMPTY, NORMAL;
    }
}

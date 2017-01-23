package main;

import BasicNode.Node;
import BasicNode.Struct;
import DerivedNode.*;

import java.util.HashMap;
import java.util.regex.Pattern;

/**
 * This is Marker,
 * which was created by kiwid on 2017/1/17.
 * All rights reserved.
 */
public class Dicts {
    private static HashMap<Pattern, Struct> blockDict;
    private static HashMap<Struct, Class<? extends Node>> impl_map;

    static {
        blockDict = new HashMap<>(32);
        impl_map = new HashMap<>(32);
        //blocks
        block(Struct.Blockqutoe, "(?:[>][ ])(.*)");
        block(Struct.Heading, "(?:[#]{1,6}[ ])(.*?)(#*)");
        block(Struct.List_item, "(?:[*)][ ])(.*)");
        block(Struct.List_item, "(?:\\d{1,}[.][ ])(.*)");
        block(Struct.Blank, "(?:[ ]{2,})()");
        // TODO: 2017/1/22 Nothing to do,but this is very significant in IntelliJ
        block(Struct.Rule, "(?:[*=-]{3,})()");//Here used to be a bug,"*-="means from '*' to '=',while "*=-" avoid this problem.
        //mapping
        map(Struct.Root, RootNode.class);
        map(Struct.Heading, Heading.class);
        map(Struct.Blockqutoe, Blockqutoe.class);
        map(Struct.List_item, ListItem.class);
        map(Struct.Ordered_list, OrderedList.class);
        map(Struct.Unordered_list, UnorderedList.class);
        map(Struct.Code, RootNode.class);// FIXME: 2017/1/19 TODO
        map(Struct.Paragraph, Paragraph.class);
        map(Struct.Rule, HorizontalRule.class);
        map(Struct.Blank, BlankRule.class);
    }

    private static void block(Struct t, String pat) {
        blockDict.put(Pattern.compile(pat), t);
    }

    private static void map(Struct s, Class<? extends Node> cls) {
        impl_map.put(s, cls);
    }

    public static HashMap<Pattern, Struct> getBlockDict() {
        return blockDict;
    }

    public static Class<? extends Node> impl(Struct type) {
        return impl_map.get(type);
    }
}

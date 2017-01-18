package main;

import BasicNode.Tags;

import java.util.HashMap;
import java.util.regex.Pattern;

/**
 * This is Marker,
 * which was created by kiwid on 2017/1/17.
 * All rights reserved.
 */
public class Dict {
    private static HashMap<Pattern, Tags> blockDict;
    private static HashMap<Pattern, Tags> inlineDict;

    static {
        blockDict = new HashMap<>(32);
        inlineDict = new HashMap<>(32);
        //blocks
        block(Tags.blockqutoe, "(?:[>][ ])([^ ]*)");
        block(Tags.h1, "(?:[#][ ])([^ ]*)");
        block(Tags.h2, "(?:[#]{2}[ ])([^ ]*)");
        block(Tags.h3, "(?:[#]{3}[ ])([^ ]*)");
        block(Tags.h4, "(?:[#]{4}[ ])([^ ]*)");
        block(Tags.h5, "(?:[#]{5}[ ])([^ ]*)");
        block(Tags.h6, "(?:[#]{6}[ ])([^ ]*)");
        block(Tags.li, "(?:[*][ ])([^ ]*)");
        block(Tags.li, "(?:\\d{1,}[.][ ])([^ ]*)");
        block(Tags.br, "(?:[ ]{3,})()");
        block(Tags.hr, "(?:[*-=]{3,})()");
        //inlines

    }

    private static void block(Tags t, String pat) {
        blockDict.put(Pattern.compile(pat), t);
    }
    private static void inline(Tags t, String pat) {
        inlineDict.put(Pattern.compile(pat), t);
    }

    public static HashMap<Pattern, Tags> getBlockDict() {
        return blockDict;
    }
    public static HashMap<Pattern, Tags> getInlineDict() {
        return inlineDict;
    }
}

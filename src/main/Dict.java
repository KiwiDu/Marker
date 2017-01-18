package main;

import Nodes.Tags;

import java.util.HashMap;
import java.util.regex.Pattern;

/**
 * This is Marker,
 * which was created by kiwid on 2017/1/17.
 * All rights reserved.
 */
public class Dict {
    private static HashMap<Pattern, Tags> blockDict;

    static {
        blockDict = new HashMap<>(32);
        item(Tags.blockqutoe, "([>][ ])([^ ]*)");
        item(Tags.h1, "([#][ ])([^ ]*)");
        item(Tags.h2, "([#]{2}[ ])([^ ]*)");
        item(Tags.h3, "([#]{3}[ ])([^ ]*)");
        item(Tags.h4, "([#]{4}[ ])([^ ]*)");
        item(Tags.h5, "([#]{5}[ ])([^ ]*)");
        item(Tags.h6, "([#]{6}[ ])([^ ]*)");
        item(Tags.ul, "([*][ ])([^ ]*)");
        item(Tags.ol, "(\\d{1,}[.][ ])([^ ]*)");
        item(Tags.br, "([ ]{2,})()");
        item(Tags.hr, "([*-=]{3,})()");
    }

    private static void item(Tags t, String pat) {
        blockDict.put(Pattern.compile(pat), t);
    }

    public static HashMap<Pattern, Tags> getBlockDict() {
        return blockDict;
    }
}

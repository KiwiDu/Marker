package main;

import BasicNode.Node;
import BasicNode.NodeTree;
import BasicNode.ParentNode;
import BasicNode.Tags;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This is Marker,
 * which was created by kiwid on 2017/1/17.
 * All rights reserved.
 */
public enum Parser {
    instance;
    NodeTree AST;
    public Node parse(String in) {
        AST = new NodeTree();
        String[] lines = in.split("\n");
        Arrays.stream(lines)
                .map(this::checkBlock)
                .map(this::convertInline)
                .forEach(AST::child)
        ;
        return AST.getRoot();
    }

    private Node checkBlock(String in) {
        HashMap<Pattern, Tags> dict = Dict.getBlockDict();
        final String finalIn = in;
        Optional<Matcher> opt = dict.keySet().stream()
                .map(p -> p.matcher(finalIn))
                .filter(Matcher::matches)
                .findFirst();

        Tags t = opt.map(Matcher::pattern)
                .map(dict::get)
                .orElse(Tags.p);

        if (opt.isPresent()) {
            in = opt.get().group(1);
        }

        return ParentNode.of(t).appendText(in);
    }

    private Node convertInline(Node line) {
        return line;
    }
}

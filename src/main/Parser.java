package main;

import BasicNode.Node;
import BasicNode.NodeTree;
import BasicNode.Struct;
import BasicNode.TextNode;
import DerivedNode.Heading;
import DerivedNode.ListItem;
import Utils.Pair;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This is Marker,
 * which was created by kiwid on 2017/1/17.
 * All rights reserved.
 */
public enum Parser {
    instance;
    NodeTree AST=new NodeTree();

    public Node parse(String in) {
        //AST = new NodeTree();
        String[] lines = in.split("\n");
        Arrays.stream(lines)
                .map(this::checkBlock)
                //.map(n->{assert n!= null;return n;})
                //.map(this::convertInline)
                //.map(n->{assert n!= null;return n;})
                .forEach(AST::prepare)
        ;
        return AST.begin().getRoot();
    }

    private Node checkBlock(String in){
        return checkBlock(in,true);
    }

    private Node checkBlock(String in,boolean isRoot) {
        HashMap<Pattern, Struct> dict = Dicts.getBlockDict();
        final String finalIn = in;//an unchangeable copy
        Optional<Matcher> opt = dict.keySet().stream()
                .map(p -> p.matcher(finalIn))
                .filter(Matcher::matches)
                .findFirst();

        Struct t = opt.map(Matcher::pattern)
                .map(dict::get)
                .orElse(isRoot?Struct.Paragraph:Struct.Text);

        if(t == Struct.Text) {
            return TextNode.of(in);//the exit
        }

        if(opt.isPresent()) {
            in = opt.get().group(1);
        }

        Node[] parsed=new Node[1];//its a pointer
        switch (t){
            case Heading: {
                int level=finalIn.split(" ", 2)[0].length();
                parsed[0]= new Heading(level);
                break;
            }
            case List_item:{
                String head=finalIn.split(" ", 2)[0];
                Struct type=head.length()==1?Struct.Unordered_list:Struct.Ordered_list;
                char c=type==Struct.Unordered_list ? head.charAt(0) : '1';
                parsed[0]= new ListItem(type,c);
                break;
            }
            default:
                parsed[0] = Node.of(t);
        }
        return parsed[0].appendChild(checkBlock(in,false));
    }

    /*
    private Node convertInline(Node line) {
        return line;
    }
    */
}

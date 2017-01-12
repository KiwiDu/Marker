package main;

import Nodes.Node;
import Nodes.TextNode;

/**
 * Created by kiwid on 2017/1/11.
 */
public enum Parser {
    instance;
    public Node parse(String s){
        return TextNode.of(s);
    }
}

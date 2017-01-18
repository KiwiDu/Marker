package main;

import Nodes.*;
import Utils.Nodes;

import java.io.IOException;
import java.io.PushbackReader;
import java.io.StringReader;

@Deprecated
public enum Parser {
    instance;
    /**
     * Created by kiwid on 2017/1/11.
     */
    public NodeTree AST;

    public Node parse(String s) {
        AST = new NodeTree();
        try (PushbackReader in = new PushbackReader(new StringReader(s), 128)) {//128 should be enough
            char[] c = new char[1];
            char[] buffer = new char[32];
            boolean new_line, file_begin = true;
            while (in.read(c) != -1) {
                new_line = (c[0] == '\n') || file_begin;
                file_begin = false;
                if (new_line) {
                    int len;
                    AST.relax();
                    switch (c[0]) {
                        case '#':
                            len = 6;//the first '#' has already been read,plus the required blank,that's six;
                            len = in.read(buffer, 0, len);
                            int level = 0;
                            for (; level < len - 1; level++) {
                                if (buffer[level] != '#') {
                                    break;
                                }
                            }
                            if (Character.isWhitespace(buffer[level])) {
                                AST.child(Nodes.headerOf(level + 1));
                                level++;
                                in.unread(buffer, level, len - level);
                            } else {
                                in.unread(buffer, 0, len);
                                in.unread(c);
                                AST.child(ParentNode.of(Tags.p));
                            }
                            break;
                        case '*':
                            len = 1;
                            len = in.read(buffer, 0, len);
                            if (Character.isWhitespace(buffer[0])) {
                                AST.child(ParentNode.of(Tags.ul));
                                AST.child(ParentNode.of(Tags.li));
                            } else {
                                in.unread(buffer, 0, len);
                                in.unread(c);
                            }
                            break;
                        default:
                            in.unread(c);
                            AST.child(ParentNode.of(Tags.p));
                    }
                } else {
                    switch (c[0]) {
                        case '*':
                            if (in.read() == '*') {
                                AST.prepare(Tags.i, (t) -> AST.child(ParentNode.of(t)));
                            } else {
                                in.unread('*');
                                AST.prepare(Tags.b, (t) -> AST.child(ParentNode.of(t)));
                            }
                            break;
                        default:
                            AST.child(TextNode.of(String.valueOf(c)));
                    }
                }
            }
        } catch (IOException e) {
            synchronized (System.out) {
                e.printStackTrace();
            }
        }
        return AST.getRoot();
    }
}

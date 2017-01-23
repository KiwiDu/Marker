package BasicNode;

import DerivedNode.ListItem;
import DerivedNode.RootNode;

import java.util.ArrayDeque;
import java.util.HashSet;

/**
 * This is Marker,
 * which was created by kiwid on 2017/1/17.
 * All rights reserved.
 */
public class NodeTree {
    private RootNode root;
    private ArrayDeque<Node> stack;
    private ArrayDeque<Node> queue;
    private HashSet<Character> flag;

    {
        root = (RootNode) Node.of(Struct.Root);
        stack = new ArrayDeque<>(32);
        queue = new ArrayDeque<>(128);
        flag=new HashSet<>(32);
        stack.add(root);
    }

    public ParentNode getRoot() {
        return root;
    }

    private NodeTree child(Node n) {
        Node last;
        do {
            last = stack.pollLast();
        }
        while (!last.canContain(n.getType()) && !stack.isEmpty());

        stack.add(last);//put it back
        last.appendChild(n);
        stack.add(n);
        return this;
    }

    public NodeTree prepare(Node n){
        queue.add(n);
        return this;
    }

    public NodeTree begin(){
        Node n;
        while(!queue.isEmpty()){
            n=queue.peek();
            if(n instanceof ListItem){  //A special case
                ListItem li= (ListItem)n;
                Character characteristic=li.getCharacteristic();
                if(!flag.contains(characteristic)) {
                    flag.add(characteristic);
                    queue.push(Node.of(li.getParentType()));//create a parent list to hold them.
                }
            }
            child(queue.pop());
        }
        return this;
    }
}


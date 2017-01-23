package Rendering;

import BasicNode.Node;
import BasicNode.Struct;
import DerivedNode.Heading;

import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * This is Marker,
 * which was created by kiwid on 2017/1/23.
 * All rights reserved.
 */
public class DefaultRenderEngine extends RenderEngine{
    private static HashMap<Struct,Tags> impl;
    private static void loadImplFromText(String s){
        StringTokenizer st=new StringTokenizer(s.replaceAll(" ",""),",;");
        while (st.hasMoreTokens()){
            Struct type = Struct.valueOf(st.nextToken());
            assert st.hasMoreTokens();
            Tags tag = Tags.valueOf(st.nextToken());
            impl.put(type,tag);
        }
    }
    static {
        impl = new HashMap<>(32);
        loadImplFromText("Root,body; Blockqutoe,blockqutoe; " +
                "List_item,li; Ordered_list,ol; Unordered_list,ul; " +
                "Code,code; Paragraph,p; Rule,hr; Blank,br;" +
                "Root,body");
        //impl.entrySet().stream().forEach((e)-> System.out.printf("%s:%s\n",e.getKey(),e.getValue()));
    }

    public static Tags getImpl(Node n){
        Struct s=n.getType();
        switch (s){
            case Text:
                return null;
            case Heading:
                return Tags.valueOf("h"+((Heading)n).getLevel());
        }
        return impl.get(n.getType());
    }


}

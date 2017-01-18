package Utils;
/**
 * This is Marker,
 * which was created by kiwid on 2017/1/13.
 * All rights reserved.
 */

import BasicNode.ParentNode;

public class Nodes {
    public static ParentNode headerOf(int level) {
        if (level > 6 || level < 1) {
            level = 1;
        }
        return ParentNode.of("h" + level);
    }
}

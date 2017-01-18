package Utils;

import java.util.Arrays;

/**
 * This is Marker,
 * which was created by kiwid on 2017/1/12.
 * All rights reserved.
 */
public class Index {
    private static IndexPool pool;

    static {
        pool = new IndexPool();
    }

    private final int i;

    private Index(int _i) {
        i = _i;
    }

    public static Index of(int i) {
        return pool.getRef(i);
    }

    public int index() {
        return i;
    }

    private static class IndexPool {
        static Index[] indexes;

        static {
            indexes = new Index[256];
        }

        Index getRef(int n) {
            if (n < 0) {
                throw new IndexOutOfBoundsException();
            }
            if (indexes.length < n) {
                indexes = Arrays.copyOfRange(indexes, 0, n + 16);//expand the array if needed.
            }
            if (indexes[n] == null) {
                indexes[n] = new Index(n);
            }
            return indexes[n];
        }
    }
}

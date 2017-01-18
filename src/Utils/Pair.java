package Utils;

/**
 * This is Marker,
 * which was created by kiwid on 2017/1/16.
 * All rights reserved.
 */
@SuppressWarnings("unused")
public final class Pair<A, B> {
    private final A first;
    private final B second;

    private Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }

    public Pair of(A first, B second) {
        return new Pair(first, second);
    }

    @Override
    public int hashCode() {
        int hashFirst = first != null ? first.hashCode() : 0;
        int hashSecond = second != null ? second.hashCode() : 0;
        return (hashFirst + hashSecond) * hashSecond + hashFirst;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Pair) {
            Pair otherPair = (Pair) other;
            return
                    ((this.first == otherPair.first ||
                            (this.first != null && otherPair.first != null &&
                                    this.first.equals(otherPair.first))) &&
                            (this.second == otherPair.second ||
                                    (this.second != null && otherPair.second != null &&
                                            this.second.equals(otherPair.second))));
        }

        return false;
    }

    public String toString() {
        return String.format("( %s , %s )", first, second);
    }

    public A getFirst() {
        return first;
    }

    public B getSecond() {
        return second;
    }
}
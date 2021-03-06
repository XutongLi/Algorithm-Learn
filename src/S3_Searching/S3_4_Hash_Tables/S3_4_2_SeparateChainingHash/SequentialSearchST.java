package S3_Searching.S3_4_Hash_Tables.S3_4_2_SeparateChainingHash;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Brian Lee on 2018/9/2.
 */
public class SequentialSearchST<Key, Value> {
    private Node first;
    private int len = 0;
    private class Node {
        Key key;
        Value val;
        Node next;
        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }
    public Value get(Key key) {
        if (len == 0)
            return null;
        for (Node x = first; x != null; x = x.next)
            if (key.equals(x.key))
                return x.val;
        return null;
    }
    public void put(Key key, Value val) {
        for (Node x = first; x != null; x = x.next)
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }
        first = new Node(key, val, first);
        len ++;
    }
    public int size() {
        return len;
    }
    public Iterable<Key> keys() {
        Queue<Key> keys = new LinkedList<>();
        for (Node x = first; x != null; x = x.next)
            keys.offer(x.key);
        return keys;
    }
    public Iterable<Value> values() {
        Queue<Value> vals = new LinkedList<>();
        for (Node x = first; x != null; x = x.next)
            vals.offer(x.val);
        return vals;
    }
    public Value delete(Key key) {
        if (key.equals(first.key)) {
            Value res = first.val;
            first = first.next;
            len --;
            return res;
        }
        for (Node x = first; x.next != null; x = x.next) {
            if (key.equals(x.next.key)) {
                Value res = x.next.val;
                x.next = x.next.next;
                len --;
                return res;
            }
        }
        return null;
    }
    public boolean contains(Key key) {
        return get(key) != null;
    }
}


package S1_foundation.S1_3_BagQueueStack.S1_3_3_10_Bag;
import java.util.Iterator;

/**
 * Created by Brian Lee on 2018/8/8.
 */
public class Bag<Item> implements Iterable<Item> {
    private class Node {
        Item item;
        Node next;
    }
    private Node first;     //栈顶
    private int N;          //元素数量
    public boolean isEmpty() { return N == 0; }
    public int size() { return N; }
    public void add(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N ++;
    }
    public Iterator<Item> iterator() {
        return new ListIterator();
    }
    private class ListIterator implements Iterator<Item> {
        private Node current = first;
        public boolean hasNext() { return current != null; }
        public void remove() { }
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}

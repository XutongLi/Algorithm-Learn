package S1_foundation.S1_3_BagQueueStack.S1_3_3_9_Queue;
import java.util.Iterator;

/**
 * Created by Brian Lee on 2018/8/8.
 */
public class Queue<Item> implements Iterable<Item> {
    private class Node {
        Item item;
        Node next;
    }
    private Node first; //指向最早添加的结点的链接
    private Node last;  //指向最近添加的结点的链接
    private int N;
    public boolean isEmpty() { return N == 0; }
    public int size() { return N; }
    //向表尾添加元素
    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty())
            first = last;
        else
            oldLast.next = last;
        N ++;
    }
    //从表头删除元素
    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        if (isEmpty())
            last = first;
        N --;
        return item;
    }
    public Iterator<Item> iterator() {
        return new Queue.ListIterator();
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

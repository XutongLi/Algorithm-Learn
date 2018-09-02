package S3_Searching.S3_4_Hash_Tables.S3_4_2_SeparateChainingHash;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Brian Lee on 2018/9/2.
 */
public class SeperateChainingHashST<Key, Value> {
    private int N;  //键值对总数
    private int M;  //散列表大小（M条链表）
    private SequentialSearchST<Key, Value>[] st;    //存放链表对象的数组
    //构造函数，名创建M条链表
    public SeperateChainingHashST() {
        this(997);
    }
    public SeperateChainingHashST(int M) {
        this.M = M;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
        for (int i = 0; i < M; i++)
            st[i] = new SequentialSearchST();
    }
    public int size() {
        return N;
    }
    public boolean isEmpty() {
        return size() == 0;
    }
    public boolean contains(Key key) {
        return get(key) != null;
    }
    //通过hashcode得到hash值
    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }
    public Value get(Key key) {
        return (Value) st[hash(key)].get(key);
    }
    public void put(Key key, Value val) {
        st[hash(key)].put(key, val);
    }
    public void delete(Key key) {
        int i = hash(key);
        if (st[i].contains(key))    N--;
        st[i].delete(key);
    }
    public Iterable<Key> keys() {
        Queue<Key> queue = new LinkedList<Key>();
        for (int i = 0; i < M; i++) {
            for (Key key : st[i].keys())
                queue.offer(key);
        }
        return queue;
    }
}

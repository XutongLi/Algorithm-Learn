package S3_Searching.S3_4_Hash_Tables.S3_4_3_Linear_Probing_Hash;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Brian Lee on 2018/9/2.
 */
public class LinearProbingHashST<Key, Value> {
    private int N;  //符号表中键值对的总数
    private int M = 16; //线性探测表大小
    private Key[] keys; //键
    private Value[] vals;   //值
    public LinearProbingHashST() {
        this(16);
    }
    public LinearProbingHashST(int M) {
        this.M = M;
        keys = (Key[]) new Object[M];
        vals = (Value[]) new Object[M];
    }
    public int size() {
        return N;
    }
    public boolean isEmpty() {
        return N == 0;
    }
    public boolean contains(Key key) {
        return get(key) != null;
    }
    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }
    private void resize(int cap) {
        LinearProbingHashST<Key, Value> t;
        t = new LinearProbingHashST<>(cap);
        for (int i = 0; i < M; i++) {
            if (keys[i] != null)
                t.put(keys[i], vals[i]);
        }
        keys = t.keys;
        vals = t.vals;
        M = t.M;
    }
    public void put(Key key, Value val) {
        if (N >= M / 2) resize(2 * M);
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M){
            if (keys[i].equals(key)) {
                vals[i] = val;
                return;
            }
        }
        keys[i] = key;
        vals[i] = val;
        N++;
    }
    public Value get(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M)
            if (keys[i].equals(key))
                return vals[i];
        return null;
    }
    public void delete(Key key) {
        if (!contains(key)) return;
        int i = hash(key);
        while (!key.equals(keys[i]))
            i = (i + 1) % M;
        keys[i] = null;
        vals[i] = null;
        i = (i + 1) % M;
        while (keys[i] != null) {
            Key keyToRedo = keys[i];
            Value valToRedo = vals[i];
            keys[i] = null;
            vals[i] = null;
            N--;
            put(keyToRedo, valToRedo);
            i = (i + 1) % M;
        }
        N--;
        if (N > 0 && N <= M / 8)
            resize(M / 2);
    }
    public Iterable<Key> keys() {
        Queue<Key> queue = new LinkedList<>();
        for (int i = 0; i < M; i++)
            if (keys[i] != null)
                queue.offer(keys[i]);
        return queue;
    }
}

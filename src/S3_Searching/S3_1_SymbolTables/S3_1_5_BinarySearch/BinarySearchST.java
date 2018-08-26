package S3_Searching.S3_1_SymbolTables.S3_1_5_BinarySearch;


import java.util.HashSet;

/**
 * Created by Brian Lee on 2018/8/26.
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> {
    private Key[] keys;
    private Value[] vals;
    private int N = 0;
    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Object[capacity];
    }
    public int size() {
        return N;
    }
    public boolean isEmpty() {
        return N == 0;
    }
    public Value get(Key key) {
        if (isEmpty())
            return null;
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0)
            return vals[i];
        else
            return null;
    }
    public int rank(Key key) {
        int lo = 0, hi = N - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp == 0)
                return mid;
            else if (cmp < 0)
                hi = mid - 1;
            else
                lo = mid + 1;
        }
        return lo;
    }
    public void put(Key key, Value val) {
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            vals[i] = val;
            return;
        }
        for (int j = N; j > i; j--) {
            keys[j] = keys[j - 1];
            vals[j] = vals[j - 1];
        }
        keys[i] = key;
        vals[i] = val;
        N++;
    }
    public void delete(Key key) {
        if (isEmpty())
            return;
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            for (int j = i; j < N - 1; j++) {
                keys[j] = keys[j + 1];
                vals[j] = vals[j + 1];
            }
            keys[N - 1] = null;
            vals[N - 1] = null;
        }
        N--;
    }
    public Key min() {
        return keys[0];
    }
    public Key max() {
        return keys[N - 1];
    }
    public Key select(int k) {
        return keys[k];
    }
    public Key ceiling(Key key) {
        int i = rank(key);
        return keys[i];
    }
    public Key floor(Key key) {
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0)
            return keys[i];
        else
            return keys[i - 1];
    }
    public boolean contains(Key key) {
        return get(key) != null;
    }
    public Iterable<Key> keys() {
        HashSet k = new HashSet();
        for (int i = 0; i < N; i++)
            k.add(keys[i]);
        return k;
    }
}

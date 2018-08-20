package S2_Sorting.S2_4_4_6_IndexMinPQ;

/**
 * Created by Brian Lee on 2018/8/20.
 */
public class IndexMinPQ<Key extends Comparable<Key>> {
    private int N = 0;      //PQ中的元素数量
    private int[] pq;   //索引二叉堆，从1开始(pq[顺序号]=索引号)
    private int[] qp;   //逆序：qp[pq[i]]=pq[qp[i]]=i(qp[索引号]=顺序号)
    private Key[] keys; //有优先级之分的元素

    public IndexMinPQ(int maxN) {
        keys = (Key[]) new Comparable[maxN + 1];
        pq = new int[maxN + 1];
        qp = new int[maxN + 1];
        for (int i = 0; i <= maxN; i++)
            qp[i] = -1;
    }
    public boolean isEmpty() {
        return N == 0;
    }
    public int size() {
        return N;
    }
    public boolean contains(int k) {
        return qp[k] != -1;
    }
    public void show() {
        for (int i = 1; i <= N; i++) {
            System.out.printf(keys[pq[i]] + " ");
        }
        System.out.println();
    }
    public void insert(int k, Key key) {
        N++;
        qp[k] = N;
        pq[N] = k;
        keys[k] = key;
        swim(N);
    }
    public Key min() {
        return keys[pq[1]];
    }
    public int delMin() {
        int idxOfMin = pq[1];
        exch(1, N--);
        sink(1);
        keys[pq[N + 1]] = null;
        qp[pq[N + 1]] = -1;
        return idxOfMin;
    }
    public int minIndex() {
        return pq[1];
    }
    public void change(int k, Key key) {
        keys[k] = key;
        swim(qp[k]);
        sink(qp[k]);
    }
    public void delete(int k) {
        exch(k, N--);
        swim(qp[k]);
        sink(qp[k]);
        keys[pq[N + 1]] = null;
        qp[pq[N + 1]] = -1;
    }
    private boolean less(int i, int j) {
        return keys[pq[i]].compareTo(keys[pq[j]]) < 0;
    }
    private void exch(int i, int j) {
        Key t = keys[pq[i]];
        keys[pq[i]] = keys[pq[j]];
        keys[pq[j]] = t;
    }
    private void swim(int k) {
        while (k > 1 && less(k, k / 2)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }
    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j + 1, j))
                j++;
            if (less(k, j))
                break;
            exch(k, j);
            k = j;
        }
    }
}

package S2_Sorting.Others_TopK.TopK_MInPQ;

/**
 * Created by Brian Lee on 2018/8/21.
 */
public class MinPQ<Key extends Comparable<Key>> {
    private Key[] pq;   //基于堆的完全二叉树
    private int N = 0;  //存储于pq[1..N]，pq[0]不使用

    public MinPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }
    public boolean isEmpty() {
        return N == 0;
    }
    public int size() {
        return N;
    }
    public void insert(Key v) {
        pq[++N] = v;    //先将新元素添加在堆末尾
        swim(N);        //再上浮到合适位置
    }
    public Key delMin() {
        Key min = pq[1];    //从根节点得到最大元素
        exch(1, N--);       //将其和最后一个结点交换
        pq[N + 1] = null;   //防止对象游离
        sink(1);            //恢复堆的有序性
        return min;
    }
    public void show() {
        for (int i = 1; i <= N; i++) {
            System.out.printf(pq[i] + " ");
        }
        System.out.println();
    }
    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }
    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
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

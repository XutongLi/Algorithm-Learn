package S1_foundation.S1_5_Union_Find.Weighted_Quick_Union;

/**
 * Created by Brian Lee on 2018/9/7.
 */
public class WeightedQuickUnionUF {
    private int[] id;   //id[触点]=另一连通根触点（与quick_find中不同）
    private int[] sz;   //（由触点索引的）各个根结点所对应的分量大小
    private int count;  //连通分量的数量
    public WeightedQuickUnionUF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
        sz = new int[N];
        for (int i = 0; i < N; i++)
            sz[i] = 1;
    }
    public int count() {
        return count;
    }
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
    private int find(int p) {
        while (p != id[p])  p = id[p];
        return p;
    }
    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) return;
        //总是将小树连接到大树
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        }
        else {
            id[j] = i;
            sz[i] += sz[j];
        }
        count--;
    }
}

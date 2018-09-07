package S1_foundation.S1_5_Union_Find.Quick_Union;

/**
 * Created by Brian Lee on 2018/9/7.
 */
public class UF {
    private int[] id;   //分量id，以触电作为索引
    private int count;  //分量数量
    public UF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
    }
    public int count() {
        return count;
    }
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
    //返回点p的连通分量编号
    public int find(int p) {
        while (p != id[p])
            p = id[p];
        return p;
    }
    //将两个点连通在一起
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;
        id[pRoot] = qRoot;
        count--;
    }
}

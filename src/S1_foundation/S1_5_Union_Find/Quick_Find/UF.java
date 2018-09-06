package S1_foundation.S1_5_Union_Find.Quick_Find;

/**
 * Created by Brian Lee on 2018/9/6.
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
        return id[p];
    }
    //将两个点连通在一起
    public void union(int p, int q) {
        int pID = id[p];
        int qID = id[q];
        if (pID == qID) return;
        for (int i = 0; i < id.length; i++)
            //将所有id为pID的点的id都改为qID，消除一个分量
            if (id[i] == pID)   id[i] = qID;
        count--;
    }
}

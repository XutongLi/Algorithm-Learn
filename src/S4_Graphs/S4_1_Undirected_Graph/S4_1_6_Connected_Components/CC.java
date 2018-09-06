package S4_Graphs.S4_1_Undirected_Graph.S4_1_6_Connected_Components;

import S4_Graphs.S4_1_Undirected_Graph.S4_1_2_Graph.Graph;

/**
 * Created by Brian Lee on 2018/9/6.
 */
public class CC {
    private boolean[] marked;
    private int[] id;   //连通分量数组
    private int count;      //连通分量数
    public CC(Graph G) {
        marked = new boolean[G.V()];
        id = new int[G.V()];
        //以所有未标记的点为起点寻找连通分量
        for (int s = 0; s < G.V(); s++) {
            if (!marked[s]) {
                dfs(G, s);
                count++;
            }
        }
    }
    private void dfs(Graph G, int v) {
        marked[v] = true;
        id[v] = count;
        for (int w : G.adj(v))
            if (!marked[w])
                dfs(G, w);
    }
    //判断两个点是否连通
    public boolean connected(int v, int w) {
        return id[v] == id[w];
    }
    //判断点v属于哪个连通分量
    public int id(int v) {
        return id[v];
    }
    public int count() {
        return count;
    }
}

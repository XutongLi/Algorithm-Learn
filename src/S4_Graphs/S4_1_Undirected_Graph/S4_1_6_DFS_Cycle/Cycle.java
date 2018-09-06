package S4_Graphs.S4_1_Undirected_Graph.S4_1_6_DFS_Cycle;

import S4_Graphs.S4_1_Undirected_Graph.S4_1_2_Graph.Graph;

/**
 * Created by Brian Lee on 2018/9/6.
 */
public class Cycle {
    private boolean[] marked;
    private boolean hasCycle = false;
    public Cycle(Graph G) {
        marked = new boolean[G.V()];
        for (int s = 0; s < G.V(); s++) {
            if (!marked[s])
                dfs(G, s, s);
        }
    }
    private void dfs(Graph G, int v, int u) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w])
                dfs(G, w, v);
            else if (w != u)
                //相邻的已标记顶点不是上一个顶点
                //说明有环
                hasCycle = true;
        }
    }
    public boolean hasCycle() {
        return hasCycle;
    }
}

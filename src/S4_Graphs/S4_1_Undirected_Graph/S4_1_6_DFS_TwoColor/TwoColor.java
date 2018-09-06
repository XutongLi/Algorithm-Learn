package S4_Graphs.S4_1_Undirected_Graph.S4_1_6_DFS_TwoColor;

import S4_Graphs.S4_1_Undirected_Graph.S4_1_2_Graph.Graph;

/**
 * Created by Brian Lee on 2018/9/6.
 */
public class TwoColor {
    private boolean[] marked;
    private boolean[] color;
    private boolean isTwoColor = true;
    public TwoColor(Graph G) {
        marked = new boolean[G.V()];
        color = new boolean[G.V()];
        for (int s = 0; s < G.V(); s++) {
            if (!marked[s])
                dfs(G, s);
        }
    }
    private void dfs(Graph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                //相邻两顶点颜色不同
                color[w] = !color[v];
                dfs(G, w);
            }
            else if (color[w] == color[v])
                isTwoColor = false;
        }
    }
    public boolean isTwoColor() {
        return isTwoColor;
    }
}

package S4_Graphs.S4_2_Directed_Graph.S4_2_3_DiDFS;

import S4_Graphs.S4_2_Directed_Graph.S4_2_2_DiGraph.DiGraph;

/**
 * Created by Brian Lee on 2018/9/16.
 */
public class DiDFS {
    private boolean[] marked;
    public DiDFS(DiGraph G, int s) {
        marked = new boolean[G.V()];
        dfs(G, s);
    }
    public DiDFS(DiGraph G, Iterable<Integer> sources) {
        marked = new boolean[G.V()];
        for (int s : sources)
            if (!marked[s]) dfs(G, s);
    }
    private void dfs(DiGraph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v))
            if (!marked[w]) dfs(G, w);
    }
    public boolean marked(int v) {
        return marked[v];
    }
}

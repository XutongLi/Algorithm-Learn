package S4_Graphs.S4_2_Directed_Graph.S4_2_4_DiCycle;

import S4_Graphs.S4_2_Directed_Graph.S4_2_2_DiGraph.DiGraph;

import java.util.Stack;

/**
 * Created by Brian Lee on 2018/9/16.
 */
public class DiCycle {
    private boolean[] marked;
    private int[] edgeTo;
    private Stack<Integer> cycle;
    private boolean[] onStack;

    public DiCycle(DiGraph G) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        onStack = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) dfs(G, v);
        }
    }
    private void dfs(DiGraph G, int v) {
        onStack[v] = true;
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (this.hasCycle())    return;
            else if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            }
            else if (onStack[w]) {
                cycle = new Stack<>();
                for (int x = v; x != w; x = edgeTo[x])
                    cycle.push(x);
                cycle.push(w);
                cycle.push(v);
            }
        }
        onStack[v] = false;
    }
    public boolean hasCycle() {
        return cycle != null;
    }
    public Iterable<Integer> cycle() {
        return cycle;
    }
}

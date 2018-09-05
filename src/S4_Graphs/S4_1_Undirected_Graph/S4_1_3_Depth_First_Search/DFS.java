package S4_Graphs.S4_1_Undirected_Graph.S4_1_3_Depth_First_Search;

import S4_Graphs.S4_1_Undirected_Graph.S4_1_2_Graph.Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Brian Lee on 2018/9/4.
 * 某图中s可到达的顶点与路径
 */
public class DFS {
    private boolean[] marked;   //此顶点上是否调用过dfs()
    private int[] edgeTo;   //从起点到一个已知路径上最后一个顶点
    private int s;  //起点
    public DFS(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        dfs(G, s);
    }
    private void dfs(Graph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            }
        }
    }
    public boolean hasPathTo(int v) {
        return marked[v];
    }
    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v))  return null;
        Stack<Integer> pathReverse = new Stack<>();
        for (int x = v; x != s; x = edgeTo[x])
            pathReverse.push(x);
        pathReverse.push(s);
        Queue<Integer> path = new LinkedList<>();
        while (!pathReverse.isEmpty())
            path.offer(pathReverse.pop());
        return path;
    }
}

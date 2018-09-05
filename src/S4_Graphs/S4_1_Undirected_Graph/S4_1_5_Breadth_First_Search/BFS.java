package S4_Graphs.S4_1_Undirected_Graph.S4_1_5_Breadth_First_Search;

import S4_Graphs.S4_1_Undirected_Graph.S4_1_2_Graph.Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Brian Lee on 2018/9/5.
 * 找出与起点连通的所有顶点以及到各顶点的最短路径
 */
public class BFS {
    private boolean[] marked;   //到达该顶点的最短路径是否已知
    private int[] edgeTo;   //到达该顶点已知路径上最后一个顶点
    private int s;  //起点
    public BFS(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        bfs(G, s);
    }
    private void bfs(Graph G, int s) {
        Queue<Integer> queue = new LinkedList<>();
        marked[s] = true;   //标记起点
        queue.offer(s);     //起点加入队列
        while (!queue.isEmpty()) {
            int v = queue.poll();   //从队列中删去下一顶点
            for (int w : G.adj(v)) {
                if (!marked[w]) {   //对每个未被标记的相邻结点
                    edgeTo[w] = v;  //保存最短路径的最后一条边
                    marked[w] = true;   //标记它，因为最短路径已知
                    queue.offer(w); //将它添加到队列中
                }
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

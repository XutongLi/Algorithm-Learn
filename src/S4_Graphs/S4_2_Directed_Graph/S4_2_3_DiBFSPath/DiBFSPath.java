package S4_Graphs.S4_2_Directed_Graph.S4_2_3_DiBFSPath;

import S4_Graphs.S4_2_Directed_Graph.S4_2_2_DiGraph.DiGraph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Brian Lee on 2018/9/20.
 */
public class DiBFSPath {
    private final int INFINITY = Integer.MAX_VALUE;
    private boolean[] marked;
    private int [] edgeTo;
    private int[] distTo;
    private int s;

    public DiBFSPath(DiGraph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        distTo = new int[G.V()];
        this.s = s;
        for (int v = 0; v < G.V(); v++) {
            distTo[v] = INFINITY;
        }
        bfs(G, s);
    }
    private void bfs(DiGraph G, int s) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        marked[s] = true;
        distTo[s] = 0;
        while (!q.isEmpty()) {
            int v = q.poll();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    marked[w] = true;
                    distTo[w] = distTo[v] + 1;
                    edgeTo[w] = v;
                    q.offer(w);
                }
            }
        }
    }
    public boolean hasPathTo(int v) {
        return marked[v];
    }
    public int distTo(int v) {
        return distTo[v];
    }
    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v))   return null;
        Stack<Integer> stack = new Stack<>();
        for (int x = v; x != s; x = edgeTo[x]) {
            stack.push(x);
        }
        stack.push(s);
        Queue<Integer> queue = new LinkedList<>();
        while (!stack.isEmpty()) {
            queue.offer(stack.pop());
        }
        return queue;
    }
}

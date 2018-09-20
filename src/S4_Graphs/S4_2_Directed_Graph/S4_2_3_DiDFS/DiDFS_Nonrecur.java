package S4_Graphs.S4_2_Directed_Graph.S4_2_3_DiDFS;

import S4_Graphs.S4_2_Directed_Graph.S4_2_2_DiGraph.DiGraph;
import java.util.*;
/**
 * Created by Brian Lee on 2018/9/20.
 * DFS非递归
 */
public class DiDFS_Nonrecur {
    private boolean[] marked;

    public DiDFS_Nonrecur(DiGraph G, int s) {
        marked = new boolean[G.V()];
        Iterator<Integer>[] adj = (Iterator<Integer>[]) new Iterator[G.V()];
        for (int v = 0; v < G.V(); v++) {
            adj[v] = G.adj(v).iterator();
        }
        Stack<Integer> stack = new Stack<>();
        marked[s] = true;
        stack.push(s);
        while (!stack.isEmpty()) {
            int v = stack.peek();
            if (adj[v].hasNext()) {
                int w = adj[v].next();
                if (!marked[w]) {
                    marked[w] = true;
                    stack.push(w);
                }
            }
            else {
                stack.pop();
            }
        }
    }

    public DiDFS_Nonrecur(DiGraph G,Iterable<Integer> sources) {
        marked = new boolean[G.V()];
        Iterator<Integer>[] adj = (Iterator<Integer>[]) new Iterator[G.V()];
        for (int v = 0; v < G.V(); v++) {
            adj[v] = G.adj(v).iterator();
        }
        for (int s : sources) {
            Stack<Integer> stack = new Stack<>();
            marked[s] = true;
            stack.push(s);
            while (!stack.isEmpty()) {
                int v = stack.peek();
                if (adj[v].hasNext()) {
                    int w = adj[v].next();
                    if (!marked[w]) {
                        marked[w] = true;
                        stack.push(w);
                    }
                }
                else {
                    stack.pop();
                }
            }
        }
    }

    public boolean marked(int v) {
        return marked[v];
    }
}

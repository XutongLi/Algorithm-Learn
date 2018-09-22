package S4_Graphs.S4_2_Directed_Graph.S4_2_4_Topological;

import S4_Graphs.S4_2_Directed_Graph.S4_2_2_DiGraph.DiGraph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Brian Lee on 2018/9/22.
 */
public class DepthFirstOrder {
    private boolean[] marked;
    private Queue<Integer> pre; //先序
    private Queue<Integer> post;    //后序
    private Stack<Integer> reversePost; //逆后序

    public DepthFirstOrder(DiGraph G) {
        pre = new LinkedList<>();
        post = new LinkedList<>();
        reversePost = new Stack<>();
        marked = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) dfs(G, v);
        }
    }
    private void dfs(DiGraph G, int v) {
        pre.offer(v);
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w])
                dfs(G, w);
        }
        post.offer(v);
        reversePost.push(v);
    }
    public Iterable<Integer> pre() {
        return pre;
    }
    public Iterable<Integer> post() {
        return post;
    }
    public Iterable<Integer> reversePost() {
        Queue<Integer> reverse = new LinkedList<>();
        while (!reversePost.isEmpty())
            reverse.offer(reversePost.pop());
        return reverse;
    }
}

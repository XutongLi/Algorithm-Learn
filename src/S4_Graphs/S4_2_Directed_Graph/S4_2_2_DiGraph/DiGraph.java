package S4_Graphs.S4_2_Directed_Graph.S4_2_2_DiGraph;

import java.util.Scanner;

/**
 * Created by Brian Lee on 2018/9/15.
 */
public class DiGraph {
    private int V;
    private int E;
    private Bag<Integer>[] adj;

    public DiGraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++)
            adj[v] = new Bag<>();
    }
    //输入初始化构造函数
    public DiGraph() {
        Scanner in = new Scanner(System.in);
        V = in.nextInt();
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++)
            adj[v] = new Bag<Integer>();
        int e = in.nextInt();
        for (int i = 0; i < e; i++) {
            int v = in.nextInt();
            int w = in.nextInt();
            addEdge(v, w);
        }
    }
    public int V() {
        return V;
    }
    public int E() {
        return E;
    }
    public void addEdge(int v, int w) {
        adj[v].add(w);
        E++;
    }
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }
    public DiGraph reverse() {
        DiGraph R = new DiGraph(V);
        for (int v = 0; v < V; v++)
            for (int w : adj[v])
                R.addEdge(w, v);
        return R;
    }
    public String toString() {
        String s = V + " vertices, " + E + " edges\n";
        for (int v = 0; v < V; v++) {
            s += v + ": ";
            for (int w : this.adj[v])
                s += w + " ";
            s += "\n";
        }
        return s;
    }
}

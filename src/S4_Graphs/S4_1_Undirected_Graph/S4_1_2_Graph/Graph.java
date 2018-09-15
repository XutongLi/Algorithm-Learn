package S4_Graphs.S4_1_Undirected_Graph.S4_1_2_Graph;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Brian Lee on 2018/9/4.
 */
public class Graph {
    private int V;      //顶点个数(Vertices)
    private int E;      //边数(Eage)
    private Bag<Integer>[] adj;     //邻接表
    public Graph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++)
            adj[v] = new Bag<Integer>();
    }
    //输入初始化构造函数
    public Graph() {
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
    //复制别的图
    public Graph(Graph G) {
        this(G.V());
        this.E = G.E();
        for (int v = 0; v < G.V(); v++) {
            Stack<Integer> reverse = new Stack<>();
            for (int w : G.adj[v])
                reverse.push(w);
            for (int w : reverse)
                adj[v].add(w);
        }
    }
    public int V() {
        return V;
    }
    public int E() {
        return E;
    }
    //添加边
    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }
    //查找与某顶点相邻的顶点
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }
    //返回某顶点的度
    public int degree(int v) {
        return adj[v].size();
    }
    //计算最大度
    public int maxDegree() {
        int max = 0;
        for (int v = 0; v < V; v++)
            max = Math.max(adj[v].size(), max);
        return max;
    }
    //计算平均度
    public int avgDegree() {
        return 2 * E / V;
    }
    //计算自环数量
    public int numOfSelfLoops() {
        int count = 0;
        for (int v = 0; v < V; v++) {
            for (int w : adj[v])
                if (v == w) count++;
        }
        return count;
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

package S4_Graphs.S4_2_Directed_Graph.S4_2_4_Topological;

import S4_Graphs.S4_2_Directed_Graph.S4_2_2_DiGraph.DiGraph;
import S4_Graphs.S4_2_Directed_Graph.S4_2_4_DiCycle.DiCycle;

/**
 * Created by Brian Lee on 2018/9/22.
 */
public class Topological {
    private Iterable<Integer> order;
    private int[] rank;
    public Topological(DiGraph G) {
        DiCycle cycleFinder = new DiCycle(G);
        if (!cycleFinder.hasCycle()) {
            DepthFirstOrder dfs = new DepthFirstOrder(G);
            order = dfs.reversePost();
            rank = new int[G.V()];
            int i = 0;
            for (int v : order)
                rank[v] = i++;
        }
    }
    public Iterable<Integer> order() {
        return order;
    }
    //是否有拓扑排序
    public boolean isDAG() {
        return order == null;
    }
    public int rank(int i) {
        if (isDAG())
            return rank[i];
        return -1;
    }
}

package S4_Graphs.S4_1_Undirected_Graph.S4_1_6_DFS_Cycle;

import S4_Graphs.S4_1_Undirected_Graph.S4_1_2_Graph.Graph;

/**
 * Created by Brian Lee on 2018/9/6.
 */
public class CycleTest {
    public static void main(String[] args) {
        Graph G = new Graph();
        System.out.println(new Cycle(G).hasCycle());
    }
}

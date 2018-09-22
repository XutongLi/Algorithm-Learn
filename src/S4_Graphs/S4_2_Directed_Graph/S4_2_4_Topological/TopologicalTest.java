package S4_Graphs.S4_2_Directed_Graph.S4_2_4_Topological;

import S4_Graphs.S4_2_Directed_Graph.S4_2_2_DiGraph.DiGraph;

import java.util.Scanner;

/**
 * Created by Brian Lee on 2018/9/22.
 13 15
 0 1
 0 5
 0 6
 2 0
 2 3
 3 5
 5 4
 6 4
 6 9
 7 6
 8 7
 9 10
 9 11
 9 12
 11 12
 */
public class TopologicalTest {
    public static void main(String[] args) {
        DiGraph G = new DiGraph();
        Topological to = new Topological(G);
        for (int v : to.order()) {
            System.out.print(v + " ");
        }
    }
}

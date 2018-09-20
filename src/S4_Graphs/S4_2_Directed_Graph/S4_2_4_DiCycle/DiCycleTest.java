package S4_Graphs.S4_2_Directed_Graph.S4_2_4_DiCycle;

import S4_Graphs.S4_2_Directed_Graph.S4_2_2_DiGraph.DiGraph;

import java.util.Scanner;

/**
 * Created by Brian Lee on 2018/9/20.
 */
public class DiCycleTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        DiGraph G = new DiGraph();
        DiCycle test = new DiCycle(G);
        if (test.hasCycle()) {
            System.out.println("has cycle");
        }
        else {
            System.out.println("does not has");
        }
    }
}

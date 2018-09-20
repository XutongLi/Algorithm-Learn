package S4_Graphs.S4_2_Directed_Graph.S4_2_4_DiCycle;

import S4_Graphs.S4_2_Directed_Graph.S4_2_2_DiGraph.DiGraph;

import java.util.Scanner;

/**
 * Created by Brian Lee on 2018/9/20.
 4 4
 0 1
 1 2
 2 3
 3 1
 */
public class DiCycleTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        DiGraph G = new DiGraph();
        DiCycle test = new DiCycle(G);
        if (test.hasCycle()) {
            System.out.println("has cycle");
            for (int v : test.cycle()) {
                System.out.print(v + " ");
            }
        }
        else {
            System.out.println("does not has");
        }
    }
}

package S4_Graphs.S4_1_Undirected_Graph.S4_1_3_Depth_First_Search;

import S4_Graphs.S4_1_Undirected_Graph.S4_1_2_Graph.Graph;

import java.util.Scanner;

/**
 * Created by Brian Lee on 2018/9/5.
 6
 8
 0 1
 0 5
 0 2
 1 2
 2 3
 3 5
 3 4
 2 4
 0
 */
public class DFSTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Graph G = new Graph();
        int s = in.nextInt();
        DFS search = new DFS(G, s);
        for (int v = 0; v < G.V(); v++) {
            System.out.print(s + " to " + v + ": ");
            if (search.hasPathTo(v)) {
                for (int x : search.pathTo(v)) {
                    if (x == s) System.out.print(x);
                    else System.out.print("-" + x);
                }
            }
            System.out.println();
        }
    }
}

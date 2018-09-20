package S4_Graphs.S4_2_Directed_Graph.S4_2_3_DiDFSPath;

import S4_Graphs.S4_2_Directed_Graph.S4_2_2_DiGraph.DiGraph;

import java.util.Scanner;

/**
 * Created by Brian Lee on 2018/9/16.
 13 22
 4 2
 2 3
 3 2
 6 0
 0 1
 2 0
 11 12
 12 9
 9 10
 9 11
 8 9
 10 12
 11 4
 4 3
 3 5
 7 8
 8 7
 5 4
 0 5
 6 4
 6 9
 7 6
 */
public class DiDFSPathTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        DiGraph G = new DiGraph();
        int s = in.nextInt();
        DiDFSPath path = new DiDFSPath(G, s);
        for (int v = 0; v < G.V(); v++) {
            System.out.print(s + " to " + v + ": ");
            if (path.hasPathTo(v)) {
                for (int x : path.pathTo(v)) {
                    if (x == s) System.out.print(x);
                    else System.out.print("-" + x);
                }
            }
            System.out.println();
        }
    }
}

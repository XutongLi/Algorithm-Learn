package S4_Graphs.S4_2_Directed_Graph.S4_2_3_DiDFS;

import S4_Graphs.S4_2_Directed_Graph.S4_2_2_DiGraph.DiGraph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by Brian Lee on 2018/9/16.
 */
public class DiDFSTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        DiGraph G = new DiGraph();
        Queue<Integer> queue = new LinkedList<>();
        int n = in.nextInt();
        for (int i = 0; i < n; i++)
            queue.offer(in.nextInt());
        DiDFS reachable = new DiDFS(G, queue);
        for (int v = 0; v < G.V(); v++)
            if (reachable.marked(v))
                System.out.print(v + " ");
    }
}

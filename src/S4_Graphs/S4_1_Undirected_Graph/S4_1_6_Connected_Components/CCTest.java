package S4_Graphs.S4_1_Undirected_Graph.S4_1_6_Connected_Components;

import S4_Graphs.S4_1_Undirected_Graph.S4_1_2_Graph.Bag;
import S4_Graphs.S4_1_Undirected_Graph.S4_1_2_Graph.Graph;

/**
 * Created by Brian Lee on 2018/9/6.
 13 13
 0 6
 0 2
 0 1
 0 5
 3 5
 3 4
 4 5
 4 6
 7 8
 9 11
 9 10
 9 12
 11 12
 */
public class CCTest {
    public static void main(String[] args) {
        Graph G = new Graph();
        CC cc = new CC(G);

        int M = cc.count();
        System.out.println(M + " components");

        Bag<Integer>[] components = new Bag[M];
        for (int i = 0; i < M; i++) {
            components[i] = new Bag<>();
        }
        //背包数组中每一个背包为一个连通分量，连通分量中顶点无顺序
        for (int v = 0; v < G.V(); v++) {
            components[cc.id(v)].add(v);
        }
        for (int i = 0; i < M; i++) {
            for (int v : components[i])
                System.out.print(v + " ");
            System.out.println();
        }
    }
}

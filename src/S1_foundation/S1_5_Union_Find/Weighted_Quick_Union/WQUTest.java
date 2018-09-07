package S1_foundation.S1_5_Union_Find.Weighted_Quick_Union;


import java.util.Scanner;

/**
 * Created by Brian Lee on 2018/9/6.
 10
 4 3
 3 8
 6 5
 9 4
 2 1
 5 0
 7 2
 6 1
 -1 -1
 */
public class WQUTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);
        int p = in.nextInt();
        int q = in.nextInt();
        while (p != -1) {
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            p = in.nextInt();
            q = in.nextInt();
        }
        System.out.println(uf.count() + " components");
    }
}

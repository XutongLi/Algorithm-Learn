package S2_Sorting.S2_4_4_6_IndexMinPQ;

import java.util.Scanner;

/**
 * Created by Brian Lee on 2018/8/20.

 */
public class IndexMinPQTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input M");
        int M = in.nextInt();
        IndexMinPQ<Integer> pq = new IndexMinPQ<>(M);
        for (int i = 1; i <= M; i++) {
            Integer num = in.nextInt();
             pq.insert(i, num);
        }
        pq.show();
        pq.delMin();
        pq.show();
        pq.delete(3);
        pq.show();
        System.out.println(pq.contains(2));
    }
}

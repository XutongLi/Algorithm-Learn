package S2_Sorting.Others_TopK.TopK_MInPQ;

import java.util.Scanner;

/**
 * Created by Brian Lee on 2018/8/21.
 */
public class TopK_MinPQ {
    public static String select(String[] a, int k) {
        MinPQ<String> pq = new MinPQ<>(k + 1);  //多一个用于重排和删除
        for (int i = 0; i < a.length; i++) {
            pq.insert(a[i]);
            if (pq.size() > k)
                pq.delMin();
        }
        return pq.delMin();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] a = str.split(" ");
        int k = in.nextInt();
        System.out.println(select(a, k));
    }
}

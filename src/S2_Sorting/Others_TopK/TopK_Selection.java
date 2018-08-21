package S2_Sorting.Others_TopK;

import java.util.Scanner;

/**
 * Created by Brian Lee on 2018/8/21.
 */
public class TopK_Selection {
    public static Comparable select(Comparable[] a, int k) {
        int N = a.length;
        for (int i = 0; i < k; i++) {
            int max = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[max], a[j]))
                    max = j;
            }
            exch(a, max, i);
        }
        return a[k - 1];
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] a = str.split(" ");
        int k = in.nextInt();
        System.out.println(select(a, k));
    }
}

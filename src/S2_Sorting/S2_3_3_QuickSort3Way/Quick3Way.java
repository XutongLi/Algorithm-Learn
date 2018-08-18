package S2_Sorting.S2_3_3_QuickSort3Way;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by Brian Lee on 2018/8/18.
 */
public class Quick3Way {
    public static void sort(Comparable[] a) {
        shuffle(a);     //消除对输入依赖
        sort(a, 0, a.length - 1);
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo)
            return;
        int lt = lo, i = lo + 1, gt = hi;
        Comparable v = a[lo];
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0)
                exch(a, lt++, i++);
            else if (cmp == 0)
                i++;
            else
                exch(a, i, gt--);
        }
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.printf(a[i] + " ");
        }
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1]))
                return false;
        }
        return true;
    }

    //生成[0,N-1]随机数
    public static int uniform(int N) {
        Random rand = new Random();
        return (rand.nextInt(N));
    }

    //将数组元素打乱
    public static void shuffle(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int r = i + uniform(N - i);
            exch(a, i, r);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] a = str.split(" ");
        sort(a);
        assert isSorted(a);
        show(a);
    }
}

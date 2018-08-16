package S2_Sorting.S2_2_3_MergeBU;

import java.util.Scanner;

/**
 * Created by Brian Lee on 2018/8/16.
 */
public class MergeBU {
    private static Comparable[] aux;    //辅助数组

    public static void sort(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[N];
        for (int sz = 1; sz < N; sz += sz) {
            for (int lo = 0; lo < N; lo += 2 * sz) {
                merge(a, lo, lo + sz - 1, Math.min(lo + 2 * sz - 1, N - 1));
            }
        }
    }

    //将a[lo..mid]与a[mid+1..hi]归并
    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        //将a[lo..hi]复制到aux[lo..hi]
        for (int k = lo; k <= hi; k++)
            aux[k] = a[k];
        for (int k = lo; k <= hi; k++) {
            if (i > mid)    //左半边用尽
                a[k] = aux[j++];
            else if (j > hi)    //右半边用尽
                a[k] = aux[i++];
            else if (less(aux[j], aux[i]))  //右半边元素小于左半边
                a[k] = aux[j++];
            else    //左半边元素小于右半边
                a[k] = aux[i++];
        }
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

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] a = str.split(" ");
        sort(a);
        assert isSorted(a);
        show(a);
    }
}

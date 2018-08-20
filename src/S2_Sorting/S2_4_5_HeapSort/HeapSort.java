package S2_Sorting.S2_4_5_HeapSort;

import java.util.Scanner;

/**
 * Created by Brian Lee on 2018/8/20.
 */
public class HeapSort {
    public static void sort(Comparable[] a) {
        int N = a.length - 1;
        //构造堆
        for (int k = N / 2; k >= 1; k--)
            sink(a, k, N);
        //下沉排序
        while (N > 1) {
            exch(a, 1, N--);
            sink(a, 1, N);
        }
    }
    private static void sink(Comparable[] a, int k, int N) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(a, j, j + 1))
                j++;
            if (!less(a, k, j))
                break;
            exch(a, k, j);
            k = j;
        }
    }
    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    private static boolean less(Comparable[] a, int i, int j) {
        return a[i].compareTo(a[j]) < 0;
    }
    private static void show(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            System.out.printf(a[i] + " ");
        }
    }
    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a, i, i - 1))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input amount of number");
        Integer n = in.nextInt();
        Integer a[] = new Integer[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = in.nextInt();
        }
        sort(a);
        assert isSorted(a);
        show(a);
    }
}

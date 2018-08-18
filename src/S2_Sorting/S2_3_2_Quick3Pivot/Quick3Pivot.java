package S2_Sorting.S2_3_2_Quick3Pivot;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by Brian Lee on 2018/8/18.
 */
public class Quick3Pivot {
    public static void sort(Comparable[] a) {
        shuffle(a);     //消除对输入依赖
        sort(a, 0, a.length - 1);
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi)
            return;
        int n = hi - lo + 1;
        int m = mid3Pivot(a, lo, lo + n / 2, hi);
        exch(a, m ,lo);
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    // return the index of the median element among a[i], a[j], and a[k]
    private static int mid3Pivot(Comparable[] a, int i, int j, int k) {
        if (less(a[i], a[j])) {
            if (less(a[j], a[k]))  //ai<aj<ak
                return j;
            else if (less(a[i], a[k])) //ai<ak<aj
                return k;
            else  //ak<ai<aj
                return i;
        }
        else {
            if (less(a[k], a[j]))   //ak<aj<ai
                return j;
            else if (less(a[k], a[i]))  //aj<ak<ai
                return k;
            else    //aj<ai<ak
                return i;
        }
    }

    public static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        Comparable v = a[lo];  //pivot
        while (true) {
            while (less(a[++i], v)){
                if (i == hi)
                    break;
            }
            while (less(v, a[--j])) {
                if (j == lo)
                    break;
            }
            if (i >= j)
                break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
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

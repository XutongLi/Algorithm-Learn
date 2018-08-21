package S2_Sorting.Others_TopK;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by Brian Lee on 2018/8/21.
 * 找出一组长度为N元素中第K大的
 * 二分法
 * O(N)
 */
public class TopK_Binary {
    public static Comparable select(Comparable[] a, int k) {
        shuffle(a);
        int lo = 0, hi = a.length - 1;
        while (hi > lo) {
            int j = partition(a, lo, hi);
            if (j == k)
                return a[k];
            else if (j > k)
                hi = j - 1;
            else
                lo = j + 1;
        }
        return a[k];
    }

    public static int partition(Comparable[] a, int lo, int hi) {
    int i = lo, j = hi + 1;
    Comparable v = a[lo];  //pivot
    while (true) {
        while (less(v, a[++i])){
            if (i == hi)
                break;
        }
        while (less(a[--j], v)) {
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
        int k = in.nextInt();
        System.out.println(select(a, k - 1));
    }
}

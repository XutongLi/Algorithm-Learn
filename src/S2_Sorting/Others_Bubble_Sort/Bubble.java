package S2_Sorting.Others_Bubble_Sort;
import java.util.Scanner;

/**
 * Created by Brian Lee on 2018/8/14.
 */
public class Bubble {
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = 1; j < N - i; j++) {
                if (less(a[j], a[j - 1]))
                    exch(a, j, j - 1);
            }
        }
    }

    public static void sort2(Comparable[] a) {
        int N = a.length;
        boolean isExch = true;
        for (int i = 0; i < N && isExch; i++) {
            isExch = false;
            for (int j = 1; j < N - i; j++) {
                if (less(a[j], a[j - 1])) {
                    exch(a, j, j - 1);
                    isExch = true;
                }
            }
        }
    }

    public static void sort3(Comparable[] a) {
        int N = a.length;
        boolean isExch = true;
        int tail = N, temp = N;
        for (int i = 0; i < N && isExch; i++) {
            isExch = false;
            for (int j = 1; j < tail; j++) {
                if (less(a[j], a[j - 1])) {
                    exch(a, j, j - 1);
                    isExch = true;
                    temp = j;
                }
            }
            tail = temp;
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
//        sort(a);
//        sort2(a);
        sort3(a);
        assert isSorted(a);
        show(a);
    }
}

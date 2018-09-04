package S3_Searching.S3_5_SparseVector;

import java.util.Scanner;

/**
 * Created by Brian Lee on 2018/9/4.
 */
public class SparseVectorTest {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
        int M = 3;   //row
        int N = 4;   //col
        SparseVector[] a = new SparseVector[M];
        for (int i = 0; i < M; i++) {
            a[i] = new SparseVector();
        }
        double[] x = new double[]{1.0, 2.0, 3.0, 4.0};
        double[] b = new double[M];
        a[0].put(0, 2.0);
        a[0].put(2, 3.0);
        a[0].put(3, 1.0);
        a[1].put(1, 5.0);
        a[2].put(0,1.5);
        a[2].put(3, 2.0);
        for (int i = 0; i < M; i++) {
            b[i] = a[i].dot(x);
            System.out.println(b[i]);
        };

    }
}

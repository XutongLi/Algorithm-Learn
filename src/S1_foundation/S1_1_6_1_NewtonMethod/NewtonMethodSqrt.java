package S1_foundation.S1_1_6_1_NewtonMethod;

import java.util.Scanner;

/**
 * Created by Brian Lee on 2018/7/21.
 */
public class NewtonMethodSqrt {
    public static double sqr(double c) {
        if (c < 0) {
            return Double.NaN;
        }
        double err = 1e-15;
        double x = c;
        while (Math.abs(x - c / x) > err * x) {
            x = (c / x + x) / 2.0;
        }
        return x;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int c = in.nextInt();
        System.out.println(sqr(c));
    }
}

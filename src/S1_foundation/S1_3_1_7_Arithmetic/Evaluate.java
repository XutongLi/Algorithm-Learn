package S1_foundation.S1_3_1_7_Arithmetic;


import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Brian Lee on 2018/7/29.
 */
public class Evaluate {
    public static void main(String[] args) {
        Stack<String> ops = new Stack<String>();
        Stack<Double> vals = new Stack<Double>();
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String strArray[] = str.split(" ");
        for (int i = 0; i < strArray.length; i++) {
            String s = strArray[i];
            if (s.equals("("));
            else if (s.equals("+"))     ops.push(s);
            else if (s.equals("-"))     ops.push(s);
            else if (s.equals("*"))     ops.push(s);
            else if (s.equals("/"))     ops.push(s);
            else if (s.equals("sqrt"))     ops.push(s);
            else if (s.equals(")")) {
                String op = ops.pop();
                double v = vals.pop();
                if (op.equals("+"))     v = vals.pop() + v;
                else if (op.equals("-"))     v = vals.pop() - v;
                if (op.equals("*"))     v = vals.pop() * v;
                if (op.equals("/"))     v = vals.pop() / v;
                if (op.equals("sqrt"))     v = Math.sqrt(v);
                vals.push(v);
            }
            else vals.push(Double.parseDouble(s));
        }
        System.out.println(vals.pop());
    }
}

package S1_Foundation.S1_3_BagQueueStack.S1_3_1_7_Arithmetic;


import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Brian Lee on 2018/7/29.
 * 1.将操作数压如操作数栈
 * 2.将运算符压入运算符栈
 * 3.忽略左括号
 * 4.遇到右括号时，弹出一个运算符，弹出所需数量的操作数，并将运算符和操作数的运算结果压入操作数栈
 */
public class Evaluate {
    public static void main(String[] args) {
        Stack<String> ops = new Stack<String>();    //运算符栈
        Stack<Double> vals = new Stack<Double>();   //操作数栈
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
                else if (op.equals("*"))     v = vals.pop() * v;
                else if (op.equals("/"))     v = vals.pop() / v;
                else if (op.equals("sqrt"))     v = Math.sqrt(v);
                vals.push(v);
            }
            else vals.push(Double.parseDouble(s));
        }
        System.out.println(vals.pop());
    }
}

package S1_foundation.S1_3_BagQueueStack.S1_3_2_1_FixedCapacityStack;

import java.util.Scanner;

/**
 * Created by Brian Lee on 2018/7/30.
 */
public class FixedCapacityStringTest {
    public static void main(String[] args) {
        FixedCapacityStackOfStrings s = new FixedCapacityStackOfStrings(100);
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String strArray[] = str.split(" ");
        for (int i = 0; i < strArray.length; i++) {
            String ch = strArray[i];
            if (!ch.equals("-")) {
                s.push(ch);
            }
            else if (!s.isEmpty()) {
                System.out.printf(s.pop() + " ");
            }
        }
        System.out.println("\n" + s.size() + " left on stack");
    }
}

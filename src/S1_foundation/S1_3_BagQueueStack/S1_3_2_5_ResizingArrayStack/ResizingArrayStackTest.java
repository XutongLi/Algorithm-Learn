package S1_foundation.S1_3_BagQueueStack.S1_3_2_5_ResizingArrayStack;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by Brian Lee on 2018/7/30.
 */
public class ResizingArrayStackTest {
    public static void main(String[] args) {
        ResizingArrayStack<String> s = new ResizingArrayStack<>();
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
        Iterator<String> i = s.iterator();
        while (i.hasNext())
            System.out.println(i.next());

        for (String st : s)
            System.out.println(st);
    }
}

package S1_foundation.S1_3_BagQueueStack.S1_3_3_10_Bag;

import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by Brian Lee on 2018/7/30.
 */
public class BagTest {
    public static void main(String[] args) {
        Bag<String> s = new Bag<>();
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String strArray[] = str.split(" ");
        for (int i = 0; i < strArray.length; i++) {
            String ch = strArray[i];
            s.add(ch);
        }
        Iterator<String> i = s.iterator();
        while (i.hasNext())
            System.out.println(i.next());

        for (String st : s)
            System.out.println(st);
    }
}

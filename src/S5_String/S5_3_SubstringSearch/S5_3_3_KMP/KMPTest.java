package S5_String.S5_3_SubstringSearch.S5_3_3_KMP;

import java.util.Scanner;

/**
 * Created by Brian Lee on 2018/3/13.
 */
public class KMPTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Please input text:");
        String txt = in.nextLine();
        System.out.println("Please input pattern:");
        String pat = in.nextLine();
        KMP kmp = new KMP(txt, pat);
        int index = kmp.search();
        if( index == txt.length()) {    //不存在此模式字符串
            System.out.println("This pattern is not included in this text");
        }
        else {
            System.out.println("This pattern is included in this text, the first index is " + index);
        }
    }
}

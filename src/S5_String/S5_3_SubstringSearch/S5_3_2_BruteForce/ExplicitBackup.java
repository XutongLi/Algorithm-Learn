package S5_String.S5_3_SubstringSearch.S5_3_2_BruteForce;

import java.util.Scanner;

/**
 * Created by Brian Lee on 2018/3/13.
 * 暴力法求解字符串查找问题（显示回退）
 */
public class ExplicitBackup {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Please input text:");
        String txt = in.nextLine();
        System.out.println("Please input pattern:");
        String pat = in.nextLine();
        int index = search(pat, txt);
        if( index == txt.length()) {    //不存在此模式字符串
            System.out.println("This pattern is not included in this text");
        }
        else {
            System.out.println("This pattern is included in this text, the first index is " + index);
        }
    }

    public static int search(String pat, String txt) {
        int i, j; //此段代码中的i相当于BruteForce.java中的i+j
        int N = txt.length();
        int M = pat.length();
        for (i = 0, j = 0; i < N && j < M; i++) {
            if (txt.charAt(i) == pat.charAt(j)) {
                j++;
            }
            else {
                i -= j;
                j = 0;
            }
        }
        if (j == M) {
            return i - M;
        }
        else {
            return N;
        }
    }
}

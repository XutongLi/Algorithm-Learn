package S5_String.S5_3_SubstringSearch.S5_3_2_BruteForce;

import java.util.Scanner;

/**
 * Created by Brian Lee on 2018/3/13.
 * 暴力求解字符串查找问题
 */
public class BruteForce {
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

    public static int search (String pat, String txt) {
        int N = txt.length();   //N为文本长度
        int M = pat.length();   //M为字符串长度

        for (int i = 0; i < N - M; i++) {
            int j;
            for (j = 0; j <= M - 1; j++) {
                if (txt.charAt(i + j) != pat.charAt(j)) {   //匹配到不相等的字符串时跳出循环
                    break;
                }
            }
            if (j == M) {   //此时说明匹配成功，返回文本中的索引值，即匹配到的位置
                return i;
            }
        }
        return N;   //匹配不成功，返回文本大小值
    }
}


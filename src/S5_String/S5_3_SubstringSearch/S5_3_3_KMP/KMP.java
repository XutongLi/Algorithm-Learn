package S5_String.S5_3_SubstringSearch.S5_3_3_KMP;

import java.util.Scanner;

/**
 * Created by Brian Lee on 2018/3/13.
 */
public class KMP {
    private String txt;
    private String pat;
    private int[][] DFA;    //DFA第一维为文本字符，第二维为模式字符串索引

    public KMP(String txt, String pat) {
        this.txt = txt;
        this.pat = pat;
        DFA = new int[256][pat.length()];
    }

    //获取DFA二维数组
    public void getDFA() {
        DFA[pat.charAt(0)][0] = 1;
        for (int state = 0, j = 1; j < pat.length(); j++) {
            for (int c = 0; c < 256; c++) {
                DFA[c][j] = DFA[c][state];  //复制状态
            }
            DFA[pat.charAt(j)][j] = j + 1;  //匹配时模式字符串匹配下一位
            state = DFA[pat.charAt(j)][state];  //计算重启状态
        }
    }

    //搜索
    public int search() {
        int i, j;
        int M = pat.length();
        int N = txt.length();
        getDFA();
        for (i = 0, j = 0; i < N && j < M; i++) {
            j = DFA[txt.charAt(i)][j];
        }
        if (j == M) {
            return i - M;
        }
        else {
            return N;
        }
    }
}

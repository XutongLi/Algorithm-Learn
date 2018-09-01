package S3_Searching.S3_2_Bianry_Search_Trees;

import java.util.*;

/**
 * Created by Brian Lee on 2018/8/31.
 */
public class BSTTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BST<Integer, String> st = new BST<>();
        String str = in.nextLine();
        String[] s = str.split(" ");
        for (int i = 0; i < s.length; i++) {
            st.put(i, s[i]);
        }
        System.out.println(st.get(2));
        st.delete(3);
        System.out.println(st.keys());
        System.out.println(st.floor(3));
        System.out.println(st.ceiling(3));
        st.print();
        System.out.println(st.keys(2,5));
        System.out.println(st.get(5));
        System.out.println(st.get2(5));
        st.put2(100, "LXT");
        st.put2(3, "Brian");
        st.put2(10, "BR");
        st.put2(15, "aaa15");
        System.out.println(st.size());
        st.print();
        System.out.println();
        for (Integer k : st.keys()) {
            System.out.print(st.get2(k));
            System.out.print(" ");
        }
        System.out.println(st.size(10, 15));
        System.out.println(st.height());
        System.out.println(st.levelOrderKeys());
        System.out.println(st.isBST());
        System.out.println(st.isSizeCorrect());
        System.out.println(st.isRankConsistent());
    }
}

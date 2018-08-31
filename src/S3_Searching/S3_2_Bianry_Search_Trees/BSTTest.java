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
    }
}

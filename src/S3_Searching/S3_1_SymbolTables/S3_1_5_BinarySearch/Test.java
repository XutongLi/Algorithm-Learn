package S3_Searching.S3_1_SymbolTables.S3_1_5_BinarySearch;

import java.util.Scanner;

/**
 * Created by Brian Lee on 2018/8/26.
 */
public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BinarySearchST<Integer, String> st = new BinarySearchST<>(100);
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
    }
}

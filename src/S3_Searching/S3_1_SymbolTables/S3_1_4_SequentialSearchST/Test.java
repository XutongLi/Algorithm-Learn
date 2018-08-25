package S3_Searching.S3_1_SymbolTables.S3_1_4_SequentialSearchST;

import java.util.Scanner;

/**
 * Created by Brian Lee on 2018/8/25.
 */
public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        SequentialSearchST<Integer, String> st = new SequentialSearchST<>();
        String str = in.nextLine();
        String[] s = str.split(" ");
        for (int i = 0; i < s.length; i++) {
            st.put(i, s[i]);
        }
        System.out.println(st.values());
        System.out.println(st.get(1));
        System.out.println(st.delete(2));
        st.put(3, "LXT");
        System.out.println(st.keys());
        System.out.println(st.values());
        System.out.println(st.size());
    }
}

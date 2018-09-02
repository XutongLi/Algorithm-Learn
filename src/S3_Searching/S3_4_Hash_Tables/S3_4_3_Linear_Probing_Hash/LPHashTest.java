package S3_Searching.S3_4_Hash_Tables.S3_4_3_Linear_Probing_Hash;

import java.util.Scanner;

/**
 * Created by Brian Lee on 2018/9/2.
 */
public class LPHashTest {
    public static void main(String[] args) {
        LinearProbingHashST<Integer, String> st = new LinearProbingHashST<>(3);
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        for (int i = 0; i < N; i++) {
            int num = in.nextInt();
            in.nextLine();
            String str = in.nextLine();
            st.put(num, str);
        }
        System.out.println(st.get(5));
        System.out.println(st.keys());
        st.delete(5);
        st.put(10, "qwer");
        System.out.println(st.keys());
        System.out.println(st.get(10));
    }
}

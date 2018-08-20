package S2_Sorting.S2_4_4_2_MaxPriorityQueue;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Brian Lee on 2018/8/20.
 * 一个优先队列的用例
 * 找出N个数字中最小的M个
 */
public class BottomM {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Find the smallest M numbers in N numbers");
        System.out.println("Input M");
        int M = in.nextInt();
        System.out.println("Input N");
        int N = in.nextInt();
        MaxPQ<Integer> pq = new MaxPQ<Integer>(M + 1);  //多一个用于重排和删除
        for (int i = 0; i < N; i++) {
            Integer num = in.nextInt();
            pq.insert(num);
            //pq.show();
            if (pq.size() > M)
                pq.delMax();
        }
        Stack<Integer> stack = new Stack<Integer>();
        while (!pq.isEmpty())
//            System.out.println(pq.delMax());
            stack.push(pq.delMax());    //从大到小入栈
        for (int i = 0; i < M; i++) {
            System.out.println(stack.pop());    //从小到大出栈
        }
    }
}

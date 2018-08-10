package S1_Foundation.S1_3_BagQueueStack.S1_3_2_1_FixedCapacityStackOfString;

/**
 * Created by Brian Lee on 2018/7/30.
 */
public class FixedCapacityStackOfStrings {
    private String a[];
    private int N;
    public FixedCapacityStackOfStrings(int cap) {
        a = new String[cap];
    }
    public void push(String item) {
        a[N++] = item;
    }
    public String pop() {
        return a[--N];
    }
    public boolean isEmpty() {
        return N == 0;
    }
    public int size() {
        return N;
    }

}

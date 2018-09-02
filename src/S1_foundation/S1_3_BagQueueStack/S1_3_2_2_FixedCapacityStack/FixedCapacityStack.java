package S1_foundation.S1_3_BagQueueStack.S1_3_2_2_FixedCapacityStack;

/**
 * Created by Brian Lee on 2018/7/30.
 * Item是一个类型参数，用于表示用例将会使用的某种具体类型的象征性的占位符
 * 创建泛型数组在JAVA中是不允许的（a = new Item[cap]）
 */
public class FixedCapacityStack<Item> {
    private Item[] a;
    private int N;
    public FixedCapacityStack (int cap) {
        a = (Item[]) new Object[cap];
    }
    public boolean isEmpty() {
        return N == 0;
    }
    public int size() {
        return N;
    }
    public void push(Item item) {
        a[N++] = item;
    }
    public Item pop() {
        return a[--N];
    }
}

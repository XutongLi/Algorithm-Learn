package S3_Searching.S3_2_Bianry_Search_Trees;

/**
 * Created by Brian Lee on 2018/8/28.
 */
public class BST <Key extends Comparable<Key>, Value> {
    private Node root;  //二叉查找树根结点
    private class Node {
        private Key key;    //键
        private Value val;  //值
        private Node left, right;   //指向左右子树的链接
        private int N;  //以该结点为根的子树中的结点总数
        public Node (Key key, Value val, int N) {
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }
    public boolean isEmpty() {
        return size() == 0;
    }
    public boolean contains(Key key) {
        return get(key) != null;
    }
    //获取二叉查找树大小
    public int size() {
        return size(root);
    }
    private int size(Node x) {
        if (x == null)
            return 0;
        else
            return x.N;
    }
    //查找
    public Value get(Key key) {
        return get(root, key);
    }
    //在以x为根结点的子树中查找并返回key对应的值
    //如果找不到则返回null
    private Value get(Node x, Key key) {
        if (x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            return get(x.left, key);
        else if (cmp > 0)
            return get(x.right, key);
        else
            return x.val;
    }
    //插入
    public void put(Key key, Value val) {
        root = put(root, key, val);
    }
    //如果key存在于以x为结点的子树中则更新它的值
    //否则将以key和val为键值对的新结点插入到该子树中
    private Node put(Node x, Key key, Value val) {
        if (x == null)
            return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            x.left = put(x.left, key, val);
        else if (cmp > 0)
            x.right = put(x.right, key, val);
        else
            x.val = val;
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }
}

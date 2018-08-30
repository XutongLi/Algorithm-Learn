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
    //找最小的键
    public Key min() {
        return min(root).key;
    }
    private Node min(Node x) {
        if (x.left == null)     return x;
        return min(x.left);
    }
    //找最大的键
    public Key max() {
        return max(root).key;
    }
    private Node max(Node x) {
        if (x.right == null)    return x;
        return max(x.right);
    }
    //向下取整
    public Key floor(Key key) {
        Node x = floor(root, key);
        if (x == null)  return null;
        return x.key;
    }
    private Node floor(Node x, Key key) {
        if (x == null)  return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0)   return x;
        else if (cmp < 0)    return floor(x.left, key);
        Node t = floor(x.right, key);
        if (t != null)  return t;
        else    return x;
    }
    //向上取整
    public Key ceiling(Key key) {
        Node x = ceiling(root, key);
        if (x == null)  return null;
        return x.key;
    }
    private Node ceiling(Node x, Key key) {
        if (x == null)  return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0)   return x;
        else if (cmp < 0) {
            Node t = ceiling(x.left, key);
            if (t != null)  return t;
            else    return x;
        }
        return ceiling(x.right, key);
    }
    //选择
    public Key select(int k) {
        return select(root, k).key;
    }
    private Node select(Node x, int k) {
        if (x == null)  return null;
        int t = size(x.left);
        if (t > k)  return select(x.left, k);
        else if (t < k) return select(x.right, k - t - 1);  //减去左子树结点数和父结点
        else    return x;
    }
    //排名
    public int rank(Key key) {
        return rank(root, key);
    }
    private int rank(Node x, Key key) {
        if (x == null)  return 0;
        int cmp = key.compareTo(x.key);
        if (cmp < 0)    return rank(x.left, key);
        else if (cmp > 0)   return 1 + size(x.left) + rank(x.right, key);
        else    return size(x.left);
    }
    //删除最小键结点
    public void deleteMin() {
        root = deleteMin(root);
    }
    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }
    //删除最大键结点
    public void deleteMax() {
        root = deleteMax(root);
    }
    private Node deleteMax(Node x) {
        if (x.right == null)    return x.left;
        x.right = deleteMin(x.right);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }
    //删除
    public void delete(Key key) {
        root = delete(root, key);
    }
    private Node delete(Node x, Key key) {
        if (x == null)  return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0)    x.left = delete(x.left, key);
        else if (cmp > 0)   x.right = delete(x.right, key);
        else {
            if (x.right == null)    return x.left;
            if (x.left == null)     return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }
}



package S3_Searching.S3_2_Bianry_Search_Trees;

import java.util.Queue;
import java.util.LinkedList;

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
    public int size(Key lo, Key hi) {
        if (lo.compareTo(hi) > 0)   return 0;
        if (contains(hi))   return rank(hi) - rank(lo) + 1;
        else    return rank(hi) - rank(lo);
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
    //非递归查找
    public Value get2(Key key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0)    x = x.left;
            else if (cmp > 0)   x = x.right;
            else    return x.val;
        }
        return null;
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
    //非递归插入
    public void put2(Key key, Value val) {
        Node x = root;
        Node t = root;
        int cmp = 0;
        while (x != null) {
            cmp = key.compareTo(x.key);
            if (cmp < 0) {
                t = x;
                x = x.left;
            }
            else if (cmp > 0) {
                t = x;
                x = x.right;
            }
            else  {
                x.val = val;
                return;
            }
        }
        if (cmp < 0)    t.left = new Node(key, val, 1);
        else if (cmp > 0)    t.right = new Node(key, val, 1);
        x = root;
        //更新结点计数器
        while (true) {
            int cmpa = key.compareTo(x.key);
            if (cmpa < 0) {
                x.N++;
                x = x.left;
            }
            else if (cmpa > 0) {
                x.N++;
                x = x.right;
            }
            else    break;
        }
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
    //按顺序选择
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
    //遍历
    public void print() {
        print(root);
    }
    private void print(Node x) {
        if (x == null)  return;
        print(x.left);
        System.out.print(x.key);
        System.out.print(" ");
        print(x.right);
    }
    public Iterable<Key> keys() {
        return keys(min(), max());
    }
    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> queue = new LinkedList<Key>();
        keys(root, queue, lo, hi);
        return queue;
    }
    private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
        if (x == null)  return;
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if (cmplo < 0)  keys(x.left, queue, lo, hi);    //lo<x.key
        if (cmplo <= 0 && cmphi >= 0)   queue.offer(x.key); //lo<=x.key<=hi
        if (cmphi > 0)  keys(x.right, queue, lo, hi);   //x.key<hi
    }
    //高度(一个结点的树高度为0)
    public int height() {
        return height(root);
    }
    private int height(Node x) {
        if (x == null)  return -1;
        return 1 + Math.max(height(x.left), height(x.right));
    }
    //按层遍历key
    public Iterable<Key> levelOrderKeys() {
        Queue<Key> keys = new LinkedList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node x = queue.poll();
            if (x == null)  continue;
            keys.offer(x.key);
            queue.offer(x.left);
            queue.offer(x.right);
        }
        return keys;
    }
    //判断是否为二分查找树
    public boolean isBST() {
        return isBST(root, null, null);
    }
    private boolean isBST(Node x, Key min, Key max) {
        if (x == null)  return true;
        if (min != null && x.key.compareTo(min) <= 0)
            return false;
        if (max != null && x.key.compareTo(max) >= 0)
            return false;
        return isBST(x.left, min, x.key) && isBST(x.right, x.key, max);
    }
    //检查结点数是否正确
    public boolean isSizeCorrect() {
        return isSizeCorrect(root);
    }
    private boolean isSizeCorrect(Node x) {
        if (x == null)  return true;
        if (x.N != size(x.left) + size(x.right) + 1)
            return false;
        return isSizeCorrect(x.left) && isSizeCorrect(x.right);
    }
    //检查顺序是否连续
    public boolean isRankConsistent() {
        for (int i = 0; i < size(); i++)
            if (i != rank(select(i)))   return false;
        for (Key key : keys())
            if (key.compareTo(select(rank(key))) != 0)
                return false;
        return true;
    }
}



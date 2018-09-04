package S3_Searching.S3_5_SparseVector;

import java.util.HashMap;

/**
 * Created by Brian Lee on 2018/9/4.
 */
public class SparseVector {
    private HashMap<Integer, Double> st;
    public SparseVector() {
        st = new HashMap<>();
    }
    public int size() {
        return st.size();
    }
    public void put(int i, double x) {
        st.put(i, x);
    }
    public double get(int i) {
        if (!st.containsKey(i)) return 0.0;
        else    return st.get(i);
    }
    public double dot(double[] that) {
        double sum = 0.0;
        for (int i : st.keySet())
            sum += that[i] * this.get(i);
        return sum;
    }
}

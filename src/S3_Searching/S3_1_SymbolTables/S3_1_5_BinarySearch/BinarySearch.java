package S3_Searching.S3_1_SymbolTables.S3_1_5_BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Brian Lee on 2018/3/14.
 */
public class BinarySearch {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Please input the number of integer:");
        int n = in.nextInt();
        int[] integer = new int[n];
        System.out.println("Please input integer:");
        for (int i = 0; i < n; i++) {
            integer[i] = in.nextInt();
        }
        Arrays.sort(integer);
        System.out.println("Please input the key");
        int key = in.nextInt();
        int index = binarySearch(integer, n, key);
//        int index = binarySearchRecur(integer, key, 0, integer.length - 1);
        System.out.println(index);
        if (integer[index] == key)
            System.out.println("Y");
        else
            System.out.println("N");
    }

    public static int binarySearch (int[] integer, int n, int key) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (key < integer[mid]) {
                high = mid -1;
            }
            else if (key > integer[mid]){
                low = mid + 1;
            }
            else {
                return mid; //查找到
            }
        }
        return low;  //未查找到，返回比其少的数量
    }

    public static int binarySearchRecur (int[] integer,  int key, int lo, int hi) {
        if (lo > hi)
            return lo;
        int mid = (lo + hi) / 2;
        if (integer[mid] == key)
            return mid;
        else if (integer[mid] > key)
            return binarySearchRecur(integer, key, 0, mid - 1);
        else
            return binarySearchRecur(integer, key, mid + 1, hi);
    }
}

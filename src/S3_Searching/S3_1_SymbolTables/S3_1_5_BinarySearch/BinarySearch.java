package S3_Searching.S3_1_SymbolTables.S3_1_5_BinarySearch;

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
        System.out.println("Please input the key");
        int key = in.nextInt();
        int index = binarySearch(integer, n, key);
        if (index == -1) {
            System.out.println("The key is not in the integers");
        }
        else {
            System.out.println("The index is: " + index);
        }
    }

    public static int binarySearch (int[] integer, int n, int key) {
        int low = 0;
        int high = n-1;
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
        return -1;  //未查找到
    }
}

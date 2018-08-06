package Others.DaysBetweenTwoDays;
import java.util.Scanner;

/**
 * Created by Brian Lee on 2018/8/5.
 */
public class Main {
    /**
     * 闰年被定义为能被4整除的年份，但是能被100整除而不能被400整除的年是例外，它们不是闰年。闰年的2月份有29天。
     */
    public static boolean isLeap(int year) {
        if (year % 100 == 0 && year % 400 != 0) {
            return false;
        }
        else if (year % 4 == 0) {
            return true;
        }
        else {
            return false;
        }
    }
    public static int daysInMonth(int year, int month) {
        int[] days = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (month != 2) {
            return days[month - 1];
        }
        else if (isLeap(year)){
            return 29;
        }
        else {
            return 28;
        }
    }
    public static int daysInYear(int year, int month, int day) {
        int days = day;
        for(int y = 1; y < year; y ++) {
            if (isLeap(y)) {
                days += 366;
            }
            else {
                days += 365;
            }
        }
        for(int m = 1; m < month; m ++) {
            days += daysInMonth(year, m);
        }
        return days;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int year1 = in.nextInt();
        int month1 = in.nextInt();
        int day1 = in.nextInt();
        int year2 = in.nextInt();
        int month2 = in.nextInt();
        int day2 = in.nextInt();
        //System.out.printf("%d, %d, %d, %d, %d, %d", year1, month1, day1, year2, month2, day2);
        int days1 = daysInYear(year1, month1, day1);
        int days2 = daysInYear(year2, month2, day2);
        System.out.println(days2 - days1);
    }
}


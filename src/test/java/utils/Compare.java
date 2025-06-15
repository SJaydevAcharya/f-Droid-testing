package utils;

import java.util.*;

public class Compare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take 5 integer inputs
        int one = sc.nextInt();
        int two = sc.nextInt();
        int three = sc.nextInt();
        int four = sc.nextInt();
        int five = sc.nextInt();

        // Calculate sums
        int sum1 = one + two + three;
        int sum2 = four + five;

        // Compare and print result
        if (sum1 > sum2) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

        sc.close(); // Close the scanner
    }
}
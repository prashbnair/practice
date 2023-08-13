package practice.ds;

import java.util.Arrays;

public class Recursion {

    public static void main(String[] args) {
//        permutations(new int[]{1,2,3}, 0);
//        print(10);
        System.out.println(fib(4));
    }

    private static void print(int n){
        if (n == 0)
            return;
        print(n - 1);
        System.out.println(n);
    }

    private static int fact(int n, int k) {
        if (n == 0 || n == 1){
            return k;
        }

        return fact(n - 1, n * k);
    }

    private static int sum (int n) {
        if (n == 0)
            return 0;

        return n + sum(n - 1);
    }

    private static boolean palindrome(String s) {
        if (s.length() == 2) {
            if (s.charAt(0) == s.charAt(1)) {
                return true;
            }
            else {
                return false;
            }
        }

        if (s.length() == 1) {
            return true;
        }

        return  (s.charAt(0) == s.charAt(s.length() -1)) && palindrome(s.substring(1, s.length() -1));

    }

    private static int sumOfDigits(int n) {
        if (n/10 == 0) {
            return n;
        }

        return sumOfDigits(n/10) + n%10;

    }

    private static int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        return fib(n -1) + fib(n - 2);

    }

    private static void permutations(int[] arr, int position) {
        System.out.println(position);
        if (position == arr.length) return;

        for (int i = position; i < arr.length; i++) {
            int[] newArr = Arrays.copyOf(arr, arr.length);
            swap(newArr, position, i);
            for (int j = 0; j < newArr.length; j++) {
                System.out.print(newArr[j] + " ,");
            }
            System.out.println();
            position = position + 1;
            permutations(newArr, position);
        }
    }

    private static int[] swap(int[]arr, int position, int i) {
        int tmp = arr[position];
        arr[position] = arr[i];
        arr[i] = tmp;

        return arr;
    }
}

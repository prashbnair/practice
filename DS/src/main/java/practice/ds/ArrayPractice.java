package practice.ds;

import java.util.*;

public class ArrayPractice {

    public static void main(String[] args) {
        int[] arr = {1, 3, -5, 6, -2};
//        longestSubArray(arr);
        printTwoDimensionalArr();
    }

    // Pattern maintain maxDiff from current Min
    private static int maxStockPrice(int[] prices) {
        int maxDiff = 0, minPrice = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }

            if ((prices[i] - minPrice) > maxDiff) {
                maxDiff = prices[i] - minPrice;
            }
        }

        return maxDiff;
    }

    private static void mergeIntervals(int[][] intervals) {

        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        List<int[]> mergedIntervals = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            if (mergedIntervals.size() != 0 && (mergedIntervals.get(mergedIntervals.size() - 1))[1] > intervals[i][0]){
                continue;
            }

            int k = i;
            for (int j = i ; j < intervals.length - 1; j++) {
                if (intervals[j][1] >= intervals[j + 1][0]) {
                    k = j + 1;
                    continue;
                }
            }

            mergedIntervals.add(new int[]{intervals[i][0], intervals[k][1]});
        }
        for(int[] arr : mergedIntervals) {
            System.out.println(arr[0] + " " + arr[1]);
        }
    }

    private static void mergeSortedArrays(int[] arr, int[] arr1) {
        int len = Math.max(arr.length, arr1.length);
        for (int i = 0, j = 0; i < arr.length;) {
            if (arr[i] < arr[j]) {
                i++;
            }
            else {

            }
        }
    }

    private static void secondLargest(int[] arr) {
        int max = Integer.MIN_VALUE;
        int second_max = Integer.MIN_VALUE;

        for (int i : arr){
            if (i > max) max = i;
        }

        for (int i : arr) {
            if ((i > second_max) && (i != max)) second_max = i;
        }

        System.out.println(max);
        System.out.println(second_max);
    }

    private static void leftRotate(int[] arr) {
        int first = arr[0];
        for(int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = first;
    }

    private static void moveZeroes(int[] arr) {
        int countZeroes = 0;

        for (int i : arr) {
            if (i == 0) countZeroes++;
        }

        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                k = i;
            }
            else {
                arr[k] = arr[i];
            }
        }

        for (int i = arr.length - countZeroes; i < arr.length; i++) {
            arr[i] = 0;
        }
    }

    private static int[] mergeSort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }
        int len = arr.length;
        int[] arr1 = mergeSort(Arrays.copyOfRange(arr, 0, len/2));
        int[] arr2 = mergeSort(Arrays.copyOfRange(arr, len/2, len));
        return merge(arr1, arr2);
    }

    private static int[] merge(int[] arr1, int[] arr2) {
        int i = 0, j = 0, k = 0;
        int[] mergedArr = new int[arr1.length + arr2.length];
        while (i < arr1.length && j < arr2.length) {
            if (i < arr1.length && arr1[i] <= arr2[j]) {
                mergedArr[k] = arr1[i];
                i++;
            }
            else if (j < arr2.length){
                mergedArr[k] = arr2[j];
                j++;
            }
            k++;
        }

        while (i < arr1.length) {
            mergedArr[k] = arr1[i];
            i++;
            k++;
        }

        while (j < arr2.length) {
            mergedArr[k] = arr2[j];
            j++;
            k++;
        }
        return mergedArr;
    }

    private static void longestSubArray(int[] nums) {
        int len = 0;

        for(int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            if(sum == 0) {
                len = Math.max(len, 1);
            }
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if(sum == 0) {
                    len = Math.max(len, j - i + 1);
                }
            }
        }

        System.out.println(len);
    }

    private static void longestSubStringWithoutRepeating(char[] arr) {
        int right = 0, left = 0, len = 0;
        Set<Character> set = new HashSet<>();

        while(right < arr.length) {
            if(set.contains(arr[right])) {
                len = Math.max(len, right - left + 1);
                left++;
                while((left < right) && arr[left] != arr[right]){
                    left++;
                }
            }
            else {
                set.add(arr[right]);
                right++;
            }
        }

        for(int i = 0; i < arr.length; i++) {
            if(set.contains(arr[i])) {
                len = Math.max(len, 0);

            }
            else {

            }
        }
    }

    private static void printTwoDimensionalArr() {
        int[][] arr = new int[3][5];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = 1;
            }
        }

    }
}

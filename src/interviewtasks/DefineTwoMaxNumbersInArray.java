package interviewtasks;

import java.util.Arrays;

public class DefineTwoMaxNumbersInArray {

    public static void main(String[] args) {
        //Define two max numbers in array
        System.out.println("Define two max numbers in array");
        System.out.println(Arrays.toString(defineTwoMaxValues(new int[] {8, 7, 2, 2, 9, 10})));

    }

    // Define two max numbers in array
    public static int[] defineTwoMaxValues(int[] nums) {
        int max1 = 0;
        int max2 = 0;

        for (int num : nums) {
            if (num > max1) {
                max2 = max1;
                max1 = num;
            }

            if (num < max1 && num > max2) {
                max2 = num;
            }
        }

        return new int[] {max1, max2};
    }
}
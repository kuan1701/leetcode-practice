package algocode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Examples {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 4, 5};
        int[] nums2 = {1, 2, 3, 4, 5, 3};

        System.out.println(defineDuplicateIndex(nums));
        System.out.println(defineDuplicateIndex2(nums2));

    }

    // Дан массив целых чисел nums.
    // Верни true, если какое-то значение встречается хотя бы два раза.
    // Если все элементы уникальны — верни false.
    public static boolean defineDuplicateIndex(int[] nums) {
        // if array is sorted
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                System.out.println(
                        "Array " + Arrays.toString(nums) + " has duplicate at index " + (i - 1) + " and " + i);
                return true;
            }
        }

        System.out.println("Array " + Arrays.toString(nums) + " doesn't have duplicate indexes");
        return false;
    }

    public static boolean defineDuplicateIndex2(int[] nums) {
        // if array is not sorted
        Set<Integer> set = new HashSet<>();

        for (int i = 1; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                System.out.println("Array " + Arrays.toString(nums) + " has duplicate indexes");
                return true;
            }
            set.add(nums[i]);
        }

        System.out.println("Array " + Arrays.toString(nums) + " doesn't have duplicate indexes");
        return false;
     }
}

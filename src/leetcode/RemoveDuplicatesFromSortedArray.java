package leetcode;

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        //26. Remove Duplicates from Sorted Array
        System.out.println("26. Remove Duplicates from Sorted Array");
        System.out.println(removeDuplicates(new int[] {1, 1, 1, 2}));
    }

    //26. Remove Duplicates from Sorted Array
    public static int removeDuplicates(int[] nums) {
        int result = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[result] = nums[i];
                result++;
            }
        }

        return result;
    }
}
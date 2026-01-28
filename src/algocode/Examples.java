package algocode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Examples {

  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4, 4, 5};
    int[] nums2 = {1, 2, 3, 4, 5, 3};

    List<Integer> integerList1 = List.of(-4, 1, 2, 3, 3, 4, 4, 5, 6, 6);
    List<Integer> integerList2 = List.of(1, 1, 3, 3, 4, 4, 5, 6, 6, 7);

    System.out.println(defineDuplicateIndex(nums));
    System.out.println(defineDuplicateIndex2(nums2));
    System.out.println(Arrays.toString(new List[]{commonNumsList(integerList1, integerList2)}));

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

  // Даны два монотонно возрастающих массива nums1 и nums2.
  // Нужно вернуть массив nums3, который тоже будет монотонно возрастающим,
  // и при этом содержать все общие элементы nums1 и nums2.
  public static List<Integer> commonNumsList(List<Integer> nums1, List<Integer> nums2) {
    List<Integer> list = new ArrayList<>();
    int p1 = 0;
    int p2 = 0;

    while (p1 < nums1.size() && p2 < nums2.size()) {
      if (nums1.get(p1) < nums2.get(p2)) {
        p1++;
      } else if (nums1.get(p1) > nums2.get(p2)) {
        p2++;
      } else {
        list.add(nums1.get(p1));
        p1++;
        p2++;
      }
    }

    return list;
  }
}

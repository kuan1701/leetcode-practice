package algocodeio.eachaccordingtothepoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class SymmetricalDifferenceOfArrays {

  public static void main(String[] args) {
    System.out.println("Result №1:");
    System.out.println(defineSymmetricalDifferenceOfArrays(
        Arrays.asList(1, 5, 7, 9),
        Arrays.asList(2, 3, 5, 6, 7)));

    System.out.println("Result №2:");

  }

  /**
   * Даны два массива nums1 и nums2, отсортированные по возрастанию и состоящие из уникальных
   * элементов. Нужно найти все элементы, которые встречаются только в одном из массивов и вернуть
   * их в порядке возрастания.
   * <p>
   * Пример 1: Ввод: nums1 = [1,5,7,9], nums2 = [2,3,5,6,7,8] Вывод: [1,2,3,6,8,9]
   * <p>
   * Пример 2: Ввод: nums1 = [2,3], nums2 = [1] Вывод: [1,2,3]
   * <p>
   * Ограничения: len(nums1) + len(nums2) >= 1
   */
  public static List<Integer> defineSymmetricalDifferenceOfArrays(
      List<Integer> nums1,
      List<Integer> nums2
  ) {
    int p1 = 0;
    int p2 = 0;

    List<Integer> result = new ArrayList<>();

    while (p1 < nums1.size() && p2 < nums2.size()) {
      if (nums1.get(p1) < nums2.get(p2)) {
        result.add(nums1.get(p1));
        p1++;
      } else {
        result.add(nums2.get(p2));
        p2++;
      }

      if (Objects.equals(nums1.get(p1), nums2.get(p2))) {
        p1++;
        p2++;
      }
    }

    // дописываем остаток того массива, который не закончился
    result.addAll(nums1.subList(p1, nums1.size()));
    result.addAll(nums2.subList(p2, nums2.size()));

    return result;
  }
}

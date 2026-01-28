package algocodeio.eachaccordingtothepoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DefineCommonNumbers {

  public static void main(String[] args) {
    System.out.println("Result №1:");
    System.out.println(defineCommonNumbers(
        Arrays.asList(1, 1, 3, 4, 5, 5, 7, 8, 8),
        Arrays.asList(-1, 1, 3, 3, 5, 5, 7, 7, 8)
    ));

    System.out.println("Result №2:");
    System.out.println(defineCommonNumbers(
        Arrays.asList(1, 1, 3, 4, 5, 5, 7, 8, 8),
        Arrays.asList(-1, -1, 2, 2, 6, 6, 9, 9, 9)
    ));
  }

  /**
   * Даны два отсортированных по возрастанию массива nums1 и nums2. Необходимо вернуть новый массив
   * nums3, который содержит все общие элементы из nums1 и nums2.

   * Результат должен быть также отсортирован по возрастанию. Если элементы встречаются в массивах
   * несколько раз, то их нужно продублировать в ответе.

   * Пример 1: Ввод: nums1 = [-3,2,2,5,8,19,31], nums2 = [1,2,2,2,6,19,52] Вывод: [2,2,19]

   * Пример 2: Ввод: nums1 = [-5,4], nums2 = [1,2] Вывод: []

   * Пример 3: Ввод: nums1 = [], nums2 = [1,2] Вывод: []

   * Ограничения: len(nums1), len(nums2) >= 0

   * Оценка сложности
   * Время: O(n+m), где n - размер массива nums1, m - размер массива nums2
   * Память: O(min(n, m)), где n - размер массива nums1, m - размер массива nums2
   */
  public static List<Integer> defineCommonNumbers(List<Integer> nums1, List<Integer> nums2) {
    int p1 = 0;
    int p2 = 0;

    List<Integer> result = new ArrayList<>();

    while (p1 < nums1.size() && p2 < nums2.size()) {
      if (nums1.get(p1) < nums2.get(p2)) {
        p1++;
      } else if (nums1.get(p1) > nums2.get(p2)) {
        p2++;
      } else {
        result.add(nums1.get(p1));
        p1++;
        p2++;
      }
    }

    return result;
  }
}

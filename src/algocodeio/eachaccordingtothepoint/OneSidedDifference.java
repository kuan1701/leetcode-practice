package algocodeio.eachaccordingtothepoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OneSidedDifference {

  public static void main(String[] args) {
    System.out.println("Result №1:");
    System.out.println(findDifference(
        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
        Arrays.asList(4, 5, 6)
    ));

    System.out.println("Result №2:");
    System.out.println(findDifference(
        Arrays.asList(1, 2, 2, 3, 3, 3, 3, 4),
        Arrays.asList(0, 0, 0, 3)
    ));
  }

  /**
   * Даны два массива nums1 и nums2, отсортированные по не убыванию. Необходимо вернуть все элементы
   * из nums1, которые не встречаются в nums2, так же в порядке по не убыванию.

   * Пример 1:
   * Ввод:
   * nums1 = [1,2,3,4,5],
   * nums2 = [4,5,6]
   * Вывод: [1,2,3]

   * Пример 2:
   * Ввод:
   * nums1 = [1,2,2,3,3,3,3,4],
   * nums2 = [0,0,0,3]
   * Вывод: [1,2,2,4]
   * Объяснение: удаляем все тройки из nums1 даже если в nums2 встречается только 1 раз

   * Ограничения:
   * len(nums1) >= 0
   * len(nums2) >= 0
   */
  public static List<Integer> findDifference(List<Integer> nums1, List<Integer> nums2) {
    int p1 = 0;
    int p2 = 0;

    List<Integer> result = new ArrayList<>();

    while (p1 < nums1.size()) {
      // если nums2 закончился — все оставшиеся из nums1 идут в результат
      if (p2 >= nums2.size()) {
        result.add(nums1.get(p1));
        p1++;
        continue;
      }

      // если текущий элемент nums1 меньше — он есть только в nums1
      if (nums1.get(p1) < nums2.get(p2)) {
        result.add(nums1.get(p1));
        p1++;
      } else if (nums1.get(p1) > nums2.get(p2)) {
        p2++;
      } else {
        // при равных элементах пропускаем в nums1
        // для верной обработки дублей в nums1
        p1++;
      }
    }

    return result;
  }
}

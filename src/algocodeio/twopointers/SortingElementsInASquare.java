package algocodeio.twopointers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingElementsInASquare {
    static void main() {
        List<Integer> nums = List.of(-3, -2, 0, 1, 3, 5);
        System.out.println(sortElementsInSquare(nums));
    }

    /**
     Дан массив nums, отсортированный в неубывающем порядке.
     Нужно вернуть отсортированный массив, состоящий из всех элементов массива nums, возведенных в квадрат.
     Неубывающий порядок – порядок, где каждый следующий элемент больше или равен предыдущему.

     Пример 1:
     Ввод: nums = [-3,-2,0,1,3,5]
     Вывод: [0,1,4,9,9,25]

     Пример 2:
     Ввод: nums = [-5,-3,-1]
     Вывод: [1,9,25]

     Ограничения:
     len(nums) >= 1
     */
    public static List<Integer> sortElementsInSquare(List<Integer> nums) {
        List<Integer> result = new ArrayList<>();

        int p1 = 0;
        int p2 = nums.size() - 1;

        while (p1 <= p2) {
            if (Math.abs(nums.get(p1)) > Math.abs(nums.get(p2))) {
                result.add(Math.abs(nums.get(p1)) * Math.abs(nums.get(p1)));
                p1++;
            } else {
                result.add(Math.abs(nums.get(p2)) * Math.abs(nums.get(p2)));
                p2--;
            }
        }

        Collections.reverse(result);
        return result;
    }
}

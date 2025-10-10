package algocodeio.twopointers;

import java.util.Arrays;
import java.util.List;

public class SumInASortedArray {
    static void main() {
        List<Integer> nums = List.of(-3, -2, 0, 1, 3, 5);
        System.out.println(sumInArraySorted(nums, 6));
    }

    /**
     * Дан отсортированный массив nums и число target. Нужно вернуть позиции двух чисел,
     * которые дают в сумме target, при этом ответ гарантированно присутствует и он единственный.
     * Нужно вернуть сначала меньший индекс, а потом больший (индексы не могут быть равными).
     * При этом индексация в массиве начинается с единицы, а не с нуля.
     * ВАЖНО: реши за O(1) по памяти
     * =========
     * Ввод: nums = [-2,1,6,9,12], target=18
     * Вывод: [3,5]
     * Объяснение: 18 = 6 + 12, 6-ка имеет индекс 3, а 12 - индекс 5
     * =========
     * Пример 2:
     * Ввод: nums = [3,3,12], target=6
     * Вывод: [1,2]
     * =========
     * Ограничения:
     * len(nums) >= 2
     */
    public static List<Integer> sumInArraySorted(List<Integer> nums, int target) {
        int p1 = 0;
        int p2 = nums.size() - 1;

        while (p1 != p2) {
            int currentSum = nums.get(p1) + nums.get(p2);

            if (currentSum == target) {
                return Arrays.asList(p1 + 1, p2 + 1);
            }

            if (currentSum > target) {
                p2--;
            } else {
                p1++;
            }
        }

        return Arrays.asList(-1 , -1);
    }
}

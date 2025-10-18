package algocodeio.twopointers;

import java.util.Arrays;
import java.util.List;

public class DefineTheLargestContainer {
    public static void main(String[] args) {
        System.out.println("Result of solution №1:");
        System.out.println(maxAreaSolution1(Arrays.asList(1, 8, 6, 2, 5, 4, 8, 3, 7)));
        System.out.println("Result of solution №2:");
        System.out.println(maxAreaSolution2(Arrays.asList(1, 8, 6, 2, 5, 4, 8, 3, 7)));

    }

    /**
     Дан массив целых чисел nums, nums[i] – высота линии
     Нужно найти максимальную площадь, которую может заполнить вода между двумя линиями.
     ВАЖНО: площадь воды считается как min(nums[i], nums[j]) * (j - i), где i – индекс первой линии, а j - номер второй.

     Пример 1:
     Ввод: nums = [1,8,6,2,5,4,8,3,7]
     Вывод: 49
     Объяснение: 7 * (8 - 1) = 49, "1" - индекс первой линии, "8" - второй

     Пример 2:
     Ввод: nums = [2,3,4,5]
     Вывод: 6
     */
    public static int maxAreaSolution1(List<Integer> height) {
        int p1 = 0;
        int p2 = height.size() - 1;
        int maxArea = 0;
        int currMaxArea;

        while (p1 < p2) {
            if (height.get(p1) < height.get(p2)) {
                currMaxArea = (p2 - p1) * height.get(p1);
                p1++;
            } else {
                currMaxArea = (p2 - p1) * height.get(p2);
                p2--;
            }

            if (currMaxArea > maxArea) {
                maxArea = currMaxArea;
            }
        }

        return maxArea;
    }

    public static int maxAreaSolution2(List<Integer> height) {
        int p1 = 0;
        int p2 = height.size() - 1;
        int maxArea = 0;

        while (p1 < p2) {
            int currentArea = Math.min(height.get(p1), height.get(p2)) * (p2 - p1);
            maxArea = Math.max(maxArea, currentArea);

            if (height.get(p1) < height.get(p2)) {
                p1++;
            } else {
                p2--;
            }
        }

        return maxArea;
    }
}

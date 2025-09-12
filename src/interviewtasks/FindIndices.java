package interviewtasks;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindIndices {

  public static void main(String[] args) {

    List<Integer> integers = findIndices(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 10);

    if (integers.isEmpty()) {
      System.out.println("No indices found!!!");
    }

    integers.forEach(System.out::println);
  }

  /**
   Дан массив целых чисел. Необходимо вернуть индексы тех 2-ух элементов, которые в сумме дадут заданное число.
   Входные данные всегда имеют решение и оно единственное.
   */
  public static List<Integer> findIndices(List<Integer> numbers, int target) {
    Set<Integer> result = new HashSet<>();
    boolean found = false;

    if (numbers == null || numbers.isEmpty()) {
      return Collections.emptyList();
    }

    for (int i = 0; i < numbers.size(); i++) {
      for (int j = i + 1; j < numbers.size(); j++) {
        if (numbers.get(i) + numbers.get(j) == target) {
          result.add(i);
          result.add(j);
          found = true;
        }

        if (found) {
          return result.stream().toList();
        }
      }
    }

    return Collections.emptyList();
  }
}
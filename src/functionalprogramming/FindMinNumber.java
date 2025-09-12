package functionalprogramming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FindMinNumber {

    public static void main(String[] args) {
      List<Integer> numbers = Arrays.asList(5, 8, 4, -50, 100, 28, 99, -13, 68);

      Comparator<Integer> comparator = Integer::compareTo;

      Integer min1 = numbers.stream()
              .min(comparator)
              .orElseThrow(() -> new IllegalArgumentException("List must not be null or empty"));

      Integer min2 = numbers.stream()
              .min(Integer::compareTo)
              .orElseThrow(() -> new IllegalArgumentException("List must not be null or empty"));


      Integer min3 = numbers.stream()
              .min(Comparator.naturalOrder())
              .orElseThrow(() -> new IllegalArgumentException("List must not be null or empty"));

      Integer min4 = numbers.stream()
              .min(Integer::compareTo)
              .orElseThrow(() -> new IllegalArgumentException("List must not be null or empty"));

        System.out.println(min1);
        System.out.println(min2);
        System.out.println(min3);
        System.out.println(min4);
    }
}
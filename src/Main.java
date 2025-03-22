import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

  public static void main(String[] args) {
    // 13. Roman to Integer
    System.out.println(romanToInt("MCMXCIV"));

    //14. Longest common prefix
    System.out.println(defineCommonPrefix(new String[]{"dog","racecar","car"}));
    System.out.println(defineCommonPrefix2(new String[]{"dog","doracecar","docar"}));

    //Define two max number in array
    System.out.println(Arrays.toString(defineTwoMaxValues(new int[] {8, 7, 2, 2, 9, 10})));

  }

  // 13. Roman to Integer
  public static int romanToInt(String roman) {
    int sum = 0;

    Map<Character, Integer> map = new HashMap<>();
    map.put('I', 1);
    map.put('V', 5);
    map.put('X', 10);
    map.put('L', 50);
    map.put('C', 100);
    map.put('D', 500);
    map.put('M', 1000);

    for (int i = 0; i < roman.length(); i++) {
      if (i < roman.length() - 1 && (map.get(roman.charAt(i)) < map.get(roman.charAt(i + 1)))) {
        sum -= map.get(roman.charAt(i));
      } else {
        sum += map.get(roman.charAt(i));
      }
    }

    return sum;
  }

  //14. Longest common prefix
  public static String defineCommonPrefix(String[] strs) {
    StringBuilder commonPrefix = new StringBuilder();

    Arrays.sort(strs);

    String firstStr = strs[0];
    String lastStr = strs[strs.length - 1];

    for (int i = 0; i < Math.min(firstStr.length(), lastStr.length()); i++) {
      if (firstStr.charAt(i) != lastStr.charAt(i)) {
        return commonPrefix.toString();
      }

      commonPrefix.append(lastStr.charAt(i));
    }

    return commonPrefix.toString();
  }

  public static String defineCommonPrefix2(String[] strs) {
    if (strs.length == 0) {
      return "";
    }

    String prefix = strs[0];

    for (int i = 1; i < strs.length; i++) {
      while (strs[i].indexOf(prefix) != 0) {
        prefix = prefix.substring(0, prefix.length() - 1);

        if (prefix.isEmpty()) {
          return "";
        }
      }
    }

    return prefix;
  }

  public static int[] defineTwoMaxValues(int[] nums) {
    int max1 = 0;
    int max2 = 0;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > max1) {
        max2 = max1;
        max1 = nums[i];
      }

      if (nums[i] < max1 && nums[i] > max2) {
        max2 = nums[i];
      }
    }

    return new int[] {max1, max2};
  }
}
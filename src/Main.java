import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        // 13. Roman to Integer
        System.out.println("13. Roman to Integer");
        System.out.println(romanToInt("MCMXCIV"));

        //14. Longest common prefix
        System.out.println("14. Longest common prefix");
        System.out.println(defineCommonPrefix(new String[] {"dog", "racecar", "car"}));
        System.out.println(defineCommonPrefix2(new String[] {"dog", "doracecar", "docar"}));

        //20. Valid Parentheses
        System.out.println("20. Valid Parentheses");
        System.out.println(isValidParentheses("{[]}"));

        //26. Remove Duplicates from Sorted Array
        System.out.println("26. Remove Duplicates from Sorted Array");
        System.out.println(removeDuplicates(new int[] {1, 1, 1, 2}));

        //Define two max numbers in array
        System.out.println("Define two max numbers in array");
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

    //20. Valid Parentheses
    public static boolean isValidParentheses(String str) {
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.add(c);
            } else {
                if (stack.isEmpty()
                        || c == ')' && stack.pop() != '('
                        || c == ']' && stack.pop() != '['
                        || c == '}' && stack.pop() != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    //26. Remove Duplicates from Sorted Array
    public static int removeDuplicates(int[] nums) {
        int result = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[result] = nums[i];
                result++;
            }
        }

        return result;
    }

    // Define two max numbers in array
    public static int[] defineTwoMaxValues(int[] nums) {
        int max1 = 0;
        int max2 = 0;

        for (int num : nums) {
            if (num > max1) {
                max2 = max1;
                max1 = num;
            }

            if (num < max1 && num > max2) {
                max2 = num;
            }
        }

        return new int[] {max1, max2};
    }
}
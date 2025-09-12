package leetcode;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteher {

    public static void main(String[] args) {
        // 13. Roman to Integer
        System.out.println("13. Roman to Integer");
        System.out.println(romanToInt("MCMXCIV"));
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
}
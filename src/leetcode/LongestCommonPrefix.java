package leetcode;

import java.util.Arrays;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        //14. Longest common prefix
        System.out.println("14. Longest common prefix");
        System.out.println(defineCommonPrefix(new String[] {"dog", "racecar", "car"}));
        System.out.println(defineCommonPrefix2(new String[] {"dog", "doracecar", "docar"}));
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
}
package leetcode;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        //20. Valid Parentheses
        System.out.println("20. Valid Parentheses");
        System.out.println(isValidParentheses("{[]}"));
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
}
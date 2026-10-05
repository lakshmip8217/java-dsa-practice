package stack;

import java.util.Map;
import java.util.Stack;

public class ValidateParentheses {
    private static final Map<Character, Character> BRACKET_MAP = Map.of(
            '}', '{',
            ']', '[',
            ')', '('
               );
    void main() {
        System.out.println(isValidParentheses("()[]{}"));
        System.out.println(isValidParentheses("{[()]}"));
        System.out.println(isValidParentheses("([)]"));
        System.out.println(isValidParentheses("(()"));
        System.out.println(isValidParentheses(")("));

        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("{[()]}"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("(()"));
        System.out.println(isValid(")("));
    }

    /**
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     * n the worst-case scenario (for example, an input string consisting entirely of opening brackets like ((((((),
     * the algorithm must push every single character onto the stack
     * @param str
     * @return
     */
    public static boolean isValidParentheses(String str) {
        Stack<Character> stack = new Stack<>();
        char[] array = str.toCharArray();
        for(char c: array) {
            if(c == '{' || c == '[' || c == '(') {
                stack.push(c);
            }else {
                if(stack.isEmpty()) {
                    return false;
                }
                char t = stack.pop();
                // Check for strict pairing mismatches
                if ((c == '}' && t != '{') ||
                        (c == ']' && t != '[') ||
                        (c == ')' && t != '(')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static boolean isValid(String str) {
        Stack<Character> stack1 = new Stack<>();
        for (char c : str.toCharArray()) {
            // If it's a closing bracket
            if (BRACKET_MAP.containsKey(c)) {
                // Stack can't be empty, and the top item must match the opening pair
                if (stack1.isEmpty() || stack1.pop() != BRACKET_MAP.get(c)) {
                    return false;
                }
            } else {
                // If it's an opening bracket, push it to the stack
                stack1.push(c);
            }
        }

        return stack1.isEmpty();
    }
}

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//https://leetcode.com/problems/valid-parentheses/
public class LeetCode20ValidParentheses {
    public static void main(String args[]) {
        LeetCode20ValidParentheses clazz = new LeetCode20ValidParentheses();
        System.out.println(clazz.isValid(")"));
    }

    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        char[] str = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length; i ++) {
            if (str[i] == '(' || str[i] == '{' || str[i] == '[') {
                stack.push(map.get(str[i]));
            } else {
                char tmp = stack.isEmpty() ? 'n' : stack.peek();
                if (tmp != str[i]) {
                    return false;
                }
                stack.pop();
            }
        }

        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }
}

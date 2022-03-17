import java.util.Stack;

public class Solution {

    public static void main(String[] args) {

        System.out.println(scoreOfParentheses("()(())"));
    }

    public static int scoreOfParentheses(String s) {

        Stack<Integer> stack = new Stack<>();

        for (char c : s.toCharArray()){
            if (c == '(') {
                stack.push(-1);
            } else {
                int popped = stack.pop();

                if (popped < 0) {
                    stack.push(1);
                } else {
                    int count = popped;
                    while (stack.peek() > 0) {
                        count += stack.pop();
                    }
                    stack.pop();
                    stack.push(2 * count);
                }
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }
}


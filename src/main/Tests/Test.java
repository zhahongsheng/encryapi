
import java.util.Stack;

/**
 * @author zhahsh
 * @date 2021/4/22
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(isValid("(){}}{"));

    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 1; i < s.length(); i++) {
            if (stack.isEmpty()){
                stack.push(s.charAt(i));
                continue;
            }
            switch (s.charAt(i)){
                case ')':
                    if (stack.peek() == '('){
                        stack.pop();
                        break;
                    }
                case '}':
                    if (stack.peek() == '{'){
                        stack.pop();
                        break;
                    }
                case ']':
                    if (stack.peek() == '['){
                        stack.pop();
                        break;
                    }
                default:
                    stack.push(s.charAt(i));
            }
        }
        return stack.empty();
    }
}

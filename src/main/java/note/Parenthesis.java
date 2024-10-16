package note;

import java.util.Stack;

public class Parenthesis {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;  // 여는 괄호가 없으면 false 반환
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Parenthesis p = new Parenthesis();
        String s = "()()";
        boolean ans = p.solution(s);
        System.out.println(ans);
    }
}
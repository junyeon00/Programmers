package note;

import java.util.Stack;

public class Delete {
    public int solution(String s)
    {
        Stack<String> stack = new Stack<>();
        String[] str = s.split("");

        for (int i = 0; i < str.length; i++) {
            // 값이 중복되면 스택에서 제거
            if(!stack.isEmpty() && stack.peek().equals(str[i]))
                stack.pop();
            else
                stack.push(str[i]);
        }

        // 스택이 비어있으면 1 반환, 값이 남아있으면 0 반환
        if(stack.isEmpty())
            return 1;

        return 0;
    }

    public static void main(String[] args) {
        Delete delete = new Delete();
        System.out.println(delete.solution("aabb"));
    }
}
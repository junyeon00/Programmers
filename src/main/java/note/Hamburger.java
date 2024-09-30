package note;

import java.util.Stack;

public class Hamburger {
    public int solution(int[] ingredient) {
        Stack<Integer> stack = new Stack<>();
        int answer = 0;

        for (int i = 0; i < ingredient.length; i++) {
            stack.push(ingredient[i]);

            // 스택의 크기가 4 이상일 때만 패턴 검사
            if (stack.size() >= 4) {
                int size = stack.size();

                // 최근 4개의 재료가 1, 2, 3, 1인지 확인
                if (stack.get(size - 4) == 1 && stack.get(size - 3) == 2 &&
                        stack.get(size - 2) == 3 && stack.get(size - 1) == 1) {
                    // 완성된 햄버거의 재료들 스택에서 제거
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    // 햄버거 개수 증가
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Hamburger hamburger = new Hamburger();
        int[] ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1};
        System.out.println(hamburger.solution(ingredient));  // 예상 출력: 2
    }
}

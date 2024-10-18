package note;

import java.util.ArrayDeque;
import java.util.HashMap;

public class Rotation {
    public int solution(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        // 닫는 괄호를 key로 설정
        map.put(')', '('); map.put(']', '['); map.put('}', '{');

        int n = s.length();
        // 2번 나오게 하게끔 함
        s += s;
        int answer = 0;

        A: for(int i = 0; i < n; i++) {
            ArrayDeque<Character> stack = new ArrayDeque<>();
            // 시작위치부터 원본 문자열의 길이만큼 반복
            for(int j=i; j<i+n; j++){
                char c = s.charAt(j);
                // 맵 안에 해당 키가 없으면 열리는 괄호
                if(!map.containsKey(c))
                    stack.push(c);
                else {
                    // 짝이 맞지 않으면 다시 A로 돌아감
                    if(stack.isEmpty() || !stack.pop().equals(map.get(c)))
                        continue A;
                }
            }
            // 스택이 비어 있으면 answer 1 증가
            if(stack.isEmpty())
                answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Rotation r = new Rotation();
        String s = "){}[](";
        System.out.println(r.solution(s));
    }
}
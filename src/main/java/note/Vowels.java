package note;

import java.util.ArrayList;
import java.util.List;

public class Vowels {
    static List<String> list = new ArrayList<>();
    // 모음 배열
    static String [] words = {"A", "E", "I", "O", "U"};

    public int solution(String word) {
        int answer = 0;
        dfs("", 0);
        int size = list.size();

        for (int i = 0; i < size; i++) {
            if (list.get(i).equals(word)) {
                answer = i;
                break;
            }
        }

        return answer;
    }

    // 깊이우선탐색 재귀 함수
    static void dfs(String str, int len) {
        list.add(str);
        // 문자열 길이가 5가 되면 중지
        if (len == 5)
            return;
        // 문자 추가 후 길이 1 증가
        for (int i = 0; i < 5; i++) {
            dfs(str + words[i], len + 1);
        }
    }

    public static void main(String[] args) {
        Vowels v = new Vowels();
        String word = "AAAAE";
        System.out.println(v.solution(word));
    }
}
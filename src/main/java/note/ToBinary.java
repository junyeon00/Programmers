package note;

import java.util.Arrays;

public class ToBinary {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int removeCount = 0;
        int binaryCount = 0;

        // s가 1이 될 때까지 반복
        while (!s.equals("1")) {
            int originalLength = s.length();
            s = s.replace("0", "");  // s에서 모든 0 제거
            int newLength = s.length();

            removeCount += (originalLength - newLength);  // 제거된 0의 개수 증가

            // 이진 변환
            s = Integer.toBinaryString(newLength);
            binaryCount++;
        }

        answer[0] = binaryCount;
        answer[1] = removeCount;

        return answer;
    }

    public static void main(String[] args) {
        ToBinary binary = new ToBinary();
        String s = "01110";
        String answer = Arrays.toString(binary.solution(s));
        System.out.println(answer);
    }
}
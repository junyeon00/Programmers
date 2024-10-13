package note;

import java.util.Arrays;
import java.util.HashSet;

public class TwoSum {
    public int[] solution(int[] numbers) {
        HashSet<Integer> set = new HashSet<>();

        for(int i=0; i<numbers.length; i++) {
            for(int j=0; j<numbers.length; j++) {
                if(i==j)
                    continue;
                // 결과값 HashSet에 저장하여 중복 제거
                set.add(numbers[i] + numbers[j]);
            }
        }

        // HashSet을 int형 배열로 변환
        int[] answer = set.stream().mapToInt(i->i).sorted().toArray();

        return answer;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] numbers = {2, 1, 3, 4, 1};
        String answer = Arrays.toString(twoSum.solution(numbers));
        System.out.println(answer);
    }
}
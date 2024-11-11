package note;

import java.util.ArrayList;
import java.util.Arrays;

public class Function {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] compTime = new int[progresses.length];
        ArrayList<Integer> answerList = new ArrayList<>();

        // 각 작업이 완료되는데 걸리는 시간 계산
        for (int i = 0; i < progresses.length; i++) {
            while (progresses[i] < 100) {
                progresses[i] += speeds[i];
                compTime[i]++;
            }
        }

        int start = compTime[0];
        int count = 1;

        for (int i = 1; i < compTime.length; i++) {
            if (compTime[i] <= start)
                // 뒷 작업이 앞의 작업과 동시에 끝나거나 일찍 끝나서 기다리고 있었던 경우
                count++;
            else {
                // 뒷 작업이 앞의 작업보다 늦게 끝나는 경우
                answerList.add(count);
                count = 1;      // 배포 작업 수 초기화
                start = compTime[i]; // 새로운 기준 시간 설정
            }
        }
        // 마지막 작업이 else 조건에 속할 경우 answerList 에 포함이 안되므로 직접 포함시킴
        answerList.add(count);

        return answerList.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        Function f = new Function();
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        int[] answer = f.solution(progresses, speeds);
        System.out.println(Arrays.toString(answer)); // 예상 결과: [2, 1]
    }
}
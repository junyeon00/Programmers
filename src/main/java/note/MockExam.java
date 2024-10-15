package note;

import java.util.ArrayList;
import java.util.Arrays;

public class MockExam {

    public int[] solution(int[] answers) {
        // 1번, 2번, 3번 수포자의 답안 패턴
        int[] P1 = {1, 2, 3, 4, 5};
        int[] P2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] P3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] scores = new int[3];

        // 정답과 수포자의 답안 패턴을 비교하여 점수 저장
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == P1[i % P1.length])
                scores[0]++;
            if (answers[i] == P2[i % P2.length])
                scores[1]++;
            if (answers[i] == P3[i % P3.length])
                scores[2]++;
        }

        // 최고 점수를 찾음
        int maxScore = Math.max(scores[0], Math.max(scores[1], scores[2]));

        ArrayList<Integer> answerList = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == maxScore) {
                // 사람 번호는 1번부터 시작
                answerList.add(i + 1);
            }
        }

        // 리스트를 배열로 변환하여 반환
        return answerList.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        MockExam exam = new MockExam();
        int[] answers = {1, 2, 3, 4, 5};
        String ans = Arrays.toString(exam.solution(answers));
        System.out.println(ans);
    }
}
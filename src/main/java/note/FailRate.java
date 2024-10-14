package note;

import java.util.Arrays;
import java.util.HashMap;

public class FailRate {
     public int[] solution(int N, int[] stages) {
        int[] player = new int[N+2];
        // 스테이지 당 실패한 도전자 수 저장
        for (int i = 0; i < stages.length; i++)
            player[stages[i]]++;
        // 실패율을 int형으로 선언하면 정확한 비교를 할 수 없기 때문에 double형으로 선언
        HashMap<Integer, Double> fails = new HashMap<>();
        double total = stages.length;

        for(int i=1; i<=N; i++) {
            if(player[i] == 0)
                fails.put(i, 0.0);
            else{
                fails.put(i, player[i] / total);
                total -= player[i];
            }
        }

        // 실패율을 내림차순으로 정렬하고 배열로 변환하여 반환
        return fails.entrySet().stream().sorted((x1,x2)->Double.compare(x2.getValue(), x1.getValue()))
                .mapToInt(HashMap.Entry::getKey).toArray();
    }

    public static void main(String[] args) {
        FailRate failRate = new FailRate();
        int N = 5;
        int[] stages = {2,1,2,6,2,4,3,3};
        int[] answer = failRate.solution(N, stages);
        System.out.println(Arrays.toString(answer));
    }
}
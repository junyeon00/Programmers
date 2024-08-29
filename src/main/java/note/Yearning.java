package note;

import java.util.Arrays;
import java.util.HashMap;

public class Yearning {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];

        // 해쉬맵에 각 name과 해당 name의 그리움 점수 저장
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < name.length; i++)
            map.put(name[i], yearning[i]);

        // answer 배열의 각 인덱스에 합산된 추억 점수 저장
        for(int i=0; i<photo.length; i++){
            for(int j=0; j<photo[i].length; j++){
                if(map.containsKey(photo[i][j]))
                    answer[i] += map.get(photo[i][j]);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Yearning yearning = new Yearning();
        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearn = {5, 10, 1, 3};
        String[][] photo = {{"may", "kein", "kain", "radi"},{"may", "kein", "brin", "deny"},
                {"kon", "kain", "may", "coni"}};

        String answer = Arrays.toString(yearning.solution(name, yearn, photo));
        System.out.println(answer);
    }
}
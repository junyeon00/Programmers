package note;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Tangerine {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int box = 0; // 박스에 담긴 귤 개수

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<tangerine.length; i++)
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);

        ArrayList<Integer> values = new ArrayList<>(map.values()); // 같은 종류인 귤 각각의 개수
        Collections.sort(values, Collections.reverseOrder()); // 오름차순 정렬

        for(int v : values){
            if(box + v < k) {
                answer++;
                box += v;
            }
            else if (box == k)
                break;
            else {
                answer++;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Tangerine tang = new Tangerine();
        int k = 6;
        int[] tangerine = {1,3,2,5,4,5,2,3};
        System.out.println(tang.solution(k, tangerine));
    }
}
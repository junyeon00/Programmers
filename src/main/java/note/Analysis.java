package note;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Analysis {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        // 정답 배열을 저장할 ArrayList 생성
        ArrayList<int[]> arr = new ArrayList<>();
        // ext 를 숫자로 구분하여 HashMap 에 저장
        HashMap<String, Integer> map = new HashMap<>() {{
            put("code", 0);
            put("date", 1);
            put("maximum", 2);
            put("remain", 3);
        }};

        int criteria = map.get(ext);
        int idx = map.get(sort_by);

        // data 를 돌며 기준보다 작은 값을 갖는 인덱스들을 리스트에 추가
        for (int i = 0; i < data.length; i++){
            if (data[i][criteria] < val_ext){
                arr.add(data[i]);
            }
        }

        // 리스트 정렬
        arr.sort(Comparator.comparing(x -> x[idx]));

        return arr.toArray(int[][]::new);
    }

    public static void main(String[] args) {
        Analysis analysis = new Analysis();

        int[][] data = {{1, 20300104, 100, 80}, {2, 20300804, 847, 37}, {3, 20300401, 10, 8}};
        String ext = "date";
        int val_ext = 20300501;
        String sort_by = "remain";

        int[][] answer = analysis.solution(data, ext, val_ext, sort_by);

        for(int i = 0; i < answer.length; i++){
            String ans = Arrays.toString(answer[i]);
            System.out.println(ans);
        }
    }
}
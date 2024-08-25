package note;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class RankSearch {
    public int[] solution(String[] info, String[] query) {
        // info를 기반으로 해쉬맵 생성
        HashMap<String, ArrayList<Integer>> hashMap = new HashMap<>();

        // 각 정보가 -인 경우까지 포함해서 모든 경우의 형태를 key로 가지는 인덱스 추가
        for(String i : info){
            String[] data = i.split(" ");
            String[] languages = {data[0], "-"};
            String[] jobs = {data[1], "-"};
            String[] exps = {data[2], "-"};
            String[] foods = {data[3], "-"};
            // 성적은 Integer로 변환하고 해쉬맵의 value 값으로 설정
            Integer value = Integer.parseInt(data[4]);
            for(String lang : languages)
                for(String job : jobs)
                    for(String exp : exps)
                        for(String food : foods){
                            String[] keyData = {lang, job, exp, food};
                            String key = String.join(" ", keyData);
                            ArrayList<Integer> arr = hashMap.getOrDefault(key, new ArrayList<Integer>());

                            arr.add(value);
                            hashMap.put(key, arr);
                        }
        }

        // 각 해쉬맵의 value를 오름차순으로 정렬
        for(ArrayList<Integer> arr : hashMap.values())
            arr.sort(null);

        // query의 조건에 맞는 지원자를 가져옴
        int[] answer = new int[query.length];
        int i = 0;
        for(String q : query){
            String[] data = q.split(" and ");
            int target = Integer.parseInt(data[3].split(" ")[1]);
            data[3] = data[3].split(" ")[0];
            String key = String.join(" ", data);

            if(hashMap.containsKey(key)){
                ArrayList<Integer> list = hashMap.get(key);
                // 이진 탐색을 통해 기준값보다 큰 최소값을 찾음
                int left = 0;
                int right = list.size();
                while(left < right){
                    int mid = (left + right) / 2;
                    if(list.get(mid) >= target)
                        right = mid;
                    else
                        left = mid + 1;
                }
                answer[i] = list.size() - left;
            }
            i++;
        }
        return answer;
    }

    public static void main(String[] args) {
        RankSearch rankSearch = new RankSearch();
        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210",
                "python frontend senior chicken 150","cpp backend senior pizza 260",
                "java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100",
                "python and frontend and senior and chicken 200","cpp and - and senior and pizza 250",
                "- and backend and senior and - 150","- and - and - and chicken 100",
                "- and - and - and - 150"};

        String answer = Arrays.toString(rankSearch.solution(info, query));
        System.out.println(answer);
    }
}
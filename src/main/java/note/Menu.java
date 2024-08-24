package note;

import java.util.*;

public class Menu {

    List<String> answerList = new ArrayList<>();
    Map<String, Integer> hashMap = new HashMap<>();

    public String[] solution(String[] orders, int[] course) {
        // orders 배열의 각 인덱스 정렬
        for(int i = 0; i < orders.length; i++) {
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = String.valueOf(arr);
        }

        // 각 order 별로 course의 크기만큼의 조합 만들기
        for(int i : course){
            for(String order : orders)
                combination("", order, i);

            if(!hashMap.isEmpty()){
                // 가장 많은 조합의 수 max에 저장
                List<Integer> countList = new ArrayList<>(hashMap.values());
                int max = Collections.max(countList);

                // 가장 많은 조합 answerList에 저장
                if(max > 1)
                    for(String key : hashMap.keySet())
                        if(hashMap.get(key) == max)
                            answerList.add(key);
                // 해쉬맵 초기화 후 반복
                hashMap.clear();
            }
        }

        // answerList 정렬 후 answer 배열에 삽입
        Collections.sort(answerList);
        String[] answer = new String[answerList.size()];

        for(int i = 0; i < answer.length; i++)
            answer[i] = answerList.get(i);

        return answer;
    }

    public void combination(String order, String others, int count){
        // 탈출 조건
        if(count == 0){
            hashMap.put(order, hashMap.getOrDefault(order, 0) + 1);
            return;
        }

        for(int i = 0; i < others.length(); i++)
            combination(order+others.charAt(i), others.substring(i+1), count-1);
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};
        // solution 함수의 반환 타입이 배열 객체이므로 메모리 주소를 반환함 -> String으로 바꿔줬음
        String[] answer = menu.solution(orders, course);
        System.out.println(Arrays.toString(answer));
    }
}
package note;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

public class Privacy {
    public int[] solution(String today, String[] terms, String[] privacies) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");

        // terms에서 약관 종류를 key, 유효기간을 value로 하는 HashMap 생성
        HashMap<String, Integer> map = new HashMap<>();

        for(String term : terms) {
            String[] temp = term.split(" ");
            int duration = Integer.parseInt(temp[1]);
            map.put(temp[0], duration);
        }

        ArrayList<Integer> result = new ArrayList<>();
        LocalDate todayDate = LocalDate.parse(today, formatter);

        // privacies를 날짜와 약관으로 split
        for (int i = 0; i < privacies.length; i++) {
            String[] temp = privacies[i].split(" ");
            // 날짜를 LocalDate 타입으로 형변환
            LocalDate date = LocalDate.parse(temp[0], formatter);
            // 약관 종류에 따라 날짜에 유효기간을 더함
            int plus = map.get(temp[1]);
            date = date.plusMonths(plus);

            // 파기해야 할 개인정보인지 확인
            if (!date.isAfter(todayDate)) {  // 만료일이 오늘 이전 또는 같은 경우
                result.add(i + 1);  // 인덱스는 1부터 시작하므로 1 더함
            }
        }

        // ArrayList를 배열로 변환하여 반환
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Privacy privacy = new Privacy();

        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};

        int[] answerList = privacy.solution(today, terms, privacies);

        for (int answer : answerList) {
            System.out.println(answer);
        }
    }
}
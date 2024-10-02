package note;

import java.util.Arrays;

public class Boat {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);  // people 배열 정렬

        int lightIdx = 0;  // 가장 가벼운 사람의 인덱스
        int heavyIdx = people.length - 1;  // 가장 무거운 사람의 인덱스
        int count = 0;  // 보트 수

        while (lightIdx <= heavyIdx) {
            // 가장 가벼운 사람과 가장 무거운 사람의 무게가 limit 이하면 둘다 제외
            if (people[lightIdx] + people[heavyIdx] <= limit)
                lightIdx++;  // 가벼운 사람 태움
            // 무거운 사람은 무조건 태워야 하므로 무거운 사람 인덱스만 감소시킴
            heavyIdx--;

            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        Boat boat = new Boat();
        int[] people = {70, 80, 50};
        int limit = 100;
        System.out.println(boat.solution(people, limit));
    }
}
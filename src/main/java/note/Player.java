package note;

import java.util.HashMap;

class Player {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        // 해쉬맵 생성
        HashMap<String, Integer> map = new HashMap<>();

        // 해쉬맵에 participant 삽입 (key는 선수이름, value는 중복없을시 1 중복되면 1씩 추가)
        for (String player : participant)
            map.put(player, map.getOrDefault(player, 0) + 1);

        // 해쉬맵에서 completion된 선수가 key인 인덱스의 value 1 빼기
        for (String player : completion)
            map.put(player, map.get(player) - 1);

        for (String key : map.keySet()){
            if (map.get(key) != 0) {
                answer = key;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] participant = {"A", "B", "C", "D"};
        String[] completion = {"A", "B", "C"};
        Player player = new Player();
        System.out.println(player.solution(participant, completion));
    }
}

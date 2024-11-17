package note;

import java.util.HashMap;

public class OpenChat {
    public String[] solution(String[] record) {
        // record에서 아이디를 key, 닉네임을 value로 하는 해쉬맵 생성
        HashMap<String, String> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < record.length; i++) {
            String[] parts = record[i].split(" ");  // 공백을 기준으로 split하여 각 부분을 분리
            String action = parts[0];  // Enter, Leave, Change
            String userId = parts[1];  // 아이디

            if (action.equals("Enter") || action.equals("Change")) {
                String nickname = parts[2];  // 닉네임
                map.put(userId, nickname);
            }
        }

        for (int i = 0; i < record.length; i++) {
            String[] parts = record[i].split(" ");
            String action = parts[0];
            String userId = parts[1];

            if (action.equals("Enter"))
                sb.append(map.get(userId) + "님이 들어왔습니다.");
            else if (action.equals("Leave"))
                sb.append(map.get(userId) + "님이 나갔습니다.");
        }

        return sb.toString().split("\\.");
    }

    public static void main(String[] args) {
        OpenChat openChat = new OpenChat();
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234",
                "Enter uid1234 Prodo","Change uid4567 Ryan"};
        String[] answer = openChat.solution(record);
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }
}
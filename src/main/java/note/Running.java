package note;

import java.util.Arrays;
import java.util.HashMap;

public class Running {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        // 해쉬맵에 초기 순위 저장
        HashMap<String, Integer> rank = new HashMap<>();
        for(int i = 0; i < players.length; i++)
            rank.put(players[i], i);

        // 이기면 player 순위 1 업, 원래 그 순위에 있던 playersms 1 다운
        for(String s : callings){
            int winIdx = rank.get(s);
            String winner = players[winIdx];
            String loser = players[winIdx-1];
            players[winIdx] = loser;
            players[winIdx-1] = winner;

            // 해쉬맵에 바뀐 순위 반영
            rank.put(winner, rank.get(winner)-1);
            rank.put(loser, rank.get(loser)+1);
        }

        for(String ans : rank.keySet())
            answer[rank.get(ans)] = ans;

        return answer;
    }

    public static void main(String[] args) {
        Running run = new Running();
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};
        String answer = Arrays.toString(run.solution(players, callings));
        System.out.println(answer);
    }
}
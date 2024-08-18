package note;

import java.util.Arrays;

class Player {
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);

        int i = 0;
        for(; i < completion.length; i++)
            if (!participant[i].equals(completion[i]))
                break;

        return participant[i];
    }

    public static void main(String[] args) {
        String[] participant = {"A", "B", "C", "D"};
        String[] completion = {"A", "B", "C"};
        Player player = new Player();
        System.out.println(player.solution(participant, completion));
    }
}

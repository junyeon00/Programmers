package note;

public class Card {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        int c1 = 0;
        int c2 = 0;

        // goal 의 해당 인덱스와 일치하는 문자가 있는 배열은 순서를 다음 인덱스로 이동하여 이어가며 비교
        for (int i = 0; i < goal.length; i++) {
            if (c1 < cards1.length && cards1[c1].equals(goal[i])) {
                c1++;
            } else if (c2 < cards2.length && cards2[c2].equals(goal[i])) {
                c2++;
            } else {
                answer = "No";
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Card card = new Card();
        String[] card1 = {"i", "drink", "water"};
        String[] card2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"};
        System.out.println(card.solution(card1, card2, goal));
    }
}
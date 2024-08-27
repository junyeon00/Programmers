package note;

public class KeyPad {

    Position left;
    Position right;
    Position numPos;

    public String solution(int[] numbers, String hand) {
        // 4x3 배열로 풀이 -> 이차원 배열
        //1   2   3
        //4   5   6
        //7   8   9
        //*   0   #
        String answer = "";
        // 왼손, 오른손 위치 초기화
        left = new Position(3, 0);
        right = new Position(3, 2);

        for(int num : numbers) {
            // 숫자를 누를 손 지정
            numPos = new Position((num-1)/3, (num-1)%3);
            if(num==0)
                numPos = new Position(3, 1);

            String finger = numPos.getFinger(hand);

            // 정해진 손을 answer 배열에 담고 위치 최신화
            answer += finger;
            if(finger.equals("L"))
                left = numPos;
            else
                right = numPos;
        }

        return answer;
    }

    // 최신화된 손 위치를 나타내는 클래스
    class Position{
        int row;
        int col;

        Position(int row, int col){
            this.row = row;
            this.col = col;
        }

        public String getFinger(String hand) {
            String finger = hand.equals("right") ? "R" : "L";

            if(this.col == 0)
                finger = "L";
            else if(this.col == 2)
                finger = "R";
            else{
                int leftDist = left.getDistance(this);
                int rightDist = right.getDistance(this);

                if (leftDist < rightDist)
                    finger = "L";
                else if (rightDist < leftDist)
                    finger = "R";
            }

            return finger;
        }

        public int getDistance(Position p) {
            return Math.abs(this.row - p.row) + Math.abs(this.col - p.col);
        }
    }

    public static void main(String[] args) {
        KeyPad keyPad = new KeyPad();
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        System.out.println(keyPad.solution(numbers, hand));
    }
}
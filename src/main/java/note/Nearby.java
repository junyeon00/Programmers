package note;

public class Nearby {
    public int solution(String[][] board, int h, int w) {
        int n = board.length;
        int count = 0;
        // 오른쪽, 아래쪽, 위쪽, 왼
        int[] dh = {0, 1, -1, 0};
        int[] dw = {1, 0, 0, -1};

        // 상하좌우에 같은 색이 있는지 확인
        for(int i =0; i<4; i++) {
            int h_check = h + dh[i];
            int w_check = w + dw[i];

            if(h_check >= 0 && h_check < n && w_check >= 0 && w_check < n) {
                // 같은 색이 있으면 count 1 증가
                if(board[h][w].equals(board[h_check][w_check])) {
                    count ++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Nearby nearby = new Nearby();
        String[][] board = {{"blue", "red", "orange", "red"}, {"red", "red", "blue", "orange"},
                {"blue", "orange", "red", "red"}, {"orange", "orange", "red", "blue"}};
        int h = 1;
        int w = 1;
        System.out.println(nearby.solution(board, h, w));
    }
}
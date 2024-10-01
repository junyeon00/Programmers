package note;

import java.util.HashMap;
import java.util.Stack;

public class DollCrane {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int lineNum = 0;

        // 스택 활용
        Stack<Integer> basket = new Stack<>(); // 바구니
        HashMap<Integer, Stack<Integer>> map = new HashMap<>();

        // 각 열을 스택으로 하여 HashMap에 열번호를 key로 하고 스택을 value로 하여 저장
        for(int i = 0; i < board.length; i++) {
            Stack<Integer> line = new Stack<>();
            for(int j = board.length - 1; j >= 0; j--)
                // 0은 인형이 없는 경우이므로 스택에 넣지 않음
                if(board[j][lineNum] != 0)
                    line.push(board[j][lineNum]);
            lineNum++;
            map.put(i+1, line);
        }

        for(int i = 0; i < moves.length; i++) {
            if(basket.size() >= 2) {
                int size = basket.size();

                // basket 크기가 2보다 크거나 같을때 basket의 맨위와 그 다음 인덱스 비교
                if(basket.get(size - 1) == basket.get(size - 2)) {
                    basket.pop();
                    basket.pop();
                    answer += 2;
                }
            }
            if(map.keySet().contains(moves[i]) && !map.get(moves[i]).isEmpty())
                basket.add(map.get(moves[i]).pop());
        }

        return answer;
    }

    public static void main(String[] args) {
        DollCrane dollCrane = new DollCrane();
        int[][] board = {{0,0,0,0,0}, {0,0,1,0,3}, {0,2,5,0,1}, {4,2,4,4,2}, {3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        System.out.println(dollCrane.solution(board, moves));
    }
}
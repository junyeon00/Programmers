package note;

import java.util.*;

public class GraphEdit {
    public String solution(int n, int k, String[] cmd) {
        Stack<Integer> deleted = new Stack<>(); // 삭제된 인덱스들 저장
        int head = k; // 현재 위치를 가리키는 변수

        HashMap<Integer, Boolean> activeRows = new HashMap<>(); // 각 인덱스의 활성 상태 추적
        for (int i = 0; i < n; i++)
            activeRows.put(i, true);

        for (String command : cmd) {
            char action = command.charAt(0);

            if (action == 'U') {
                int count = Integer.parseInt(command.substring(2));
                for (int i = 0; i < count; i++) {
                    head--;
                    while (!activeRows.get(head))
                        head--; // 비활성화된 행은 건너뜀
                }
            } else if (action == 'D') {
                int count = Integer.parseInt(command.substring(2));
                for (int i = 0; i < count; i++) {
                    head++;
                    while (!activeRows.get(head)) head++; // 비활성화된 행은 건너뜀
                }
            } else if (action == 'C') {
                deleted.push(head); // 삭제된 행 스택에 저장
                activeRows.put(head, false); // 현재 행 비활성화
                // 아래 행이 없으면 위로 이동
                head = (head == n - 1) ? head - 1 : head + 1;
            } else if (action == 'Z') {
                int restoreIdx = deleted.pop(); // 복구할 행 인덱스
                activeRows.put(restoreIdx, true); // 해당 행 활성화
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            result.append(activeRows.get(i) ? "O" : "X"); // true면 O 삽입, false면 X 삽입
        }

        return result.toString();
    }

    public static void main(String[] args) {
        GraphEdit graphEdit = new GraphEdit();
        int n = 8;
        int k = 2;
        String[] cmd = {"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"};
        System.out.println(graphEdit.solution(n, k, cmd));
    }
}
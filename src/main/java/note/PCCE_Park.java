package note;

import java.util.Arrays;

public class PCCE_Park {
    public int solution(int[] mats, String[][] park) {
        // mats 배열을 내림차순으로 정렬
        Arrays.sort(mats);
        for (int i = 0; i < mats.length / 2; i++) {
            int temp = mats[i];
            mats[i] = mats[mats.length - 1 - i];
            mats[mats.length - 1 - i] = temp;
        }

        // 매트를 배치할 수 있는 가장 큰 크기를 찾기
        for (int mat : mats) {
            // 공원의 모든 가능한 시작 위치를 탐색
            for (int i = 0; i <= park.length - mat; i++) {
                for (int j = 0; j <= park[0].length - mat; j++) {
                    // 배치할 수 있는 가장 큰 매트 반환
                    if (canPlaceMat(park, i, j, mat))
                        return mat;
                }
            }
        }
        return -1;
    }

    // 매트를 배치할 수 있는지 확인하는 메서드
    private boolean canPlaceMat(String[][] park, int startX, int startY, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!park[startX + i][startY + j].equals("-1"))
                    return false; // 매트 크기 내에 "-1"이 아닌 부분이 있으면 배치 불가
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PCCE_Park pcce = new PCCE_Park();
        int[] mats = {5, 3, 2};
        String[][] park = {
                {"A", "A", "-1", "B", "B", "B", "B", "-1"},
                {"A", "A", "-1", "B", "B", "B", "B", "-1"},
                {"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1"},
                {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"},
                {"D", "D", "-1", "-1", "-1", "-1", "-1", "F"},
                {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"}
        };
        System.out.println(pcce.solution(mats, park)); // 결과 출력
    }
}
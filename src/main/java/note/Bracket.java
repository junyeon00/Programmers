package note;

public class Bracket {
    int count = 0;
    int players = 0;

    public int solution(int n, int a, int b)
    {
        players = n;

        stage(a, b);

        return count;
    }

    void stage(int a, int b){
        // 재귀함수 종료 조건
        if(a == b)
            return;

        // a와 b를 반으로 나눔 (짝수, 홀수 모두 적용)
        a = (a + 1) / 2;
        b = (b + 1) / 2;
        // 라운드 1 증가
        count++;

        stage(a, b);  // 재귀 호출로 다음 라운드 계산
    }

    public static void main(String[] args) {
        Bracket bracket = new Bracket();
        int n = 8;
        int a = 4;
        int b = 7;
        System.out.println(bracket.solution(n, a, b));  // 출력: 3
    }
}
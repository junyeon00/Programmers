package note;

public class Longjump {
    public long solution(int n) {
        // 피보나치 수열 활용

        if (n == 1)
            return 1;  // 1칸은 방법 1개
        if (n == 2)
            return 2;  // 2칸은 방법 2개

        long[] dp = new long[n+1];  // 각 칸에 도달하는 방법의 수를 저장할 배열
        dp[1] = 1;  // 1칸에 도달하는 방법은 1가지
        dp[2] = 2;  // 2칸에 도달하는 방법은 2가지

        // 해당 칸-1, 해당 칸-2번째 칸까지 가는 방법의 개수 찾아서 더함
        for (int i = 3; i <= n; i++) {
            // dp[i-1]은 해당 칸까지 한번 점프, dp[i-2]는 두번 점프
            dp[i] = dp[i-1] + dp[i-2];
        }

        // n칸에 도달하는 방법 수 반환
        return dp[n]/1234567;
    }

    public static void main(String[] args) {
        Longjump jump = new Longjump();
        int n = 3;
        System.out.println(jump.solution(n));
    }
}
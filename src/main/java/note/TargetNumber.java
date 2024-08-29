package note;

public class TargetNumber {
    int[] numbers;
    int target;
    int answer;

    void dfs(int index, int sum){
        // numbers 배열을 전부 돌면 탈출
        if(index == numbers.length){
            if(sum == target)
                answer++; // 탈출하기 전에 target과 sum이 일치하면 answer 1 증가
            return;
        }

        // 덧셈 경우, 뺄셈 경우 재귀
        dfs(index+1, sum + numbers[index]);
        dfs(index+1, sum - numbers[index]);
    }

    public int solution(int[] numbers, int target) {
        answer = 0;
        this.numbers = numbers;
        this.target = target;

        dfs(0, 0);

        return answer;
    }

    public static void main(String[] args) {
        TargetNumber targetNumber = new TargetNumber();
        int[] numbers = {4, 1, 2, 1};
        int target = 4;
        System.out.println(targetNumber.solution(numbers, target));
    }
}
package note;

public class OverCoating {
    public int solution(int n, int m, int[] section) {
        int answer = 1;
        int start = section[0];
        int end = start + m - 1;

        for(int i=1; i<section.length; i++) {
            // 해당 구역이 end 보다 작거나 같으면 통과
            if(section[i] <= end)
                continue;
            // 해당 구역이 end 보다 크면 answer 1 증가 후 시작지점, 끝지점 수정
            answer++;
            start = section[i];
            end = start + m - 1;
        }

        return answer;
    }

    public static void main(String[] args) {
        OverCoating overcoat = new OverCoating();
        int n = 8;
        int m = 3;
        int[] section = {1, 3, 5};
        System.out.println(overcoat.solution(n, m, section));
    }
}
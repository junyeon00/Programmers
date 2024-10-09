package note;

public class Fatigability {
    boolean[] visited;
    int answer = 0;

    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        recursive(0, k, dungeons);

        return answer;
    }

    void recursive(int curr, int remain, int[][] dungeon) {
        for(int i = 0; i < dungeon.length; i++) {
            // 이미 방문했거나 피로도가 부족하면 continue
            if(visited[i] || remain-dungeon[i][0] < 0)
                continue;
            // 방문 여부 true로 설정
            visited[i] = true;
            int cost = dungeon[i][1]; // 소모 피로도
            // 해당 던전을 시작점으로 하는 경로 탐색
            recursive(curr+1, remain-cost, dungeon);
            // 다른 경로도 탐색하기 위해 방문 여부 false로 다시 설정
            visited[i] = false;
        }
        // 각각의 경로 중 가장 큰 값 answer에 저장
        answer = Math.max(answer, curr);
    }

    public static void main(String[] args) {
        Fatigability f = new Fatigability();
        int k = 80;
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};
        System.out.println(f.solution(k, dungeons));
    }
}
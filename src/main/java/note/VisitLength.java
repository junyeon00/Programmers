package note;

import java.util.HashMap;
import java.util.HashSet;

public class VisitLength {
    private static boolean isValidMove(int nx, int ny){
        return 0 <= nx && nx < 11 && 0 <= ny && ny < 11;
    }

    private static final HashMap<Character, int[]> location = new HashMap<>();

    private static void initLocation(){
        location.put('U', new int[]{0, 1});
        location.put('D', new int[]{0, -1});
        location.put('L', new int[]{-1, 0});
        location.put('R', new int[]{1, 0});
    }

    public int solution(String dirs) {
        initLocation();
        int x = 5; int y = 5;
        HashSet<String> answer = new HashSet<>();
        for(int i=0; i<dirs.length(); i++){
            int[] offset = location.get(dirs.charAt(i));
            int nx = x + offset[0];
            int ny = y + offset[1];
            // 유효 범위를 벗어나면 제외
            if(!isValidMove(nx, ny))
                continue;
            // 가는 동선, 오는 동선 각각 두 개 저장
            answer.add(x + " " + y + " " + nx + " " + ny);
            answer.add(nx + " " + ny + " " + x + " " + y);

            // 현재 위치 업데이트
            x = nx;
            y = ny;
        }
        // 한번 위치 변경할 때 두개의 동선 저장했으니 나누기 2
        return answer.size() / 2;
    }

    public static void main(String[] args) {
        VisitLength visit = new VisitLength();
        String dirs = "ULURRDLLU";
        System.out.println(visit.solution(dirs));
    }
}
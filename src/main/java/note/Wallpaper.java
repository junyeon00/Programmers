package note;

import java.util.Arrays;

public class Wallpaper {
    public int[] solution(String[] wallpaper) {
        // 시작점은 x, y에 대한 최솟값, 끝지점은 x, y에 대한 최댓값+1
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;


        for(int i = 0; i < wallpaper.length; i++) {
            for(int j = 0; j < wallpaper[i].length(); j++) {
                if(wallpaper[i].charAt(j) == '#') {
                    minX = Math.min(i, minX);
                    minY = Math.min(j, minY);
                    maxX = Math.max(i+1, maxX);
                    maxY = Math.max(j+1, maxY);
                }
            }
        }

        int[] answer = {minX, minY, maxX, maxY};

        return answer;
    }

    public static void main(String[] args) {
        Wallpaper wallpaper = new Wallpaper();
        String[] file = {".#...", "..#..", "...#."};
        String answer = Arrays.toString(wallpaper.solution(file));
        System.out.println(answer);
    }
}
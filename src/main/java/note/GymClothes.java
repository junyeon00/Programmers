package note;

import java.util.HashSet;

public class GymClothes {
    public int solution(int n, int[] lost, int[] reserve) {
        // HashSet 생성
        HashSet<Integer> resSet = new HashSet<>();
        HashSet<Integer> lostSet = new HashSet<>();

        for(int i : reserve)
            resSet.add(i);
        for(int i : lost){ // 여분이 있는데 도둑 맞은 학생 예외 처리
            if(resSet.contains(i))
                resSet.remove(i);
            else
                lostSet.add(i);
        }

        // 여분을 기준으로 앞뒤로 확인하여 체육복을 나눠줌
        for(int i : resSet){
            if(lostSet.contains(i-1))
                lostSet.remove(i-1);

            else if(lostSet.contains(i+1))
                lostSet.remove(i+1);
        }

        // 전체 학생 수에서 lost에 남은 학생 수를 빼줌
        return n - lostSet.size();
    }

    public static void main(String[] args) {
        GymClothes sol = new GymClothes();
        int [] lost = {2, 4};
        int [] reserve = {1, 3, 5};
        System.out.println(sol.solution(5, lost, reserve));
    }
}

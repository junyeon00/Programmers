package note;

public class GymClothes {
    public int solution(int n, int[] lost, int[] reserve) {
        // 총괄 배열 생성
        int []student = new int[n+2];
        int answer = 0;

        // 0으로 초기화된 student 배열에 여분 여부 반영 lost면 -1, res면 +1
        for(int l : lost)
            student[l]--;
        for(int r : reserve)
            student[r]++;

        // 여분을 기준으로 앞뒤 확인
        for(int i=1; i<n+1; i++){
            if(student[i] == 1){
                if(student[i-1] == -1){
                    student[i]--;
                    student[i-1]++;
                }
                else if(student[i+1] == -1){
                    student[i]--;
                    student[i+1]++;
                }
            }
        }

        // student 배열 확인 후 인덱스값이 0보다 큰지 확인 -> 체육복이 있는지 확인
        for(int i=1; i<n+1; i++)
            if(student[i] >= 0)
                answer++;

        return answer;
    }

    public static void main(String[] args) {
        GymClothes sol = new GymClothes();
        int [] lost = {2, 4};
        int [] reserve = {1, 3, 5};
        System.out.println(sol.solution(5, lost, reserve));
    }
}

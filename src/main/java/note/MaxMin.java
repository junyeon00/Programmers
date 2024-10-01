package note;

public class MaxMin {
    public String solution(String s) {
        String[] arr = s.split(" ");
        int min = Integer.parseInt(arr[0]);
        int max = min;

        for (int i = 1; i < arr.length; i++){
            int num = Integer.parseInt(arr[i]);
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        String answer = min + " " + max;

        return answer;
    }

    public static void main(String[] args) {
        MaxMin maxMin = new MaxMin();
        String s = "1 2 3 4";
        System.out.println(maxMin.solution(s));
    }
}
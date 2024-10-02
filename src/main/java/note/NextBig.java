package note;

public class NextBig {
    public int solution(int n) {
        int min = n+1;
        int one1 = Integer.bitCount(n); // n을 이진수로 바꿨을 때 1의 개수
        int one2 = Integer.bitCount(min); // n+1을 이진수로 바꿨을 때 1의 개수

        while(one1 != one2) {
            min += 1;
            one2 = Integer.bitCount(min);
        }

        return min;
    }


    public static void main(String[] args) {
        NextBig nextBig = new NextBig();
        System.out.println(nextBig.solution(78));
    }
}
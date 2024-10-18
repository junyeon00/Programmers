package note;

import java.util.Stack;

public class Decimal {
    public static String solution(int decimal){
        Stack<Integer> stack = new Stack<>();
        String answer = "";

        while(decimal > 0){
            int temp = decimal % 2;
            stack.push(temp);
            decimal = decimal / 2;
        }

        while(!stack.isEmpty())
            answer += Integer.toString(stack.pop());

        return answer;
    }

    public static void main(String[] args) {
        Decimal decimal = new Decimal();
        String answer = decimal.solution(12345);
        System.out.println(answer);
    }
}
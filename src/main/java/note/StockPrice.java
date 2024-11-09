package note;

import java.util.Arrays;

public class StockPrice {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for(int i = 0; i < prices.length; i++) {
            int count = 0;
            for(int j = i + 1; j < prices.length; j++) {
                count++;
                if(prices[i] > prices[j]) {
                    break;  // 가격이 떨어지면 바로 종료
                }
            }
            answer[i] = count;
        }

        return answer;
    }

    public static void main(String[] args) {
        StockPrice stockPrice = new StockPrice();
        int[] prices = {1,2,3,2,3};
        String answer = Arrays.toString(stockPrice.solution(prices));
        System.out.println(answer);
    }
}
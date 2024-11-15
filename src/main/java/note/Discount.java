package note;

public class Discount {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        for (int i = 0; i <= discount.length - 10; i++) {
            int[] count = new int[want.length];

            // 현재부터 10일 간의 할인 항목 확인
            for (int j = i; j < i + 10; j++) {
                for (int k = 0; k < want.length; k++) {
                    if (discount[j].equals(want[k])) {
                        count[k]++;
                    }
                }
            }

            // 모든 want 수가 number 보다 큰지 확인
            boolean state = true;
            for (int k = 0; k < want.length; k++) {
                if (count[k] < number[k]) {
                    state = false;
                    break;
                }
            }

            if (state)
                answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Discount d = new Discount();
        String[] want = {"banana","apple","rice","pork","pot"};
        int[] number = {3,2,2,2,1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork",
                "banana", "pork", "rice", "pot", "banana", "apple", "banana"};

        System.out.println(d.solution(want, number, discount));
    }
}
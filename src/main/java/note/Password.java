package note;

public class Password {
    public String solution(String s, String skip, int index) {
        String answer = "";

        for(int i = 0; i < s.length(); i++) {
            // s에서 한 문자씩 가져온다
            char a = s.charAt(i);
            // index의 범위 안을 반복하며 skip에 포함되는지 확인
            for(int j = 0; j < index; j++) {
                a = (char)(a + 1);
                // skip은 String 타입이기 때문에 char 타입인 a에 공백문자를 더해 비교 가능한 상태로 바꿔줌
                if(skip.contains(a+""))
                    j--;
                if((int)a > 122) {
                    a -= 26;
                    if(skip.contains(a+""))
                        j--;
                }
            }
            answer += a;
        }

        return answer;
    }

    public static void main(String[] args) {
        Password p = new Password();
        String s = "aukks";
        String skip = "wbqd";
        int index = 5;
        System.out.println(p.solution(s, skip, index));
    }
}
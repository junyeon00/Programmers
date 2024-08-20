package note;

public class NewID {
    // 실행 결과 -> 시간 효율성 테스트 통과 실패..! 런타임 에러
    public String solution(String new_id) {
        String answer = "";
        // 소문자로 변경
        new_id = new_id.toLowerCase();

        // 예외문자 제거 (소문자, 숫자, 빼, 밑줄, 마침표 제외)
        answer = new_id.replaceAll("[^a-z0-9-_.]", "");

        // 마침표가 연속적으로 나오면 하나만 추가
        answer = answer.replaceAll("\\.+", "."); // \을 문자로 표현하려면 두번 입력해줘야함

        // 마침표가 처음이나 끝에 존재하면 제거
        answer = answer.replaceAll("^[.]|[.]$", "");

        // new_id가 공백이라면 a를 대입
        if(answer.isEmpty())
            answer = "a";

        // 길이가 16자 이상이면 15자까지만 잘라서 씀
        if(answer.length() >= 16) {
            answer = answer.substring(0, 15);
            answer = answer.replaceAll("[.]$", "");
        }

        // answer가 2자 이하이면 마지막 문자를 반복하여 3자로 만듦
        while(answer.length() < 3)
            if(answer.length() <= 2)
                answer += answer.charAt(answer.length() - 1);

        return answer;
    }

    public static void main(String[] args) {
        NewID newID = new NewID();
        System.out.println(newID.solution("...!@BaT#*..y.abcdefghijklm"));
    }
}

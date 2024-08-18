package note;

import java.util.Arrays;

class PhoneBook {
    public boolean solution(String[] phone_book) {
        // phone_book 배열 정렬
        Arrays.sort(phone_book);

        // 앞번호가 뒷번호의 접두어인지 확인
        for (int i = 0 ; i < phone_book.length - 1 ; i++)
            if (phone_book[i+1].startsWith(phone_book[i]))
                return false;

        // 반복문에서 반환이 안됐다는 것은 접두어가 없다는 것 -> true 반환
        return true;
    }

    public static void main(String[] args) {
        String[] phone_book = {"119", "97654", "1192324"};
        // 119가 1192324의 접두어이므로 false 반환
        PhoneBook pb = new PhoneBook();
        System.out.println(pb.solution(phone_book));
    }
}

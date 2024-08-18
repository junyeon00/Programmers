package note;

import java.util.HashMap;

class PhoneBook {
    public boolean solution(String[] phone_book) {
        // phone_book 해쉬맵을 생성
        HashMap<String, Integer> map = new HashMap<>();
        for (String i : phone_book)
            map.put(i, 1);

        // 각 전화번호의 접두어가 해쉬맵에 있는지 확인
        // phone_book의 모든 인덱스를 돌며 각 인덱스의 0,1 .. j번째까지의 번호가 해쉬맵에 포함돼있는지 확인
        for (int i = 0; i < phone_book.length; i++)
            for (int j = 1; j < phone_book[i].length(); j++)
                if (map.containsKey(phone_book[i].substring(0, j)))
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

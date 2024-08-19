package note;

import java.util.HashSet;
import java.util.Iterator;

class PrimeNumber {
    private HashSet<Integer> numberSet = new HashSet<>();

    // 에라토스테네스의 체 : 해당 숫자가 소수인지 판별하기 위해서는 그 숫자의 제곱근까지만 확인해보면 된다.
    // ex) 71 -> 8까지만 확인해보면 됨
    public boolean isPrime(int num) {
        // 0과 1은 소수가 아님
        if (num == 0 || num == 1)
            return false;

        int limit = (int) Math.sqrt(num);

        for (int i = 2; i <= limit; i++)
            if (num % i == 0)
                return false;

        return true;
    }

    public void recursive(String comb, String others){ // comb: 조합된 숫자, others: 조합되지 않은 숫자
        // 현재 조합 HashSet에 추가
        if (!comb.isEmpty())
            numberSet.add(Integer.valueOf(comb));

        // 남은 숫자 중 한개를 더해서 새로운 조합 만듦
        for (int i = 0; i < others.length(); i++)
            recursive(comb + others.charAt(i), others.substring(0, i) + others.substring(i + 1));
    }

    public int solution(String numbers) {
        int count = 0;

        // 주어진 숫자를 활용해 모든 숫자 조합을 만듦
        recursive("", numbers);

        // 만들어진 조합 중 소수의 개수만 셈
        Iterator<Integer> it = numberSet.iterator();
        while (it.hasNext()) {
            int number = it.next();
            if (isPrime(number))
                count++;
        }

        // 소수의 개수 반환
        return count;
    }

    public static void main(String[] args) {
        PrimeNumber primeNumber = new PrimeNumber();
        System.out.println(primeNumber.solution("17"));
    }
}

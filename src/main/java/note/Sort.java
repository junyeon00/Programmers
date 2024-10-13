package note;

import java.util.*;

public class Sort {
    public int[] solution(int[] A) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < A.length; i++)
            set.add(A[i]);

        List<Integer> list = new ArrayList<>(set);

        int[] array = list.stream().mapToInt(Integer::intValue).toArray();

        return Arrays.stream(array).boxed().sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Sort sort = new Sort();
        int[] A = {2,1,1,3,2,5,4};
        String answer = Arrays.toString(sort.solution(A));
        System.out.println(answer);
    }
}
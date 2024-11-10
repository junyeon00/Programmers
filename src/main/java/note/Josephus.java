package note;

import java.util.ArrayDeque;
import java.util.Queue;

public class Josephus {
    public int solution(int N, int K) {
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < N; i++)
            queue.add(i+1);

        while (queue.size() > 1) {
            for(int i = 0; i < K-1; i++)
                queue.add(queue.poll());
            queue.poll();
        }

        return queue.poll();
    }

    public static void main(String[] args) {
        Josephus j = new Josephus();
        System.out.println(j.solution(5, 3));
    }
}

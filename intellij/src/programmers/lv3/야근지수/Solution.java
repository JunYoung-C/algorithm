package programmers.lv3.야근지수;

import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pQ = new PriorityQueue<>((a, b) ->  b - a);

        for (int w : works) {
            pQ.offer(w);
        }

        while (!pQ.isEmpty() && n > 0) {
            int current = pQ.poll();
            int dif = 1;
            if (pQ.isEmpty()) {
                dif = current;
            } else {
                dif = Math.max(dif, current - pQ.peek());
            }

            current -= Math.min(dif, n);
            if (current != 0) {
                pQ.offer(current);
            }
            n -= dif;
        }

        for (int num : pQ) {
            answer += num * num;
        }
        return answer;
    }
}


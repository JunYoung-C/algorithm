package programmers.lv2.더맵게;

import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pQ = new PriorityQueue<>();

        for (int num : scoville) {
            pQ.offer(num);
        }

        while (pQ.size() >= 2) {
            int firstFood = pQ.poll();
            int secondFood = pQ.poll();

            pQ.offer(firstFood + secondFood * 2);
            answer++;

            if (pQ.peek() >= K) {
                return answer;
            }
        }

        return -1;
    }
}

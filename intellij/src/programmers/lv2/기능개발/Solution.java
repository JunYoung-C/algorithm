package programmers.lv2.기능개발;

import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        int len = progresses.length;
        Queue<Integer> que = new LinkedList<>();

        for (int i = 0; i < len; i++) {
            int remain = 100 - progresses[i];
            que.offer(remain / speeds[i] + (remain % speeds[i] == 0 ? 0 : 1));
        }

        ArrayList<Integer> deploy = new ArrayList<>();
        int max = que.poll();
        int count = 1;
        while (!que.isEmpty()) {
            int now = que.poll();
            if (now > max) {
                max = now;
                deploy.add(count);
                count = 1;
                continue;
            }

            count++;
        }
        deploy.add(count);

        len = deploy.size();
        answer = new int[len];
        for (int i = 0; i < len; i++) {
            answer[i] = deploy.get(i);
        }
        return answer;
    }
}

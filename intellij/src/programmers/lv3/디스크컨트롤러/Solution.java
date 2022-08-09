package programmers.lv3.디스크컨트롤러;

import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        PriorityQueue<Job> pQ = new PriorityQueue();
        Arrays.sort(jobs, (o1, o2) -> {
            return o1[0] - o2[0];
        });

        int currentTime = jobs[0][0];
        int index = 0;
        while (index < jobs.length) {
            // System.out.println(index + " " + currentTime);
            if (currentTime >= jobs[index][0]) {
                pQ.offer(new Job(jobs[index][0], jobs[index][1]));
                index++;
                // System.out.println(pQ.size());
                continue;
            }

            Job job = pQ.poll();
            currentTime += job.needTime;
            answer += currentTime - job.requestTime;

            if (pQ.isEmpty()) {
                currentTime = Math.max(currentTime, jobs[index][0]);
            }
        }
        // System.out.println();

        while (!pQ.isEmpty()) {
            Job job = pQ.poll();
            currentTime += job.needTime;
            answer += currentTime - job.requestTime;
            // System.out.println(currentTime);
        }
        // System.out.println(answer);
        return answer / jobs.length;
    }
}

class Job implements Comparable<Job> {
    int requestTime;
    int needTime;

    public Job(int requestTime, int needTime) {
        this.requestTime = requestTime;
        this.needTime = needTime;
    }

    @Override
    public int compareTo(Job o) {
        return this.needTime - o.needTime;
    }
}


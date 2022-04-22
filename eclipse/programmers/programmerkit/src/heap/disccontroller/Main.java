package heap.disccontroller;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Job implements Comparable<Job> {
  int requestTime;
  int spentTime;

  public Job(int requestTime, int spentTime) {
    super();
    this.requestTime = requestTime;
    this.spentTime = spentTime;
  }

  @Override
  public int compareTo(Job o) {
    return this.spentTime - o.spentTime;
  }
}


class Solution {
  public int solution(int[][] jobs) {
    int answer = 0;
    int crntTime = 0;
    int idx = 0;
    int len = jobs.length;
    PriorityQueue<Job> pQ = new PriorityQueue<>();

    Arrays.sort(jobs, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[0] - o2[0];
      }
    });

    for (; crntTime <= jobs[len - 1][0]; crntTime++) {
      for (; idx < len; idx++) {
        int requestTime = jobs[idx][0];
        int spentTime = jobs[idx][1];

        if (requestTime <= crntTime) {
          pQ.offer(new Job(requestTime, spentTime));
        } else {
          break;
        }
      }

      while (!pQ.isEmpty()) {
        Job nowJob = pQ.poll();
        crntTime += nowJob.spentTime;
        answer += crntTime - nowJob.requestTime;

        // 한 작업이 수행되는 동안 시작될 수 있는 작업을 우선순위큐에 삽입
        for (; idx < len; idx++) {
          int requestTime = jobs[idx][0];
          int spentTime = jobs[idx][1];

          if (requestTime <= crntTime) {
            pQ.offer(new Job(requestTime, spentTime));
          } else {
            break;
          }
        }
      }
    }

    return answer / len;
  }
}


public class Main {
  public static void main(String[] args) {
    Solution T = new Solution();
    Scanner stdIn = new Scanner(System.in);

    // int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
    int[][] jobs = {{0, 3}, {1, 9}, {13, 6}};


    System.out.println(T.solution(jobs));
  }
}

package heap.doublepriorityque;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

class Solution {
  public int[] solution(String[] operations) {
    int[] answer = new int[2]; // 최대값, 최소값
    PriorityQueue<Integer> ascPq = new PriorityQueue<>();
    PriorityQueue<Integer> descPq = new PriorityQueue<>(Collections.reverseOrder());

    for (String oper : operations) {
      String[] tmp = oper.split(" ");
      String command = tmp[0];
      int data = Integer.parseInt(tmp[1]);

      if (command.equals("I")) { // 삽입
        ascPq.offer(data);
        descPq.offer(data);
      } else if (!ascPq.isEmpty()){ // 삭제
        if (data == 1) { // 최댓값 삭제
          int max =  descPq.poll();
          descPq.remove(max);
          ascPq.remove(max);
        } else if (data == -1) { // 최솟값 삭제
          int min = ascPq.poll();
          ascPq.remove(min);
          descPq.remove(min);
        }
      }
    }

    if (descPq.isEmpty()) {
      return answer;
    }

    int max = descPq.poll();
    int min = ascPq.poll();

    if (max > min) {
      answer[0] = max;
      answer[1] = min;
    }

    return answer;
  }
}


public class Main {
  public static void main(String[] args) {
    Solution T = new Solution();
    Scanner stdIn = new Scanner(System.in);

     String[] operations = {"I 16", "D 1"};
//     String[] operations = {"I 7", "I 5", "I -5", "D -1"};
//    String[] operations = {"I 1", "I 2", "I 3", "D -1", "D -1", "D -1", "I 2"};

    for (int i : T.solution(operations)) {
      System.out.print(i + " ");
    }
  }
}

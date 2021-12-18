package stackque.truckacrossbridge;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution {
  public int solution(int bridge_length, int weight, int[] truck_weights) {
    int answer = 0;
    int crntWeight = 0;
    Queue<Integer> bridge = new LinkedList<>();
    int n = truck_weights.length;
    int idx = 0;

    while (true) {
      if (idx >= n) {
        break;
      }

      if (crntWeight + truck_weights[idx] > weight) {
        bridge.offer(0);
      } else {
        bridge.offer(truck_weights[idx]);
        crntWeight += truck_weights[idx];
        idx++;
      }

      answer++;
      if (bridge.size() >= bridge_length) {
        crntWeight -= bridge.poll();
      }
    }

    return answer + bridge_length;
  }
}


public class Main {
  public static void main(String[] args) {
    Solution T = new Solution();
    Scanner stdIn = new Scanner(System.in);

    // int len = 2;
    // int w = 10;
    // int[] weights = {7, 4, 5, 6};

    // int len = 100;
    // int w = 100;
    // int[] weights = {10};
    //
    int len = 100;
    int w = 100;
    int[] weights = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
    System.out.println(T.solution(len, w, weights));
  }
}

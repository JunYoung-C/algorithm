package greedy.camera;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Solution {
  public int solution(int[][] routes) {
    int answer = 0;
    
    Arrays.sort(routes, new Comparator<int[]>() {

      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[1] - o2[1];
      }
      
    });
    
    int len = routes.length;
    int outCheck = Integer.MIN_VALUE;
    for (int i = 0; i < len; i++) {
      int in = routes[i][0];
      int out = routes[i][1];
      if (outCheck >= in && outCheck <= out) {
        continue;
      } else {
        answer++;
        outCheck = out;
      }
    }
    return answer;
  }
}


public class Main {
  public static void main(String[] args) {
    Solution T = new Solution();
    Scanner stdIn = new Scanner(System.in);

    int[][] routes = {{-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}};
    System.out.println(T.solution(routes));
  }
}

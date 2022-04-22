package dfsbfs.targetnumber;

import java.util.Scanner;

class Solution {
  static int answer = 0;
  static int len;
  public int solution(int[] numbers, int target) {
    len = numbers.length;
    dfs(0, 0, numbers, target);
    return answer;
  }

  void dfs(int L, int sum, int[] numbers, int target) {
    if (L >= len) {
      if (sum == target) {
        answer++;
      }
    } else {
      dfs(L + 1, sum + numbers[L], numbers, target);
      dfs(L + 1, sum - numbers[L], numbers, target);
    }
  }
}


public class Main {
  public static void main(String[] args) {
    Solution T = new Solution();
    Scanner stdIn = new Scanner(System.in);

    int[] numbers = {1, 1, 1, 1, 1};
    int target = 3;
    System.out.println(T.solution(numbers, target));
  }
}

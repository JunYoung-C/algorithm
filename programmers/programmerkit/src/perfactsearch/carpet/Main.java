package perfactsearch.carpet;

import java.util.Scanner;

class Solution {
  public int[] solution(int brown, int yellow) {
    int[] answer = {};

    for (int height = 1; height <= (int) Math.sqrt(yellow); height++) {
      if (yellow % height != 0)
        continue;

      int width = yellow / height;
      if (2 * width + 2 * height + 4 == brown) {
        answer = new int[] {width + 2, height + 2};
        break;
      }
    }
    return answer;
  }
}


public class Main {
  public static void main(String[] args) {
    Solution T = new Solution();
    Scanner stdIn = new Scanner(System.in);

    // int brown = 10;
    // int yellow = 2;

    // int brown = 8;
    // int yellow = 1;

    int brown = 24;
    int yellow = 24;
    for (int i : T.solution(brown, yellow)) {
      System.out.print(i + " ");
    }

  }
}

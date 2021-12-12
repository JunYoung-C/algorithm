package greedy.joystick;

import java.util.Scanner;

class Solution {
  public int solution(String name) {
    int answer = 0;
    int len = name.length();
    int minDis = len - 1;;

    for (int nowIdx = 0; nowIdx < len; nowIdx++) {
      char now = name.charAt(nowIdx);
      if (now != 'A') {
        answer += Math.min(now - 'A', 'Z' - now + 1);

        int nextIdx = nowIdx + 1;
        for (; nextIdx < len; nextIdx++) {
          if (name.charAt(nextIdx) != 'A') {
            break;
          }
        }
        minDis = Math.min(minDis, nowIdx + (len + nowIdx) - nextIdx);
      }
    }

    answer += minDis;
    return answer;
  }
}


public class Main {
  public static void main(String[] args) {
    Solution T = new Solution();
    Scanner stdIn = new Scanner(System.in);

    // 1
    // String name = "JEROEN";

    // 2
    // String name = "JAN";
    // 3
    // String name = "AAA";

    // 4
    // String name = "AZA";

    // 5
    // String name = "ABAAB";

    // 6
    // String name = "JAZ";

    // 7
    String name = "ABAABB";
    System.out.println(T.solution(name));
  }
}


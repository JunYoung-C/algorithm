package greedy.makebignum;

import java.util.Scanner;

class Solution {

  public String solution(String number, int k) {
    String answer = "";
    int len = number.length();
    StringBuilder sb = new StringBuilder();
    
    int idx = 0;
    for (int i = 0; i < len - k; i++) {
      int max = 0;
      
      for (int j = idx; j <= k + i; j++) {
        if (number.charAt(j) - '0' > max) {
          max = number.charAt(j) - '0';
          idx = j + 1;
        }
      }
      
      sb.append(max);
    }
    
    answer= sb.toString();
    return answer;
  }
}


public class Main {
  public static void main(String[] args) {
    Solution T = new Solution();
    Scanner stdIn = new Scanner(System.in);

    // 1
//     String num = "1924";
//     int k = 2;

    // 2
//     String num = "1231234";
//     int k = 3;

    // 3
    String num = "4177252841";
    int k = 4;
    System.out.println(T.solution(num, k));
  }
}

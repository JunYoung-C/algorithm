package greedy.helpboat;

import java.util.Arrays;
import java.util.Scanner;

class Solution {
  public int solution(int[] people, int limit) {
      int answer = 0;
      Arrays.sort(people);
      int len = people.length;
      int lt = 0;
      int rt = len - 1;
      boolean[] ch = new boolean[len];
      
      while (lt < rt) {
        int sum = people[lt] + people[rt];
        if (limit >= sum) {
          ch[lt++] = true;
          ch[rt--] = true;
          answer++;
        } else {
          rt--;
        }
      }
      
      for (int i = 0; i < len; i++) {
        if (ch[i] == false) {
          answer++;
        }
      }
      return answer;
  }
}


public class Main {
  public static void main(String[] args) {
    Solution T = new Solution();
    Scanner stdIn = new Scanner(System.in);
    
//    int[] people = new int[] {70, 50, 80, 50};
//    int limit = 100;
    
    int[] people = new int[] {70, 80, 50};
    int limit = 100;
    System.out.println(T.solution(people, limit));
  }
}


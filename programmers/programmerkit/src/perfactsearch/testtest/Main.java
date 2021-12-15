package perfactsearch.testtest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Solution {
  public int[] solution(int[] answers) {
    int[] answer = {};
    int[][] abc = {{1, 2, 3, 4, 5}, {2, 1, 2, 3, 2, 4, 2, 5}, {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
    int[] abcCnt = new int[3];
    
    int len = answers.length;
    for (int i = 0; i < len; i++) {
      for (int who = 0; who < 3; who++) {
        if (abc[who][i % abc[who].length] == answers[i]) {
          abcCnt[who]++;
        }
      }
    }
    
    ArrayList<Integer> arr = new ArrayList<>();
    int max = Arrays.stream(abcCnt).max().getAsInt();
    for (int i = 0; i < 3; i++) {
      if (abcCnt[i] == max) {
        arr.add(i+1);
      }
    }
    
    
    answer = new int[arr.size()];
    for (int i = 0; i < arr.size(); i++) {
      answer[i] = arr.get(i);
    }
    return answer;
  }
}


public class Main {
  public static void main(String[] args) {
    Solution T = new Solution();
    Scanner stdIn = new Scanner(System.in);

//    int[] answer = {1, 2, 3, 4, 5};

     int[] answer = {1, 3, 2, 4, 2};
    for (int i : T.solution(answer)) {
      System.out.print(i + " ");
    }
  }
}

package testexam;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
  public int[] solution(int[] answers) {
    int[] answer = {};
    ArrayList<Integer> arr = new ArrayList<>();
    int[] arrA = {1, 2, 3, 4, 5,};
    int[] arrB = {2, 1, 2, 3, 2, 4, 2, 5};
    int[] arrC = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    int[] abc = new int[3];
    int len = answers.length;
    for (int i = 0; i < len; i++) {
      int ans = answers[i];
      if (arrA[i % 5] == ans) {
        abc[0]++;
      }
      if (arrB[i % 8] == ans) {
        abc[1]++;
      }
      if (arrC[i % 10] == ans) {
        abc[2]++;
      }
    }
    
    int max = Arrays.stream(abc).max().getAsInt();
    
    for (int i = 0; i < 3; i++) {
      if (abc[i] == max) {
        arr.add(i+1);
      }
    }

    answer = new int[arr.size()];
    for (int i = 0; i < answer.length; i++) {
      answer[i] = arr.get(i);
    }
    return answer;
  }
}

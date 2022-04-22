package removeminimumnum;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
  public int[] solution(int[] arr) {
      int[] answer = {};
      int len = arr.length;
      if (len == 1) {
        return new int[] {-1};
      }
      
      int min = Arrays.stream(arr).min().getAsInt();
      
      ArrayList<Integer> removedArr = new ArrayList<>();
      for (int i : arr) {
        if (i == min) continue;
        removedArr.add(i);
      }
      
      answer = new int[len-1];
      for (int i = 0; i < len-1; i++) {
        answer[i] = removedArr.get(i);
      }
      return answer;
  }
}

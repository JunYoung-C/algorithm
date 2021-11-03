package divisiblearr;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
  public int[] solution(int[] arr, int divisor) {
    int[] answer = {};
    ArrayList<Integer> divisibleArr = new ArrayList<>();
    for (int num : arr) {
      if (num % divisor == 0) {
        divisibleArr.add(num);
      }
    }

    int len = divisibleArr.size();
    if (len > 0) {
      answer = new int[len];
      for (int i = 0; i < len; i++) {
        answer[i] = divisibleArr.get(i);
      }
      Arrays.sort(answer);
    } else {
      answer = new int[1];
      answer[0] = -1;
    }

    return answer;
  }
}

package carpet;

import java.util.ArrayList;

class Solution {
  public int[] solution(int brown, int yellow) {
    int[] answer;
    ArrayList<Integer> arr = new ArrayList<>();
    int sum = brown + yellow;
    int start = (int) Math.ceil(Math.sqrt(sum));
    for (int i = start; i <= sum; i++) {
      if (sum % i == 0) {
        int width = i;
        int height = sum / i;
        int round = width * 2 + (height - 2) * 2 ;
        if (brown == round ) {
          arr.add(width);
          arr.add(height);
          break;
        }
        
      }
    }

    answer = new int[2];
    answer[0] = arr.get(0);
    answer[1] = arr.get(1);
    return answer;
  }
}

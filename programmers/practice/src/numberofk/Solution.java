package numberofk;

import java.util.Arrays;

class Solution {
  public int[] solution(int[] array, int[][] commands) {
    int[] answer = new int[commands.length];
    int[] tmp;
    int ansIndex = 0;
    for (int[] command : commands) {
      int i = command[0];
      int j = command[1];
      int k = command[2];
      int len = j - i + 1;
      tmp = new int[len];
      for (int index= 0; index < len; index++) {
        tmp[index] = array[index + i - 1];
      }
      Arrays.sort(tmp);
      answer[ansIndex++] = tmp[k-1];
    }
    return answer;
  }
}

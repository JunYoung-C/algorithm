package landeat;

import java.util.Arrays;

class Solution {
  int solution(int[][] land) {

    int rowMax = land.length;
    for (int row = 1; row < rowMax; row++) {
      for (int col = 0; col < 4; col++) {
        int max = land[row][col];
        
        for (int prevCol = 0; prevCol < 4; prevCol++) {
          if (col != prevCol) {
            int sum = land[row][col] + land[row-1][prevCol];

              max = Integer.max(sum, max);
            
          }
        }
        
        land[row][col] = max;
      }
    }
    int[] answer = land[land.length-1];
    Arrays.sort(answer);

    return answer[answer.length-1];
  }
}

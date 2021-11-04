package samerowcol;

class Solution {
  public int[][] solution(int[][] arr1, int[][] arr2) {
    int[][] answer = {};
    int rowLen = arr1.length;
    int colLen = arr1[0].length;
    answer = new int[rowLen][colLen];
    for (int row = 0; row < rowLen; row++) {
      for (int col = 0; col < colLen; col++) {
        answer[row][col] = arr1[row][col] + arr2[row][col];
      }
    }
    return answer;
  }
}

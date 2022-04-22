package mularrarr;

class Solution {
  public int[][] solution(int[][] arr1, int[][] arr2) {
    int maxRow = arr1.length;
    int maxCol = arr2[0].length;
    int[][] answer = new int[maxRow][maxCol];
    for (int row = 0; row < maxRow; row++) {
      for (int col = 0; col < maxCol; col++) {
        for (int i = 0; i < arr1[0].length; i++) {
          answer[row][col] += arr1[row][i] * arr2[i][col];
        }
      }
    }
    return answer;
  }

}

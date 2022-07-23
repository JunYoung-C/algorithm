package programmers.lv2.행렬의곱셈;

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int height1 = arr1.length;
        int width1 = arr1[0].length;
        int width2 = arr2[0].length;
        int[][] answer = new int[height1][width2];

        for (int r1 = 0; r1 < height1; r1++) {
            for (int c1 = 0; c1 < width1; c1++) {
                for (int c2 = 0; c2 < width2; c2++) {
                    answer[r1][c2] += arr1[r1][c1] * arr2[c1][c2];
                }
            }
        }

        return answer;
    }
}

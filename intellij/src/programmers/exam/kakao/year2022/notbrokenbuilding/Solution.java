package programmers.exam.kakao.year2022.notbrokenbuilding;

import java.util.Scanner;

class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int height = board.length;
        int width = board[0].length;
        int r2, c2, r1, c1;

        int[][] sum = new int[height + 1][width + 1];
        for (int[] s : skill) {
            int degree = (s[0] == 1 ? -s[5] : s[5]);
            r1 = s[1];
            r2 = s[3];
            c1 = s[2];
            c2 = s[4];

            sum[r1][c1] += degree;
            sum[r1][c2 + 1] -= degree;
            sum[r2 + 1][c1] -= degree;
            sum[r2 + 1][c2 + 1] += degree;
        }

        operate(height, width, sum);

        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c++) {
                if (board[r][c] + sum[r][c] > 0) {
                    answer++;
                }
            }
        }
        return answer;
    }

    private void operate(int height, int width, int[][] sum) {
        for (int r = 0; r < height + 1; r++) {
            for (int c = 1; c < width + 1; c++) {
                sum[r][c] += sum[r][c - 1];
            }
        }

        for (int c = 0; c < width + 1; c++) {
            for (int r = 1; r < height + 1; r++) {
                sum[r][c] += sum[r - 1][c];
            }
        }
    }


    public static void main(String[] args) {
        Solution T = new Solution();
        Scanner stdIn = new Scanner(System.in);

        int[][] board = {{5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}};
        int[][] skill = {{1, 0, 0, 3, 4, 4}, {1, 2, 0, 2, 3, 2}, {2, 1, 0, 3, 1, 2}, {1, 0, 1, 3, 3, 1}};

//        int[][] board = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        int[][] skill = {{1, 1, 1, 2, 2, 4}, {1, 0, 0, 1, 1, 2}, {2, 2, 0, 2, 0, 100}};
        System.out.println(T.solution(board, skill));
    }
}

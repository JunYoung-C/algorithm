package programmers.lv2.삼각달팽이;

class Solution {
    public int[] solution(int n) {
        int maxNum = (1 + n) * n / 2;
        int[] answer = new int[maxNum];
        int[][] matrix = new int[n][n];

        int x = 0, y = 0, dir = 0;
        int[] dx = {0, 1, -1}; // 하, 우, 좌상
        int[] dy = {1, 0, -1};
        int sideLen = n;
        int count = 0;
        for (int num = 1; num <= maxNum; num++) {
            matrix[y][x] = num;
            count++;

            if (count == sideLen) {
                count = 0;
                sideLen--;
                dir = (dir + 1) % 3;
            }

            y += dy[dir];
            x += dx[dir];
        }

        int index = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (matrix[r][c] == 0) {
                    continue;
                }

                answer[index++] = matrix[r][c];
            }
        }

        return answer;
    }
}

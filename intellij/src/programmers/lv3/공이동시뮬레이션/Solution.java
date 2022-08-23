package programmers.lv3.공이동시뮬레이션;

class Solution {
    public long solution(int rows, int columns, int row, int col, int[][] queries) {
        long answer = 0;
        long row1 = row;
        long row2 = row;
        long col1 = col;
        long col2 = col;

        for (int i = queries.length - 1; i >= 0; i--) {
            int command = queries[i][0];
            int dx = queries[i][1];

            if (command == 0) { // 좌
                if (col1 != 0) {
                    col1 += dx;
                    if (col1 >= columns) {
                        return 0;
                    }
                }
                col2 = Math.min(col2 + dx, columns - 1);
            } else if (command == 1) { // 우
                if (col2 != columns - 1) {
                    col2 -= dx;
                    if (col2 < 0) {
                        return 0;
                    }
                }
                col1 = Math.max(col1 - dx, 0);
            } else if (command == 2) { // 상
                if (row1 != 0) {
                    row1 += dx;
                    if (row1 >= rows) {
                        return 0;
                    }
                }
                row2 = Math.min(row2 + dx, rows - 1);
            } else { // 하
                if (row2 != rows - 1) {
                    row2 -= dx;
                    if (row2 < 0) {
                        return 0;
                    }
                }
                row1 = Math.max(row1 - dx, 0);
            }

        }
        // System.out.println(row1 + "," + col1 + " " + row2 + "," + col2);

        answer = (row2 - row1 + 1) * (col2 - col1 + 1);

        return answer;
    }
}

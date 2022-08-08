package programmers.lv2.n퀸;

class Solution {
    int[] columns;

    public int solution(int n) {
        columns = new int[n];
        return dfs(0, n);
    }

    private int dfs(int col, int n) {
        int count = 0;
        if (col == n) {
            return 1;
        }

        for (int row = 0; row < n; row++) {
            if (isPossible(row, col)) {
                columns[col] = row;
                count += dfs(col + 1, n);
            }
        }

        return count;
    }

    private boolean isPossible(int row, int col) {
        for (int prevCol = col - 1; prevCol >= 0; prevCol--) {
            int prevRow = columns[prevCol];
            double rowDif = row - prevRow;
            double colDif = col - prevCol;

            if (prevRow == row || (rowDif / colDif == 1) || (rowDif / colDif == -1)) {
                return false;
            }
        }
        return true;
    }
}

package programmers.lv3.순위;

import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;

        int[][] graph = new int[n + 1][n + 1];
        for (int[] result : results) {
            graph[result[0]][result[1]] = 1;
            graph[result[1]][result[0]] = -1;
        }

        for (int k = 1; k <= n; k++) {
            for (int r = 1; r <= n; r++) {
                for (int c = 1; c <= n; c++) {
                    if (r == c) {
                        continue;
                    }

                    if (graph[r][k] == 1 && graph[k][c] == 1) {
                        graph[r][c] = 1;
                    } else if (graph[r][k] == -1 && graph[k][c] == -1) {
                        graph[r][c] = -1;
                    }
                }
            }
        }

        for (int r = 1; r <= n; r++) {
            int winCount = 0;
            int loseCount = 0;
            for (int c = 1; c <= n; c++) {
                if (graph[r][c] == 1) {
                    winCount++;
                } else if (graph[r][c] == -1) {
                    loseCount++;
                }
            }
            if (winCount + loseCount == n - 1) {
                answer++;
            }
        }

        for (int r = 1; r <= n; r++) {
            for (int c = 1; c <= n; c++) {
                System.out.print(graph[r][c] + "\t");
            }
            System.out.println();
        }

        return answer;
    }
}

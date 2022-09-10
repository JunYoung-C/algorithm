package programmers.lv3.순위;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        // 1 : a가 b를 이김, -1 : a가 b에게 짐, 0 : 알 수 없음
        int[][] game = new int[n + 1][n + 1];
        for (int[] result : results) {
            game[result[0]][result[1]] = 1;
            game[result[1]][result[0]] = -1;
        }

        for (int k = 1; k <= n; k++) {
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= n; b++) {
                    if (a == b) {
                        continue;
                    }
                    if (game[a][k] != 0 && game[a][k] == game[k][b]) {
                        game[a][b] = game[a][k];
                    }
                }
            }
        }

        for (int a = 1; a <= n; a++) {
            int count = 0;
            for (int b = 1; b <= n; b++) {
                if (game[a][b] != 0) {
                    count++;
                }
            }
            if (count == n - 1) {
                answer++;
            }
        }

        return answer;
    }
}

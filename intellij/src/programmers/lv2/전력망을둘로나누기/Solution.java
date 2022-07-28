package programmers.lv2.전력망을둘로나누기;

class Solution {
    boolean[] isVisited;
    int[][] graph;
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        graph = new int[n + 1][n + 1];
        isVisited = new boolean[n + 1];
        for (int[] wire : wires) {
            graph[wire[0]][wire[1]] = 1;
            graph[wire[1]][wire[0]] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (graph[i][j] == 1) {
                    graph[i][j] = 0;
                    graph[j][i] = 0;
                    answer = Math.min(answer, getDifference(n));
                    // System.out.println(answer + " " + i + " " + j);
                    isVisited = new boolean[n + 1];
                    graph[i][j] = 1;
                    graph[j][i] = 1;
                }
            }
        }

        return answer;
    }

    private int getDifference(int n) {
        int dif = 0;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                count = dfs(n, i);
                // System.out.print(count + " ");
                if (dif == 0) {
                    dif += count;
                } else {
                    dif -= count;
                }
            }
        }
        return Math.abs(dif);
    }

    private int dfs(int n, int now) {
        int count = 0;
        for (int next = 1; next <= n; next++) {
            if (graph[now][next] == 1 && !isVisited[next]) {
                isVisited[next] = true;
                count += dfs(n, next);
            }
        }

        return count + 1;
    }
}

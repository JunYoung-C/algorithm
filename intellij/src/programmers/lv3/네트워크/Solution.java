package programmers.lv3.네트워크;

class Solution {
    boolean[] isVisited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        isVisited = new boolean[n];

        for (int from = 0; from < n; from++) {
            for (int to = 0; to < n; to++) {
                if (computers[from][to] == 1 && !isVisited[to]) {
                    answer++;
                    dfs(to, computers, n);
                }
            }
        }
        return answer;
    }

    private void dfs(int current, int[][] computers, int n) {
        isVisited[current] = true;

        for (int to = 0; to < n; to++) {
            if (computers[current][to] == 1 && !isVisited[to]) {
                dfs(to, computers, n);
            }
        }
    }
}
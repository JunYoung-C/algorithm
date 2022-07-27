package programmers.lv2.피로도;

class Solution {
    int answer = 0;
    boolean[] isVisited;
    int n;
    public int solution(int k, int[][] dungeons) {
        n = dungeons.length;
        isVisited = new boolean[n];
        dfs(0, k, dungeons, 0);
        return answer;
    }

    private void dfs(int depth, int tiredDegree, int[][] dungeons, int count) {
        answer = Math.max(count, answer);

        for (int i = 0; i < n; i++) {
            if (!isVisited[i] && tiredDegree >= dungeons[i][0]) {
                isVisited[i] = true;

                dfs(depth + 1, tiredDegree - dungeons[i][1], dungeons, count + 1);

                isVisited[i] = false;
            }
        }
    }
}

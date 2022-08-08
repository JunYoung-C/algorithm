package programmers.lv2.전력망을둘로나누기;

import java.util.*;

class Solution {
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    boolean[] isVisited;
    int answer = Integer.MAX_VALUE;

    public int solution(int n, int[][] wires) {
        isVisited = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        isVisited[1] = true;
        dfs(1, n);
        return answer;
    }

    private int dfs(int current, int n) {
        int childCount = 1;

        for (int next : graph.get(current)) {
            if (!isVisited[next]) {
                isVisited[next] = true;
                childCount += dfs(next, n);
                isVisited[next] = false;
            }
        }

        answer = Math.min(answer, Math.abs(childCount - (n - childCount)));
        return childCount;
    }
}
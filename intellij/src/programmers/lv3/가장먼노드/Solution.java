package programmers.lv3.가장먼노드;

import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        boolean[] isVisited = new boolean[n + 1];
        ArrayList<ArrayList<Integer>> graph = createGraph(n, edge);

        Queue<Integer> que = new LinkedList<>();
        que.offer(1);
        isVisited[1] = true;
        while (!que.isEmpty()) {
            int len = que.size();

            for (int i = 0; i < len; i++) {
                int now = que.poll();

                for (int next : graph.get(now)) {
                    if (!isVisited[next]) {
                        isVisited[next] = true;
                        que.offer(next);
                    }
                }
            }

            if (que.isEmpty()) {
                answer = len;
            }
        }

        return answer;
    }

    private ArrayList<ArrayList<Integer>> createGraph(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        return graph;
    }
}

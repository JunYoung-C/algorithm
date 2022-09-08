package programmers.kakao.lv3.양과늑대;

import java.util.*;

class Solution {
    int answer = 0;
    int n;
    boolean[][] isVisited;
    ArrayList<ArrayList<Integer>> graph;

    public int solution(int[] info, int[][] edges) {
        n = info.length;
        isVisited = new boolean[1 << n][n];
        graph = createGraph(edges);
        isVisited[1][0] = true;
        dfs(info, 0, 0, 0, 0);
        // System.out.println(1 ^ 2);
        return answer;
    }

    private void dfs(int[] info, int sheepCount, int wolfCount,
                     int index, int visitBit) {

        if ((visitBit & (1 << index)) == 0) {
            if (info[index] == 0) {
                sheepCount++;
            } else {
                wolfCount++;
            }

            visitBit |= (1 << index);
        }

        if (sheepCount > wolfCount) {
            answer = Math.max(answer, sheepCount);
        } else {
            return;
        }

        for (int next : graph.get(index)) {
            if (!isVisited[visitBit][next]) {
                isVisited[visitBit][next] = true;
                dfs(info, sheepCount, wolfCount, next, visitBit);
            }
        }
    }

    private ArrayList<ArrayList<Integer>> createGraph(int[][] edges) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        return graph;
    }
}



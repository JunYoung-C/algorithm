package programmers.lv3.순위;

import java.util.*;

class Solution {
    ArrayList<Integer> children = new ArrayList<>();
    ArrayList<ArrayList<Integer>> graph;
    boolean[] isVisited;
    public int solution(int n, int[][] results) {
        int answer = 0;
        graph = createGraph(n, results);
        int[] childrenCounts = new int[n + 1];
        isVisited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            isVisited[i] = true;
            childrenCounts[i] = getChildrenCount(i);
            isVisited = new boolean[n + 1];
        }

        int rank = 1;
        while (rank <= n) {
            int count = 0;

            for (int i = 1; i <= n; i++) {
                if (childrenCounts[i] == rank) {
                    count++;
                }
            }

            if (count == 1) {
                answer++;
            }
            rank += Math.max(1, count);
        }
        return answer;
    }

    private int getChildrenCount(int current) {
        int count = 1;

        for (int next : graph.get(current)) {
            if (!isVisited[next]) {
                isVisited[next] = true;
                count += getChildrenCount(next);
            }
        }

        return count;
    }

    private ArrayList<ArrayList<Integer>> createGraph(int n, int[][] results) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0;  i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] result : results) {
            graph.get(result[1]).add(result[0]);
        }

        return graph;
    }
}

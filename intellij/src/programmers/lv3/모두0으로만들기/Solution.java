package programmers.lv3.모두0으로만들기;

import java.util.*;

class Solution {
    public long solution(int[] a, int[][] edges) {
        if (!isPossible(a)) {
            return -1;
        }

        long answer = 0;
        int len = a.length;
        ArrayList<ArrayList<Integer>> graph = createGraph(len);
        int[] indegree = new int[len];
        long[] numbers = new long[len];
        for (int i = 0; i < len; i++) {
            numbers[i] = a[i];
        }
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
            indegree[e[0]]++;
            indegree[e[1]]++;
        }

        Queue<Integer> que = new LinkedList<>();
        for (int node = 0; node < len; node++) {
            if (indegree[node] == 1) {
                que.offer(node);
            }
        }

        while (!que.isEmpty()) {
            // for (int i = 0; i < len; i++) {
            //     System.out.print(indegree[i] + " ");
            // }
            // System.out.println();
            int current = que.poll();
            long cost = numbers[current];
            indegree[current]--;
            answer += Math.abs(cost);
            numbers[current] = 0;

            for (int next : graph.get(current)) {
                if (indegree[next] > 0) {
                    indegree[next]--;
                    numbers[next] += cost;

                    if (indegree[next] == 1) {
                        que.offer(next);
                    }

                    break;
                }

            }
        }

        return answer;
    }

    private ArrayList<ArrayList<Integer>> createGraph(int len) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            graph.add(new ArrayList<>());
        }

        return graph;
    }

    private boolean isPossible(int[] numbers) {
        long sum = 0;
        for (int i : numbers) {
            sum += i;
        }

        if (sum == 0) {
            return true;
        } else {
            return false;
        }
    }
}

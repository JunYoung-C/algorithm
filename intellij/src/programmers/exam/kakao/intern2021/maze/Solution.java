package programmers.exam.kakao.intern2021.maze;

import java.util.*;

class Status {
    int now;
    int distance;
    int[][] graph;

    public Status(int now, int distance, int[][] graph) {
        this.now = now;
        this.distance = distance;
        this.graph = graph;
    }
}

class Solution {
    public int solution(int n, int start, int end, int[][] roads, int[] traps) {
        int answer = 0;
        int[][] graph = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(graph[i], -1);
        }

        for (int[] road : roads) {
            int a = road[0];
            int b = road[1];
            int c = road[2];
            graph[a][b] = c;
        }

        answer = bfs(n, start, end, traps, graph);
//        for (int i = 0; i < n + 1; i++) {
//            for (int j = 0; j < n + 1; j++) {
//                System.out.print(graph[i][j] + " ");
//            }
//            System.out.println();
//        }
        return answer;
    }

    int bfs(int n, int start, int end, int[] traps, int[][] graph) {
        Queue<Status> que = new LinkedList<>();
        que.offer(new Status(start, 0, createCopyGraph(graph, traps, start, n)));
        int minDis = Integer.MAX_VALUE;

        while (!que.isEmpty()) {
            int len = que.size();
            Status status = que.poll();
            if (status.now == end) {
                minDis = Math.min(minDis, status.distance);
            }
            if (status.distance >= minDis) {
                continue;
            }
//            System.out.println(status.distance);

            for (int next = 1; next <= n; next++) {
                int cost = status.graph[status.now][next];
                if (cost != -1) {
                    que.offer(new Status(next, status.distance + cost, createCopyGraph(status.graph, traps, next, n)));
                }
            }
        }

        return minDis;
    }

    int[][] createCopyGraph(int[][] graph, int[] traps, int now, int n) {
        int[][] copy = new int[n + 1][n + 1];

        for (int i = 0; i < n + 1; i++) {
            copy[i] = graph[i].clone();
        }

        if (isTrap(traps, now)) {
            ChangeDirection(n, now, copy);
        }
        return copy;
    }
    boolean isTrap(int[] arr, int num) {
        for (int i : arr) {
            if (i == num) {
                return true;
            }
        }
        return false;
    }

    void ChangeDirection(int n, int trap, int[][] graph) {
        int tmp;
        for (int i = 1; i <= n; i++) {
            tmp = graph[trap][i];
            graph[trap][i] = graph[i][trap];
            graph[i][trap] = tmp;
        }
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        Scanner stdIn = new Scanner(System.in);

//        int n = 3;
//        int start = 1;
//        int end = 3;
//        int[][] roads = {{1, 2, 2}, {3, 2, 3}};
//        int[] traps = {2};

        int n = 4;
        int start = 1;
        int end = 4;
        int[][] roads = {{1, 2, 1}, {3, 2,1}, {2, 4, 1}};
        int[] traps = {2, 3};

        System.out.println(T.solution(n, start, end, roads, traps));
    }
}

package programmers.exam.kakao.intern2021.maze;

import java.util.*;

class Solution {
    static int[][] graph;
    static int[] visitCnt;
    static int minDis = Integer.MAX_VALUE;
    public int solution(int n, int start, int end, int[][] roads, int[] traps) {
        graph = new int[n + 1][n + 1];
        visitCnt = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(graph[i], -1);
        }

        for (int[] road : roads) {
            int a = road[0];
            int b = road[1];
            int c = road[2];
            graph[a][b] = c;
        }

        visitCnt[start] = 1;
        dfs(0, start, end, traps, n);

//        for (int i = 0; i < n + 1; i++) {
//            for (int j = 0; j < n + 1; j++) {
//                System.out.print(graph[i][j] + " ");
//            }
//            System.out.println();
//        }
        return minDis;
    }

    void dfs(int distance, int now, int end, int[] traps, int n) {
        if (minDis <= distance) {
            return;
        }

        if (now == end) {
            minDis = Math.min(minDis, distance);
            return;
        } else {
            for (int next = 1; next <= n; next++) {
                int cost = graph[now][next];
                if (cost == -1 || visitCnt[next] >= 2) {
                    continue;
                }

                visitCnt[next] += 1;
                if (isTrap(traps, next)) {
                    changeDirection(n, next);
                    dfs(distance + cost, next, end, traps, n);
                    changeDirection(n, next);
                } else {
                    dfs(distance + cost, next, end, traps, n);
                }
                visitCnt[next] -= 1;
            }
        }
    }

    boolean isTrap(int[] arr, int num) {
        for (int i : arr) {
            if (i == num) {
                return true;
            }
        }
        return false;
    }

    void changeDirection(int n, int trap) {
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

        int n = 3;
        int start = 1;
        int end = 3;
        int[][] roads = {{1, 2, 2}, {3, 2, 3}};
        int[] traps = {2};

//        int n = 4;
//        int start = 1;
//        int end = 4;
//        int[][] roads = {{1, 2, 1}, {3, 2,1}, {2, 4, 1}};
//        int[] traps = {2, 3};

        System.out.println(T.solution(n, start, end, roads, traps));
    }
}

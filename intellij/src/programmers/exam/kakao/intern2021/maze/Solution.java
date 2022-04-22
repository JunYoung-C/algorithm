package programmers.exam.kakao.intern2021.maze;

import java.util.*;

class Node implements Comparable<Node> {
    int index;
    int distance;
    int[] visitCnt;

    public static Node create(int index, int distance, int n) {
        Node node = new Node();
        node.index = index;
        node.distance = distance;
        node.visitCnt = new int[n + 1];
        return node;
    }

    @Override
    public int compareTo(Node o) {
        return this.distance - o.distance;
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
        PriorityQueue<Node> pQ = new PriorityQueue<>();
        int[] minDistances = new int[n + 1];
        Arrays.fill(minDistances, Integer.MAX_VALUE);
        pQ.offer(Node.create(1, 0, 0));
        minDistances[start] = 0;

        while (!pQ.isEmpty()) {
            Node now = pQ.poll();
            now.visitCnt[now.index] += 1;

            if (minDistances[now.index] < now.distance) {
                continue;
            }

            for (int nextIndex = 1; nextIndex <= n; nextIndex++) {
                int cost = graph[now.index][nextIndex];
                if (now.visitCnt[nextIndex] >= 2) {
                    continue;
                }

                if (cost != -1) {

                } else {
                    
                }

            }
        }

        return minDistances[end];
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
        int[][] roads = {{1, 2, 1}, {3, 2, 1}, {2, 4, 1}};
        int[] traps = {2, 3};

        System.out.println(T.solution(n, start, end, roads, traps));
    }
}

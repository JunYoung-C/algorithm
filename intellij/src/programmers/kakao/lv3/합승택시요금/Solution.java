package programmers.kakao.lv3.합승택시요금;

import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        int[][] distance = new int[n + 1][n + 1];
        int len = distance.length;
        initDistance(n, fares, distance, len);

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(distance[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = 1; i <= n; i++) {
            answer = Math.min(answer, distance[s][i] + distance[i][a] + distance[i][b]);
        }

        return answer;
    }

    private static void initDistance(int n, int[][] fares, int[][] distance, int len) {
        int MAX_VALUE = 20000001;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i == j) {
                    continue;
                }
                distance[i][j] = MAX_VALUE;
            }
        }

        for (int[] f : fares) {
            distance[f[0]][f[1]] = f[2];
            distance[f[1]][f[0]] = f[2];
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }
        }
    }

    private ArrayList<ArrayList<Node>> createGraph(int[][] fares, int n) {
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] f : fares) {
            graph.get(f[0]).add(new Node(f[1], f[2]));
            graph.get(f[1]).add(new Node(f[0], f[2]));
        }

        return graph;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        Scanner stdIn = new Scanner(System.in);

        int n = 6, s = 4, a = 6, b = 2;
        int[][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
        System.out.println(T.solution(n, s, a, b, fares));
    }
}

class Node implements Comparable<Node> {
    int index;
    int cost;

    public Node(int index, int cost) {
        this.index = index;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}

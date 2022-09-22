package programmers.kakao.year2021.합승택시요금;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;

        int[][] graph = createGraph(n);
        initGraph(fares, graph);

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        for (int stop = 1; stop <= n; stop++) {
            answer = Math.min(answer, graph[s][stop] + graph[stop][a] + graph[stop][b]);
        }

        return answer;
    }

    private static void initGraph(int[][] fares, int[][] graph) {
        for (int[] e : fares) {
            graph[e[0]][e[1]] = e[2];
            graph[e[1]][e[0]] = e[2];
        }
    }

    private int[][] createGraph(int n) {
        int[][] graph = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j) {
                    graph[i][j] = 100_000_000;
                }
            }
        }
        return graph;
    }

    public static void main(String[] args) {
        Solution T = new Solution();

        int n = 6;
        int s = 4;
        int a = 6;
        int b = 2;
        int[][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
        System.out.println(T.solution(n, s, a, b, fares));
    }
}

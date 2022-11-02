package backjoon.dp.ex15681;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    int[] dp;
    boolean[] isVisited;
    public void solution(int nodeCount, int root, ArrayList<ArrayList<Integer>> graph, int queryCount, ArrayList<Integer> queries) {
        dp = new int[nodeCount + 1];
        isVisited = new boolean[nodeCount + 1];

        isVisited[root] = true;
        dfs(graph, root);

        for (int q : queries) {
            System.out.println(dp[q]);
        }
    }

    private int dfs(ArrayList<ArrayList<Integer>> graph, int current) {
        int subTreeCount = 1;
        for (int next : graph.get(current)) {
            if (!isVisited[next]) {
                isVisited[next] = true;
                subTreeCount += dfs(graph, next);
            }
        }

        return dp[current] = subTreeCount;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeCount = Integer.parseInt(st.nextToken());
        int root = Integer.parseInt(st.nextToken());
        int queryCount = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= nodeCount; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < nodeCount - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        ArrayList<Integer> queries = new ArrayList<>();

        for (int i = 0; i < queryCount; i++) {
            st = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken());
            queries.add(q);
        }

        br.close();
        T.solution(nodeCount, root, graph, queryCount, queries);
    }
}

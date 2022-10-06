package backjoon.dp.ex2533;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    int[][] dp;
    boolean[] isVisited;

    public int solution(int n) {
        dp = new int[n + 1][2]; // 노드, 얼리어답터 여부
        isVisited = new boolean[n + 1];
        dfs(1);
//        for (int i = 0; i < n; i++) {
//            System.out.println(i + " : " + dp[i][0] + " " + dp[i][1]);
//        }

        return Math.min(dp[1][0], dp[1][1]);
    }

    private void dfs(int currentNode) {
        isVisited[currentNode] = true;
        dp[currentNode][1] = 1;

        for (int next : graph.get(currentNode)) {
            if (isVisited[next]) {
                continue;
            }

            dfs(next);
            dp[currentNode][0] += dp[next][1];
            dp[currentNode][1] += Math.min(dp[next][0], dp[next][1]);
        };
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        br.close();
        bw.write(T.solution(n)+ "");
        bw.flush();
        bw.close();
    }
}

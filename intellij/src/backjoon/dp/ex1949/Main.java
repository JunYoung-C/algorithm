package backjoon.dp.ex1949;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[] people;
    ArrayList<ArrayList<Integer>> graph;
    int[][] dp;
    boolean[] isVisited;
    final int O = 1, X = 0;

    public int solution(int n, int[][] edges) {
        int answer = 0;
        graph = createGraph(n, edges);
        dp = new int[2][n + 1];
        for (int i = 1; i <= n; i++) {
            dp[O][i] = people[i];
        }
        isVisited = new boolean[n + 1];
        isVisited[1] = true;
        setDp(-1, -1, 1);
        for (int i = 0; i < 2; i++) {
            System.out.print((i == 0 ? "X" : "O") + " ");
            for (int j = 1; j <= n; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println();
        }

        isVisited = new boolean[n + 1];
        isVisited[1] = true;
        return getMaxPeopleCount(1);
    }

    private int getMaxPeopleCount(int now) {
        int peopleCount = 0;
        for (int next : graph.get(now)) {
            if (!isVisited[next]) {
                isVisited[next] = true;
                peopleCount += getMaxPeopleCount(next);
                isVisited[next] = false;
            }
        }

        return Math.max(peopleCount, Math.max(dp[O][now], dp[X][now]));
    }

    private void setDp(int grandParent, int parent, int now) {
        if (parent != -1) {
            dp[O][now] = Math.max(dp[O][now], dp[X][parent]);
            dp[X][now] = Math.max(dp[X][now], dp[O][parent]);
        }
        if (grandParent != -1) {
            dp[O][now] = Math.max(dp[O][now], dp[X][grandParent]);
        }

        for (int next : graph.get(now)) {
            if (!isVisited[next]) {
                isVisited[next] = true;
                setDp(parent, now, next);
                isVisited[next] = false;
            }
        }
    }

    private ArrayList<ArrayList<Integer>> createGraph(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        return graph;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        people = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }

        int[][] edges = new int[n - 1][2];
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            edges[i][0] = Integer.parseInt(st.nextToken());
            edges[i][1] = Integer.parseInt(st.nextToken());
        }

        br.close();
        bw.write(T.solution(n, edges)+ "");
        bw.flush();
        bw.close();
    }
}

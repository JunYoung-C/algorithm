package backjoon.tree.ex11725;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public void solution(int n, ArrayList<ArrayList<Integer>> graph) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] parent = new int[n + 1];
        boolean[] isVisited = new boolean[n + 1];
        Queue<Integer> que = new LinkedList<>();
        que.offer(1);
        isVisited[1] = true;

        while (!que.isEmpty()) {
            int now = que.poll();

            for (int next : graph.get(now)) {
                if (!isVisited[next]) {
                    isVisited[next] = true;
                    parent[next] = now;
                    que.offer(next);
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            bw.write(parent[i]+ "\n");
        }

        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
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

        T.solution(n, graph);
    }
}

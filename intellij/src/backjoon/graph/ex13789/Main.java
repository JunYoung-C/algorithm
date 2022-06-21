package backjoon.graph.ex13789;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public String solution() {
        String answer = "";

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeCount = Integer.parseInt(st.nextToken());
        int edgeCount = Integer.parseInt(st.nextToken());
        int[][] graph = new int[nodeCount + 1][nodeCount + 1];


        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        for (int k = 1; k <= nodeCount; k++) {
            for (int i = 1; i <= nodeCount; i++) {
                for (int j = 1; j <= nodeCount; j++) {
                    if (graph[i][k] != 0 && graph[k][j] != 0) {
                        if (graph[i][j] == 0) {
                            graph[i][j] = graph[i][k] + graph[k][j];
                        } else {
                            graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                        }
                    }
                }
            }
        }

        br.close();

        int[] answer = new int[nodeCount + 1];
        int minSum = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = 1; i <= nodeCount; i++) {
            for (int j = 1; j <= nodeCount; j++) {
                answer[i] += graph[i][j];
            }
            if (minSum > answer[i]) {
                minSum = answer[i];
                minIndex = i;
            }
        }
        bw.write(minIndex + "");
        bw.flush();
        bw.close();
    }
}

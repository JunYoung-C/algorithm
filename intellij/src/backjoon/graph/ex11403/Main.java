package backjoon.graph.ex11403;

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
        int[][] graph = new int[nodeCount][nodeCount];
        for (int i = 0; i < nodeCount; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < nodeCount; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int k = 0; k < nodeCount; k++) {
            for (int i = 0; i < nodeCount; i++) {
                for (int j = 0; j < nodeCount; j++) {
                    if (graph[i][k] + graph[k][j] == 2) {
                        graph[i][j] = 1;
                    }
                }
            }
        }

        br.close();
        for (int i = 0; i < nodeCount; i++) {
            for (int j = 0; j < nodeCount; j++) {
                bw.write(graph[i][j] + " ");
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}

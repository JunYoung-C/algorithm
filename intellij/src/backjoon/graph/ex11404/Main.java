package backjoon.graph.ex11404;

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
        StringTokenizer st;

        int INF = 100000000;
        int nodeCount = Integer.parseInt(br.readLine());
        int edgeCount = Integer.parseInt(br.readLine());

        int[][] minDis = new int[nodeCount + 1][nodeCount + 1];
        for (int i = 1; i <= nodeCount; i++) {
            for (int j = 1; j <= nodeCount; j++) {
                if (i == j) {
                    minDis[i][j] = 0;
                } else {
                    minDis[i][j] = INF;
                }
            }
        }

        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (minDis[a][b] > c) {
                minDis[a][b] = c;
            }
        }

        for (int k = 1; k <= nodeCount; k++) {
            for (int a = 1; a <= nodeCount; a++) {
                for (int b = 1; b <= nodeCount; b++) {
                    minDis[a][b] = Math.min(minDis[a][k] + minDis[k][b], minDis[a][b]);
                }
            }
        }

        for (int a = 1; a <= nodeCount; a++) {
            for (int b = 1; b <= nodeCount; b++) {
                if (minDis[a][b] == INF) {
                    bw.write("0 ");
                } else {
                    bw.write(minDis[a][b] + " ");
                }
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}

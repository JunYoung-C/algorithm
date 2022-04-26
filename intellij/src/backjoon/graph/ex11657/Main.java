package backjoon.graph.ex11657;

import java.io.*;
import java.util.Arrays;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {
    public long[] solution(int nodeCount, int edgeCount, Edge[] edges) {
        long[] minDis = new long[nodeCount + 1];
        Arrays.fill(minDis, Integer.MAX_VALUE);
        minDis[1] = 0;
        for (int i = 1; i < nodeCount; i++) {
            for (Edge edge : edges) {
                if (minDis[edge.start] != Integer.MAX_VALUE &&
                        minDis[edge.end] > minDis[edge.start] + edge.cost) {
                    minDis[edge.end] = minDis[edge.start] + edge.cost;
                }
            }
        }

        for (Edge edge : edges) {
            if (minDis[edge.start] != Integer.MAX_VALUE &&
                    minDis[edge.end] > minDis[edge.start] + edge.cost) {
                return null;
            }
        }

        return minDis;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeCount = Integer.parseInt(st.nextToken());
        int edgeCount = Integer.parseInt(st.nextToken());

        Edge[] edges = new Edge[edgeCount];

        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(start, end, cost);
        }

        long[] minDis = T.solution(nodeCount, edgeCount, edges);
        if (Objects.isNull(minDis)) {
            bw.write("-1\n");
        } else {
            for (int i = 2; i <= nodeCount; i++) {
                if (minDis[i] == Integer.MAX_VALUE) {
                    bw.write("-1\n");
                } else {
                    bw.write(minDis[i] + "\n");
                }
            }
        }

        bw.flush();
        bw.close();
    }
}

class Edge {
    int start;
    int end;
    int cost;

    public Edge(int start, int end, int cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }
}

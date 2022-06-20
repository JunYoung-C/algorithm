package backjoon.graph.ex11657;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

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

public class Main {
    public void solution(int nodeCount, int edgeCount, ArrayList<Edge> edges) {
        long[] distance = new long[nodeCount + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[1] = 0;

        for (int i = 0; i < nodeCount - 1; i++) {
            for (Edge e : edges) {
                if (distance[e.start] != Integer.MAX_VALUE && distance[e.end] > distance[e.start] + e.cost) {
                    distance[e.end] = distance[e.start] + e.cost;
                }
            }
        }

        for (Edge e : edges) {
            if (distance[e.start] != Integer.MAX_VALUE && distance[e.end] > distance[e.start] + e.cost) {
                System.out.println(-1);
                return;
            }
        }

        for (int i = 2; i <= nodeCount; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                System.out.println(-1);

            } else {
                System.out.println(distance[i]);

            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeCount = Integer.parseInt(st.nextToken());
        int edgeCount = Integer.parseInt(st.nextToken());
        ArrayList<Edge> edges = new ArrayList<>();
        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edges.add(new Edge(a, b, c));
        }


        br.close();
        T.solution(nodeCount, edgeCount, edges);
    }
}

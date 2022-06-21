package backjoon.graph.ex1219;

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
    public String solution(int nodeCount, int startIndex, int endIndex, int edgeCount, ArrayList<Edge> edges, int[] incomes) {
        long[] money = new long[nodeCount];
        Arrays.fill(money, Long.MIN_VALUE);
        money[startIndex] = incomes[startIndex];

        for (int i = 0; i < nodeCount -1; i++) {
            for (Edge e : edges) {
                if (money[e.start] != Long.MIN_VALUE && money[e.end] < money[e.start] + e.cost + incomes[e.end]) {
                    money[e.end] = money[e.start] + e.cost + incomes[e.end];
                }
            }
        }


        if (money[endIndex] == Long.MIN_VALUE) {
            return "gg";
        }

        for (int i = 0; i < 100; i++) {
            for (Edge e : edges) {
                if (money[e.start] == Long.MAX_VALUE) {
                    money[e.end] = Long.MAX_VALUE;
                    continue;
                }

                if (money[e.start] != Long.MIN_VALUE && money[e.end] < money[e.start] + e.cost + incomes[e.end]) {
                    money[e.end] = Long.MAX_VALUE;
                }
            }
        }

        if (money[endIndex] == Long.MAX_VALUE) {
            return "Gee";
        }

        return String.valueOf(money[endIndex]);
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeCount = Integer.parseInt(st.nextToken());
        int startIndex = Integer.parseInt(st.nextToken());
        int endIndex = Integer.parseInt(st.nextToken());
        int edgeCount = Integer.parseInt(st.nextToken());

        ArrayList<Edge> edges = new ArrayList<>();
        int[] incomes = new int[nodeCount];

        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edges.add(new Edge(a, b, -c));
        }
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < nodeCount; i++) {
            incomes[i] = Integer.parseInt(st.nextToken());
        }
        br.close();
        bw.write(T.solution(nodeCount, startIndex, endIndex, edgeCount, edges, incomes)+ "");
        bw.flush();
        bw.close();
    }
}

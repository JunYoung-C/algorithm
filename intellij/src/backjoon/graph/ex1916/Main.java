package backjoon.graph.ex1916;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
    int destination;
    int cost;

    public Edge(int destination, int cost) {
        this.destination = destination;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}

public class Main {
    public int solution(int nodeCount, int edgeCount, ArrayList<ArrayList<Edge>> graph, int start, int end) {
        int[] distance = new int[nodeCount + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.offer(new Edge(start, 0));
        distance[start] = 0;

        while (!pQ.isEmpty()) {
            Edge currentEdge = pQ.poll();

            if (distance[currentEdge.destination] < currentEdge.cost) {
                continue;
            }

            for (Edge nextEdge : graph.get(currentEdge.destination)) {
                if (distance[nextEdge.destination] > distance[currentEdge.destination] + nextEdge.cost) {
                    distance[nextEdge.destination] = distance[currentEdge.destination] + nextEdge.cost;
                    pQ.offer(new Edge(nextEdge.destination, distance[nextEdge.destination]));
                }
            }
        }

        return distance[end];
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeCount = Integer.parseInt(st.nextToken());
        int edgeCount = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

        for (int i = 0; i <= nodeCount;i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Edge(b, c));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        br.close();
        bw.write(T.solution(nodeCount, edgeCount, graph, start, end) + "");
        bw.flush();
        bw.close();
    }
}

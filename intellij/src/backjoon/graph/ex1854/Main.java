package backjoon.graph.ex1854;

import java.io.*;
import java.util.*;

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
    public int[] solution(int nodeCount, int edgeCount, int nth, ArrayList<ArrayList<Edge>> graph) {
        int[] answer = new int[nodeCount + 1];
        PriorityQueue<Integer>[] distance = new PriorityQueue[nodeCount + 1];

        for (int i = 1; i <= nodeCount; i++) {
            distance[i] = new PriorityQueue<>();
            distance[i].add(Integer.MAX_VALUE);
        }

        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.offer(new Edge(1, 0));
        distance[1].add(0);

        while (!pQ.isEmpty()) {
            Edge currentEdge = pQ.poll();

            if (distance[currentEdge.destination].peek() < currentEdge.cost) {
                continue;
            }

            for (Edge nextEdge : graph.get(currentEdge.destination)) {

                if (distance[nextEdge.destination].peek() > currentEdge.cost + nextEdge.cost) {
                    distance[nextEdge.destination].add(currentEdge.cost + nextEdge.cost);
                    pQ.offer(new Edge(nextEdge.destination, currentEdge.cost + nextEdge.cost));
                } else {
                    distance[nextEdge.destination].add(currentEdge.cost + nextEdge.cost);
                }
            }
        }

        for (int i = 1; i <= nodeCount; i++) {
            if (distance[i].size() <= nth) {
                answer[i] = -1;
            } else {
                for (int j = 0; j < nth - 1; j++) {
                    distance[i].poll();
                }
                answer[i] = distance[i].peek();
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeCount = Integer.parseInt(st.nextToken());
        int edgeCount = Integer.parseInt(st.nextToken());
        int nth = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= edgeCount; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Edge(b, c));
        }
        br.close();
        int[] answer = T.solution(nodeCount, edgeCount, nth, graph);

        for (int i = 1; i <= nodeCount; i++) {
            bw.write(answer[i] + "\n");
        }
        bw.flush();
        bw.close();
    }
}

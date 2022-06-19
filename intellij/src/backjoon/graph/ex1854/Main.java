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
        TreeSet<Integer>[] distance = new TreeSet[nodeCount + 1];
        // k번째 숫자가 중복 숫자를 허용하는 건가? priorityQueue로 해보자
        for (int i = 1; i <= nodeCount; i++) {
            distance[i] = new TreeSet<>();
            distance[i].add(Integer.MAX_VALUE);
        }

        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.offer(new Edge(1, 0));
        distance[1].add(0);

        while (!pQ.isEmpty()) {
            Edge currentEdge = pQ.poll();

            if (distance[currentEdge.destination].first() < currentEdge.cost) {
                continue;
            }

            for (Edge nextEdge : graph.get(currentEdge.destination)) {


                if (distance[nextEdge.destination].first() > distance[currentEdge.destination].first() + nextEdge.cost) {
                    distance[nextEdge.destination].add(distance[currentEdge.destination].first() + nextEdge.cost);
                    pQ.offer(new Edge(nextEdge.destination, distance[nextEdge.destination].first()));
                } else {
                    distance[nextEdge.destination].add(distance[currentEdge.destination].first() + nextEdge.cost);
                }
                if (distance[nextEdge.destination].size() > nth) {
                    distance[nextEdge.destination].pollLast();
                }
            }
        }

        for (int i = 1; i <= nodeCount; i++) {
            if (distance[i].size() == nth && distance[i].last() != Integer.MAX_VALUE) {
                answer[i] = distance[i].last();
            } else {
                answer[i] = -1;
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

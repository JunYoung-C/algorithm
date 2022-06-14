package backjoon.graph.ex18352;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
    int index;
    int cost;

    public Node(int index, int cost) {
        this.index = index;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}

public class Main {
    public ArrayList<Integer> solution(int nodeCount, int edgeCount, int targetDistance, int startIndex, ArrayList<ArrayList<Node>> graph) {
        int[] distance = new int[nodeCount + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        PriorityQueue<Node> pQ = new PriorityQueue<>();
        pQ.offer(new Node(startIndex, 0));
        distance[startIndex] = 0;

        while (!pQ.isEmpty()) {
            Node now = pQ.poll();

            if (distance[now.index] < now.cost) {
                continue;
            }

            for (Node next : graph.get(now.index)) {
                if (distance[now.index] + next.cost <= targetDistance && distance[next.index] > distance[now.index] + next.cost) {
                    distance[next.index] = distance[now.index] + next.cost;
                    pQ.offer(new Node(next.index, distance[next.index]));
                }
            }
        }


        ArrayList<Integer> answer = new ArrayList<>();
        for (int node = 1; node <= nodeCount; node++) {
            if (distance[node] == targetDistance) {
                answer.add(node);
            }
        }

        if (answer.size() == 0) {
            answer.add(-1);
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
        int targetDistance = Integer.parseInt(st.nextToken());
        int startNode = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= nodeCount; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, 1));
        }


        for (int i : T.solution(nodeCount, edgeCount, targetDistance, startNode, graph)) {
            bw.write(i + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}

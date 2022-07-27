package programmers.lv2.배달;

import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[] distances = new int[N + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        PriorityQueue<Node> pQ = new PriorityQueue();
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        initGraph(N, road, graph);

        pQ.offer(new Node(1, 0));
        distances[1] = 0;
        while (!pQ.isEmpty()) {
            Node currentNode = pQ.poll();

            if (distances[currentNode.destination] < currentNode.cost) {
                continue;
            }
            for (Node next : graph.get(currentNode.destination)) {
                if (distances[next.destination] > currentNode.cost + next.cost) {
                    distances[next.destination] = currentNode.cost + next.cost;
                    pQ.offer(new Node(next.destination, distances[next.destination]));
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (distances[i] <= K) {
                answer++;
            }
        }

        return answer;
    }

    private void initGraph(int N, int[][] road, ArrayList<ArrayList<Node>> graph) {
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] r : road) {
            graph.get(r[0]).add(new Node(r[1], r[2]));
            graph.get(r[1]).add(new Node(r[0], r[2]));
        }
    }
}

class Node implements Comparable<Node> {
    int destination;
    int cost;

    public Node(int destination, int cost) {
        this.destination = destination;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}

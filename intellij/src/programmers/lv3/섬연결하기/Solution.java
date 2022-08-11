package programmers.lv3.섬연결하기;

import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        boolean[] isVisited = new boolean[n];
        int answer = 0;
        ArrayList<ArrayList<Node>> graph = createGraph(n, costs);

        PriorityQueue<Node> pQ = new PriorityQueue<>();
        pQ.offer(new Node(0, 0));
        while (!pQ.isEmpty()) {
            Node current = pQ.poll();

            if (isVisited[current.index]) {
                continue;
            }

            isVisited[current.index] = true;
            answer += current.cost;

            for (Node next : graph.get(current.index)) {
                if (!isVisited[next.index]) {
                    pQ.offer(next);
                }
            }
        }
        return answer;
    }

    private ArrayList<ArrayList<Node>> createGraph(int n, int[][] costs) {
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < costs.length; i++) {
            graph.get(costs[i][0]).add(new Node(costs[i][1], costs[i][2]));
            graph.get(costs[i][1]).add(new Node(costs[i][0], costs[i][2]));
        }

        return graph;
    }
}

class Node implements Comparable<Node> {
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

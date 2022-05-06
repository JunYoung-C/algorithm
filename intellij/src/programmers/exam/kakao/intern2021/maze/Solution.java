package programmers.exam.kakao.intern2021.maze;

import java.util.*;

class Solution {
    static int[][] graph;

    public int solution(int n, int start, int end, int[][] roads, int[] traps) {
        int answer = 0;
        initGraph(n, roads);

        PriorityQueue<Node> edges = new PriorityQueue<>();
        for (int next = 1; next <= n; next++) {
            if (graph[start][next] != Integer.MAX_VALUE) {
                edges.offer(new Node(next, graph[start][next], new boolean[n + 1]));
            }
        }

        // end에 도달하면 종료
        while (!edges.isEmpty()) {
            Node currentNode = edges.poll();
            boolean visitTrapNode = visitTrapNode(currentNode.index, traps); // 현재 노드가 트랩인지 확인
            boolean[] isTrapped = currentNode.isTrapped.clone();

            // que에 넣기 전에 현재 노드가 trap인지 계산하고 넣어야함
            if (visitTrapNode) {
                isTrapped[currentNode.index] = !isTrapped[currentNode.index];
                // next가 트랩 on인 경우에는 현재 노드 -> next가 가능한 경우를 고려한다.
                // next가 트랩 off, 트랩x인 경우에는 next -> 현재 노드가 가능한 경우를 고려해야 한다.
            } else {
                // next가 트랩 on인 경우에는 next -> 현재노드가 가능한 경우를 고려한다.
                // next가 트랩 off, 트랩x인 경우에는 현재 노드 -> next가 가능한 경우를 고려해야 한다.

            }
        }

        return answer;
    }

    private boolean visitTrapNode(int index, int[] traps) {
        for (int trap : traps) {
            if (index == trap) {
                return true;
            }
        }
        return false;
    }

    private void initGraph(int n, int[][] roads) {
        graph = new int[n + 1][n + 1];
        for (int row = 1; row <= n; row++) {
            Arrays.fill(graph[row], Integer.MAX_VALUE);
        }
        for (int[] road : roads) {
            graph[road[0]][road[1]] = Math.min(graph[road[0]][road[1]], road[2]);
        }
    }

    class Node implements Comparable<Node> {
        int index;
        int accumulateCost;
        boolean[] isTrapped;

        public Node(int index, int accumulateCost, boolean[] isTrapped) {
            this.index = index;
            this.accumulateCost = accumulateCost;
            this.isTrapped = isTrapped;
        }

        @Override
        public int compareTo(Node o) {
            return this.accumulateCost - o.accumulateCost;
        }
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        Scanner stdIn = new Scanner(System.in);

//        int n = 3;
//        int start = 1;
//        int end = 3;
//        int[][] roads = {{1, 2, 2}, {3, 2, 3}};
//        int[] traps = {2};

        int n = 4;
        int start = 1;
        int end = 4;
        int[][] roads = {{1, 2, 1}, {3, 2, 1}, {2, 4, 1}};
        int[] traps = {2, 3};
        System.out.println(T.solution(n, start, end, roads, traps));
    }
}
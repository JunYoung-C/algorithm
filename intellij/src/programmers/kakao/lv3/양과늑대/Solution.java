package programmers.kakao.lv3.양과늑대;

import java.util.*;

class Solution {
    int answer = 0;
    ArrayList<ArrayList<Node>> graph;

    public int solution(int[] info, int[][] edges) {
        graph = createGraph(info, edges);

        ArrayList<Integer> visitList = new ArrayList<>();
        visitList.add(0);
        dfs(0, 1, 0, visitList);

        return answer;
    }

    private void dfs(int nowIndex, int sheepCount, int wolfCount,
                     ArrayList<Integer> visitList) {
        if (sheepCount <= wolfCount) {
            return;
        }

        answer = Math.max(sheepCount, answer);

        // visitList의 노드들과 연결된 노드 중 visitList에 없는 곳을 방문해야함
        for (int visitIndex : visitList) {
            for (Node next : graph.get(visitIndex)) {
                if (visitList.contains(next.index)) {
                    continue;
                }

                ArrayList<Integer> nextVisitList = new ArrayList<>(visitList);
                nextVisitList.add(next.index);

                if (next.isWolf()) {
                    dfs(next.index, sheepCount, wolfCount + 1, nextVisitList);
                } else {
                    dfs(next.index, sheepCount + 1, wolfCount, nextVisitList);
                }
            }
        }
    }

    private ArrayList<ArrayList<Node>> createGraph(int[] info, int[][] edges) {
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();

        for (int i = 0; i <= info.length; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            graph.get(e[0]).add(new Node(e[1], info[e[1]]));
            graph.get(e[1]).add(new Node(e[0], info[e[0]]));
        }

        return graph;
    }
}

class Node {
    int index;
    int type;

    public Node(int index, int type) {
        this.index = index;
        this.type = type;
    }

    boolean isWolf() {
        return this.type == 1;
    }
}



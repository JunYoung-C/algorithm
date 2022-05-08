package programmers.exam.kakao.intern2022.ex4;

import java.util.ArrayList;
import java.util.Scanner;

// 시간 초과 여러개와 런타임 에러 하나 발생
// 여러 출발로에서 하나를 선택하여 출발해서 하나의 정상에 도달하고, 동일한 출발지로 복귀하는 경로 중에서
// intensity(해당 경로 중에서 cost의 최대치)가 가장 최소인 값을 찾는 문제이다.
// 기본적으로 양방향 참조
class Solution {
    int[] visitCount;
    int minIntensity = Integer.MAX_VALUE;
    int minSummitNum = 0;
    ArrayList<ArrayList<Node>> graph;
    int[] summits;
    int[] gates;

    public int[] solution(int n, int[][] paths, int[] gateArr, int[] summitArr) {
        summits = summitArr; // static으로 변환하기 위함
        gates = gateArr; // static으로 변환하기 위함
        visitCount = new int[n + 1]; // 최대 두번까지 방문 가능

        // 왕복이므로 최대 두번까지 가능하도록 했지만, 어짜피 같은 출발지로 되돌아오기 떄문에 출발지 -> 정상 경로만 고려해도 될 것 같다.
        // 출발지 -> 정상 경로만 고려한다면, 다익스트라를 조금만 변형하는 방식으로 시도해볼 수 있을 것 같다.

        graph = new ArrayList<>();
        initGraph(n, paths);

        // 출발지 -> 정상 -> 동일한 출발지를 해겷하기위해 dfs를 사용
        for (int i = 1; i <= n; i++) {
            if (isGate(i)) {
                visitCount[i] += 1;
                dfs(n, i, i, false, 0, 0);
                visitCount[i] -= 1;
            }
        }

        return new int[]{minSummitNum, minIntensity}; // 산봉우리의 번호, intensity의 최솟값 반환
    }

    private void dfs(int n, int start, int current, boolean visitSummit, int maxIntensity, int summitNum) {
        // 산봉우리에 도착한 경우
        // start에 도착한 경우 -> 산봉우리를 먼저 가야한다.
        if (minIntensity < maxIntensity || (isGate(current) && current != start)) { // 탐색을 진행할 필요 없는 경우
            return;
        }

        if (current == start && visitSummit) { // 정상을 찍고 출발지로 되돌아온 경우
            if (maxIntensity < minIntensity) {
                minIntensity = maxIntensity;
                minSummitNum = summitNum;

            //intensity는 같지만, 이번 경로의 산봉우리 숫자가 더 작은 경우
            } else if (maxIntensity == minIntensity && minSummitNum > summitNum) {
                minSummitNum = summitNum;
            }

            return;
        }

        if (isSummit(current)) { // 현재 위치가 산봉우리인 경우
            if (visitSummit) { // 경로중에서 이미 산봉우리를 방문한 경우
                return;
            } else { // 경로 중에서 산봉우리를 처음 방문하는 경우
                summitNum = current;
                visitSummit = true;
            }
        }

        for (Node nextNode : graph.get(current)) {
            if (visitCount[nextNode.index] < 2) {
                visitCount[nextNode.index] += 1;
                dfs(n, start, nextNode.index, visitSummit, Math.max(maxIntensity, nextNode.cost), summitNum);
                visitCount[nextNode.index] -= 1;
            }
        }
    }

    private boolean isSummit(int index) {
        for (int summit : summits) {
            if (summit == index) {
                return true;
            }
        }
        return false;
    }

    private boolean isGate(int index) {
        for (int gate : gates) {
            if (gate == index) {
                return true;
            }
        }
        return false;
    }
    private void initGraph(int n, int[][] paths) {
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < paths.length; i++) {
            int[] path = paths[i];
            graph.get(path[0]).add(new Node(path[1], path[2]));
            graph.get(path[1]).add(new Node(path[0], path[2]));
        }
    }

    class Node {
        int index;
        int cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Solution T = new Solution();
        Scanner stdIn = new Scanner(System.in);

        int n = 6;
        int[][] paths = {{1, 2, 3}, {2, 3, 5}, {2, 4, 2}, {2, 5, 4}, {3, 4, 4}, {4, 5, 3}, {4, 6, 1}, {5, 6, 1}};
        int[] gates = {1, 3};
        int[] summits = {5};

        for (int i : T.solution(n, paths, gates, summits)) {
            System.out.print(i + " ");
        }
    }
}

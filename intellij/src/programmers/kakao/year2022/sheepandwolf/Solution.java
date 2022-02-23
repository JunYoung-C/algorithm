package programmers.kakao.year2022.sheepandwolf;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class SheepAndWolf {
    int sheep;
    int wolf;
    String route;

    public SheepAndWolf(int sheep, int wolf, String route) {
        this.sheep = sheep;
        this.wolf = wolf;
        this.route = route;
    }
}

public class Solution {
    public int solution(int[] info, int[][] edges) {
        int answer = 1;
        Queue<SheepAndWolf> que = new LinkedList<>();
        que.offer(new SheepAndWolf(1, 0, "0"));

        ArrayList<ArrayList<Integer>> graph = createGraph(info, edges);
//        for (ArrayList<Integer> arr : graph) {
//            for (int i : arr) {
//                System.out.print(i);
//            }
//            System.out.println();
//        }
        while (!que.isEmpty()) {
            SheepAndWolf now = que.poll();

            // now.route 에 속해있는 노드에서 나아갈 수 있는 경우들을 큐에 삽입
            for (String nowNodeStr : now.route.split(" ")) {
                for (int nextNode : graph.get(Integer.parseInt(nowNodeStr))) {
                    // nextNode가 route에 포함된 경우 방문 x
                    if (now.route.contains(String.valueOf(nextNode))) {
                        continue;
                    }
                    System.out.println(now.route + "->" + nextNode + ", sheep:" + now.sheep + ", wolf:" + now.wolf + ", answer:" + answer);
                    // 다음 노드가 양인 경우
                    if (info[nextNode] == 0) {
                        int nextSheep = now.sheep + 1;
                        answer = Math.max(answer, nextSheep);
                        que.offer(new SheepAndWolf(nextSheep, now.wolf, now.route + " " + nextNode));
                    } else {
                        // 양 <= 늑대일 경우 갈 수 없음
                        if (now.sheep > now.wolf + 1) {
                            que.offer(new SheepAndWolf(now.sheep, now.wolf + 1, now.route + " " + nextNode));
                        }
                    }
                }
            }
        }

        return answer;
    }

    private ArrayList<ArrayList<Integer>> createGraph(int[] info, int[][] edges) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int len = info.length;
        for (int i = 0; i <= len; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }
        return graph;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        Scanner stdIn = new Scanner(System.in);

//        int[] info = {0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1};
//        int[][] edges = {{0, 1}, {1, 2}, {1, 4}, {0, 8}, {8, 7}, {9, 10}, {9, 11}, {4, 3}, {6, 5}, {4, 6}, {8, 9}};

//        int[] info = {0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0};
//        int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}, {3, 7}, {4, 8}, {6, 9}, {9, 10}};

//        int[] info = {0, 1};
//        int[][] edges = {{0, 1}};

        int[] info = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}, {7, 8}, {8, 9}, {1, 10}, {10, 11}, {11, 12}, {12, 13}, {13, 14}, {14, 15}, {15, 16}};

//        int[] info = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
//        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}, {7, 8}, {8, 9}, {1, 10}, {10, 11}, {11, 12}, {12, 13}, {13, 14}, {14, 15}, {15, 16}};

        System.out.println(T.solution(info, edges));
    }
}

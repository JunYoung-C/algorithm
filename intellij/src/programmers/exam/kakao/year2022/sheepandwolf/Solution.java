package programmers.exam.kakao.year2022.sheepandwolf;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class SheepAndWolf {
    int sheep;
    int wolf;
    ArrayList<Integer> route;

    public SheepAndWolf(int sheep, int wolf, ArrayList<Integer> route) {
        this.sheep = sheep;
        this.wolf = wolf;
        this.route = route;
    }
}

public class Solution {
    public int solution(int[] info, int[][] edges) {
        int answer = 1;
        Queue<SheepAndWolf> que = new LinkedList<>();

        ArrayList<ArrayList<Integer>> graph = createGraph(info, edges);
//        for (ArrayList<Integer> arr : graph) {
//            for (int i : arr) {
//                System.out.print(i);
//            }
//            System.out.println();
//        }

        ArrayList<Integer> firstRoute = new ArrayList<>();
        for (int i : graph.get(0)) {
            firstRoute.add(i);
        }
        SheepAndWolf startSheepAndWolf = new SheepAndWolf(1, 0, firstRoute);
        que.offer(startSheepAndWolf);

        while (!que.isEmpty()) {
            SheepAndWolf now = que.poll();
            if (now.sheep <= now.wolf) {
                continue;
            }
            answer = Math.max(answer, now.sheep);
//            for (int i : now.route) {
//                System.out.print(i + " ");
//            }
//            System.out.println("->" + ", sheep:" + now.sheep + ", wolf:" + now.wolf + ", answer:" + answer);
            // 나아 수 있는 경우를 큐에 삽입
            for (int nowNode : now.route) {
                int nextSheep = now.sheep + (info[nowNode] ^ 1);
                int nextWolf = now.wolf + info[nowNode];
                ArrayList<Integer> nextRoute = new ArrayList<>();
                nextRoute.addAll(now.route);
                nextRoute.remove(Integer.valueOf(nowNode));
                for (int nextNode : graph.get(nowNode)) {
                    nextRoute.add(nextNode);
                }
                que.offer(new SheepAndWolf(nextSheep, nextWolf, nextRoute));
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

        int[] info = {0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1};
        int[][] edges = {{0, 1}, {1, 2}, {1, 4}, {0, 8}, {8, 7}, {9, 10}, {9, 11}, {4, 3}, {6, 5}, {4, 6}, {8, 9}};

//        int[] info = {0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0};
//        int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}, {3, 7}, {4, 8}, {6, 9}, {9, 10}};

//        int[] info = {0, 1};
//        int[][] edges = {{0, 1}};

//        int[] info = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
//        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}, {7, 8}, {8, 9}, {1, 10}, {10, 11}, {11, 12}, {12, 13}, {13, 14}, {14, 15}, {15, 16}};

//        int[] info = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
//        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}, {7, 8}, {8, 9}, {1, 10}, {10, 11}, {11, 12}, {12, 13}, {13, 14}, {14, 15}, {15, 16}};

        System.out.println(T.solution(info, edges));
    }
}

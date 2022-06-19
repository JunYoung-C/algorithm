package backjoon.graph.ex1948;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Road {
    int destination;
    int neededTime;

    public Road(int destination, int neededTime) {
        this.destination = destination;
        this.neededTime = neededTime;
    }
}

public class Main {
    public void solution(int cityCount, int roadCount, int[] inDegree, ArrayList<ArrayList<Road>> graph,
                         ArrayList<ArrayList<Road>> reverseGraph, int start, int end) {
        Queue<Road> que = new LinkedList<>();
        int[] maxNeededTime = new int[cityCount + 1];

        que.offer(new Road(start, 0));

        while (!que.isEmpty()) {
            Road currentRoad = que.poll();

            for (Road next : graph.get(currentRoad.destination)) {
                maxNeededTime[next.destination] = Math.max(
                        maxNeededTime[next.destination],
                        maxNeededTime[currentRoad.destination] + next.neededTime);

                if (--inDegree[next.destination] == 0) {
                    que.offer(next);
                }
            }
        }

        System.out.println(maxNeededTime[end]);

        boolean[] isVisited = new boolean[cityCount + 1];
        que = new LinkedList<>();
        que.offer(new Road(end, 0));
        isVisited[end] = true;
        int answer = 0;

        while (!que.isEmpty()) {
            Road currentRoad = que.poll();

            for (Road next : reverseGraph.get(currentRoad.destination)) {
                if (maxNeededTime[next.destination] + next.neededTime == maxNeededTime[currentRoad.destination]) {
                    answer++;

                    if (!isVisited[next.destination]) {
                        isVisited[next.destination] = true;
                        que.offer(next);
                    }
                }


            }
        }

        System.out.println(answer);

    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cityCount = Integer.parseInt(st.nextToken());
        int roadCount = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Road>> graph = new ArrayList<>();
        ArrayList<ArrayList<Road>> reverseGraph = new ArrayList<>();
        for (int i = 0; i <= cityCount; i++) {
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }
        int[] inDegree = new int[cityCount + 1];

        for (int i = 1; i <= roadCount; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            inDegree[b]++;
            graph.get(a).add(new Road(b, c));
            reverseGraph.get(b).add(new Road(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        br.close();
        T.solution(cityCount, roadCount, inDegree, graph, reverseGraph, start, end);
    }
}

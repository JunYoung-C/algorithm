package backjoon.graph.ex1516;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    public int[] solution(int n, int[] degree, int[] buildingTimes, ArrayList<ArrayList<Integer>> graph) {
        int[] cumulativeTimes = new int[n + 1];
        Queue<Integer> que = new LinkedList<>();
        for (int num = 1; num <= n; num++) {
            cumulativeTimes[num] = buildingTimes[num];
            if (degree[num] == 0) {
                que.offer(num);
            }
        }

        while (!que.isEmpty()) {
            int now = que.poll();
            // now와 연결된 숫자의 진입 차수 -1하기
            for (int next : graph.get(now)) {
                // 진입 차수가 0인 노드 큐에 삽입
                int sum = cumulativeTimes[now] + buildingTimes[next];
                if (sum > cumulativeTimes[next]) {
                    cumulativeTimes[next] = sum;
                }
                if (--degree[next] == 0) {
                    que.offer(next);
                }
            }
        }

        return cumulativeTimes;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[] buildingTimes = new int[n + 1];
        int[] degree = new int[n + 1];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            buildingTimes[i] = Integer.parseInt(st.nextToken());
            int num;
            while (st.hasMoreTokens()) {
                num = Integer.parseInt(st.nextToken());
                if (num == -1) {
                    break;
                }
                graph.get(num).add(i);
                degree[i]++;
            }
        }

        int[] times = T.solution(n, degree, buildingTimes, graph);
        for (int i = 1; i <= n; i++) {
            bw.write(times[i] + "\n");
        }

        bw.flush();
        bw.close();
    }
}

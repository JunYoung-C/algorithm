package backjoon.bfsdfs.ex16437;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static Status[] statusArr;
    boolean[] isVisited;

    public long solution(int n) {
        isVisited = new boolean[n + 1];
        isVisited[1] = true;
        return getSheepCount(1);
    }

    private long getSheepCount(int now) {
        long sheepCount = 0;
        Status status = statusArr[now];
        if (status != null) {
            sheepCount = status.isWolf ? -status.count : status.count;
        }

        for (int next : graph.get(now)) {
            if (!isVisited[next]) {
                isVisited[next] = true;
                sheepCount += getSheepCount(next);
                isVisited[next] = false;
            }
        }

        return Math.max(sheepCount, 0);
    }

    static class Status {
        boolean isWolf;
        int count;

        public Status(boolean isWolf, int count) {
            this.isWolf = isWolf;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        statusArr = new Status[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 2; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            String status = st.nextToken();
            int count = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());

            graph.get(i).add(a);
            graph.get(a).add(i);
            statusArr[i] = new Status(status.equals("W"), count);
        }

        br.close();
        bw.write(T.solution(n)+ "");
        bw.flush();
        bw.close();
    }
}

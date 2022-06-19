package template.graph.topologicalsort;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public ArrayList<Integer> solution(int studentCount, int compareCount, int[] inDegree, ArrayList<ArrayList<Integer>> graph) {
        ArrayList<Integer> answer = new ArrayList<>();
        Queue<Integer> que = new LinkedList<>();
        for (int node = 1; node <= studentCount; node++) {
            if (inDegree[node] == 0) {
                answer.add(node);
                que.offer(node);
            }
        }
        while (!que.isEmpty()) {
            int currentNode = que.poll();

            for (int next : graph.get(currentNode)) {
                if (--inDegree[next] == 0) {
                    answer.add(next);
                    que.offer(next);
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int studentCount = Integer.parseInt(st.nextToken());
        int compareCount = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[studentCount + 1];

        for (int i = 0; i <= studentCount; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < compareCount; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            inDegree[b]++;
        }

        br.close();
        for (int i: T.solution(studentCount, compareCount, inDegree, graph)) {
            bw.write(i + " ");

        }
        bw.flush();
        bw.close();
    }
}

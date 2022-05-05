package backjoon.tree.ex11438;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
    static int[][] p;
    static int[] depths;

    public String solution() {
        String answer = "";

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int nodeCount = Integer.parseInt(br.readLine());
        for (int i = 0; i <= nodeCount; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < nodeCount - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        depths = new int[nodeCount + 1];
        int depth = findDepthAndInitDepths(nodeCount);
        int k = findExponent(depth);

        p = new int[k + 1][nodeCount + 1];
        initArrayP(nodeCount, k);

        int findCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < findCount; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            if (depths[num1] > depths[num2]) {
                int tmp = num1;
                num1 = num2;
                num2 = tmp;
            }

            num2 = findSameDepthParent(num1, num2, k);

            bw.write(findLCA(num1, num2, k) + "\n");
        }

        bw.flush();
        bw.close();
    }

    private static int findLCA(int num1, int num2, int k) {

        for (int exponent = k; exponent >= 0 && num1 != num2; exponent--) {
            if (p[exponent][num1] != p[exponent][num2]) {
                num1 = p[exponent][num1];
                num2 = p[exponent][num2];
            }
        }

        int lca = num1;
        if (num1 != num2) {
            lca = p[0][num1];
        }
        return lca;
    }

    private static int findSameDepthParent(int shallowNum, int deepNum, int k) {

        for (int exponent = k; exponent >= 0; exponent--) {
            if (depths[deepNum] - depths[shallowNum] >= (int) Math.pow(2, exponent)) {
                if (depths[shallowNum] <= depths[p[exponent][deepNum]]) {
                    deepNum = p[exponent][deepNum];
                }
            }
        }

        return deepNum;
    }

    private static void initArrayP(int nodeCount, int k) {
        Queue<Integer> que = new LinkedList<>();
        boolean[] isVisited = new boolean[nodeCount + 1];
        que.offer(1);
        isVisited[1] = true;

        while (!que.isEmpty()) {
            int parent = que.poll();

            for (int child : tree.get(parent)) {
                if (!isVisited[child]) {
                    que.offer(child);
                    isVisited[child] = true;
                    p[0][child] = parent;
                }
            }
        }

        for (int exponent = 1; exponent <= k; exponent++) {
            for (int n = 1; n <= nodeCount; n++) {
                p[exponent][n] = p[exponent - 1][p[exponent - 1][n]];

            }
        }
    }

    private static int findExponent(int depth) {
        int k = 0;
        while (Math.pow(2, k) < depth) {
            k++;
        }
        return k;
    }

    private static int findDepthAndInitDepths(int nodeCount) {
        Queue<Integer> que = new LinkedList<>();
        boolean[] isVisited = new boolean[nodeCount + 1];
        que.offer(1);
        isVisited[1] = true;
        int depth = 0;

        while (!que.isEmpty()) {
            int len = que.size();

            for (int i = 0; i < len; i++) {
                int now = que.poll();
                depths[now] = depth;

                for (int next : tree.get(now)) {
                    if (!isVisited[next]) {
                        que.offer(next);
                        isVisited[next] = true;
                    }
                }
            }

            depth++;
        }

        return depth - 1;
    }
}

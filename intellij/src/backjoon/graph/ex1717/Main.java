package backjoon.graph.ex1717;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] parents;

    public int find(int a) {
        if (parents[a] == a) {
            return a;
        }
        return parents[a] = find(parents[a]);
    }

    public void unite(int a, int b) {
        parents[a] = b;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int maxNumber = Integer.parseInt(st.nextToken());
        int operationCount = Integer.parseInt(st.nextToken());
        parents = new int[maxNumber + 1];
        for (int i = 1; i <= maxNumber; i++) {
            parents[i] = i;
        }

        for (int operation = 0; operation < operationCount; operation++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (type == 0) {// 0 : 합집합
                int fa = T.find(a);
                int fb = T.find(b);
                if (fa != fb) {
                    T.unite(fa, fb);
                }
            } else { // 1 : 확인 연산
                if (hasSameParents(T, a, b)) {
                    bw.write("YES\n");
                } else {
                    bw.write("NO\n");
                }
            }
        }

        bw.flush();
        bw.close();
    }

    private static boolean hasSameParents(Main T, int a, int b) {
        return T.find(a) == T.find(b);
    }
}

package backjoon.graph.ex1717;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public int find(int a, int[] parent) {
        if (parent[a] == a) {
            return a;
        }

        return parent[a] = find(parent[a], parent);
    }

    public void unite(int a, int b, int[] parent) {
        int fa = find(a, parent);
        int fb = find(b, parent);

        if (fa != fb) {
            parent[fb] = fa;
        }
    }


    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numberCount = Integer.parseInt(st.nextToken());
        int operationCount = Integer.parseInt(st.nextToken());

        int[] parent = new int[numberCount + 1];
        for (int i = 1; i <= numberCount; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < operationCount; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken()); // 0이면 합집합, 1이면 같은 집합인지 확인
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (command == 0) {

                T.unite(a, b, parent);
            } else {
                int fa = T.find(a, parent);
                int fb = T.find(b, parent);

                bw.write((fa == fb ? "YES" : "NO") + "\n");

            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}

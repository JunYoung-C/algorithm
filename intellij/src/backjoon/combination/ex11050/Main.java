package backjoon.combination.ex11050;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    int[][] combination = new int[11][11];

    public int solution(int n, int k) {
        return combine(n, k);
    }

    private int combine(int n, int r) {
        if (combination[n][r] != 0) {
            return combination[n][r];
        }

        if (r == 0 || n == r) {
            return 1;
        } else if (r == 1 || n - r == 1) {
            return n;
        }

        return combination[n][r] = combine(n - 1, r - 1) + combine(n - 1, r);
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        br.close();
        bw.write(T.solution(n, k)+ "");
        bw.flush();
        bw.close();
    }
}

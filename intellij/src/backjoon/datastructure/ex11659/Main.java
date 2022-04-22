package backjoon.datastructure.ex11659;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public int solution(int[] sums, int start, int end) {
        return sums[end] - sums[start - 1];
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] numbers = new int[n + 1];
        int[] sums = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        calculateSums(n, numbers, sums);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            bw.write(T.solution(sums, start, end)+ "\n");
        }

        bw.flush();
        bw.close();
    }

    private static void calculateSums(int n, int[] numbers, int[] sums) {
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + numbers[i];
        }
    }
}

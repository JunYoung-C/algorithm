package backjoon.datastructure.ex10986;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public long solution(int n, int divider, long[] numbers) {
        long answer = 0;
        long[] remainderCounts = new long[divider];
        // 누적합으로 변환
        for (int i = 1; i < n; i++) {
            numbers[i] += numbers[i - 1];
        }

        for (int i = 0; i < n; i++) {
            remainderCounts[(int)(numbers[i] % divider)]++;
        }

        answer += remainderCounts[0];
        for (int i = 0; i < divider; i++) {
            if (remainderCounts[i] > 1) {
                answer += remainderCounts[i] * (remainderCounts[i] - 1) / 2;
            }
        }

        return answer;
    }


    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int divider = Integer.parseInt(st.nextToken());

        long[] numbers = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(T.solution(n, divider, numbers)+ "");
        bw.flush();
        bw.close();
    }
}

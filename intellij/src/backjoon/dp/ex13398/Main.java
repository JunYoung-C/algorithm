package backjoon.dp.ex13398;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public int solution(int n, int[] numbers) {
        int[] leftDp = new int[n];
        int[] rightDp = new int[n];
        leftDp[0] =numbers[0];
        rightDp[n - 1] = numbers[n - 1];
        int answer = leftDp[0];
        for (int i = 1; i < n; i++) {
            leftDp[i] = Math.max(numbers[i], numbers[i] + leftDp[i - 1]);
            answer = Math.max(answer, leftDp[i]);
        }

        for (int i = n - 2; i >= 0; i--) {
            rightDp[i] = Math.max(numbers[i], numbers[i] + rightDp[i + 1]);
        }

        for (int i = 1; i < n - 1; i++) {
            answer = Math.max(answer, leftDp[i - 1] + rightDp[i + 1]);
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        br.close();
        bw.write(T.solution(n, numbers)+ "");
        bw.flush();
        bw.close();
    }
}

package backjoon.dp.ex14002;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public void solution(int n, int[] numbers) {
        int[] dp = new int[n];
        initDP(n, numbers, dp);

        int maxIdx = -1;
        int maxRank = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] > maxRank) {
                maxRank = dp[i];
                maxIdx = i;
            }
        }

        System.out.println(maxRank);

        ArrayList<Integer> subNumbers = new ArrayList<>();
        subNumbers.add(numbers[maxIdx]);
        int currentRank = maxRank;
        int currentIdx = maxIdx;
        for (int i = maxIdx - 1; i >= 0; i--) {
            if (numbers[currentIdx] > numbers[i] && currentRank - 1 == dp[i]) {
                subNumbers.add(numbers[i]);
                currentIdx = i;
                currentRank -= 1;
            }

            if (currentRank == 0) {
                break;
            }
        }

        for (int i = subNumbers.size() - 1; i >= 0; i--) {
            System.out.print(subNumbers.get(i) + " ");
        }
    }

    private void initDP(int n, int[] numbers, int[] dp) {
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (numbers[i] > numbers[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] numbers = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        br.close();
        T.solution(n, numbers);
    }
}


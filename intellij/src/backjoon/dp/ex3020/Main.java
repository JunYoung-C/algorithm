package backjoon.dp.ex3020;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public void solution(int width, int height, ArrayList<Integer> lengthList) {
        int[] dp = new int[height + 2];
        boolean isLandTurn = true;
        for (int length : lengthList) {
            if (isLandTurn) {
                dp[1] += 1;
                dp[1 + length] -= 1;
            } else {
                dp[height + 1] -= 1;
                dp[height - length + 1] += 1;
            }
            isLandTurn = !isLandTurn;
        }

        int min = Integer.MAX_VALUE;
        int count = 0;
        for (int i = 1; i <= height; i++) {
            dp[i] += dp[i - 1];
            if (min > dp[i]) {
                min = dp[i];
                count = 1;
            } else if (min == dp[i]) {
                count++;
            }
        }

        System.out.print(min + " " + count);
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());

        ArrayList<Integer> lengthList = new ArrayList<>();
        for (int i = 0; i < width; i++) {
            lengthList.add(Integer.parseInt(br.readLine()));
        }
        br.close();
        T.solution(width, height, lengthList);
    }
}

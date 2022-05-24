package backjoon.dp.ex9252;

import java.io.*;

public class Main {
    public String[] solution(String str1, String str2) {
        String[] answer = new String[2];
        int len1 = str1.length();
        int[] dp = new int[len1 + 1];

        for (char c : str2.toCharArray()) {
            for (int i = 0; i < len1; i++) {
                if (str1.charAt(i) == c) {
                    dp[i + 1] = dp[i] + 1;
                } else {
                    dp[i + 1] = Math.max(dp[i], dp[i + 1]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len1; i++) {
            if (dp[i + 1] > dp[i]) {
                sb.append(str1.charAt(i));
            }
        }

        answer[0] = String.valueOf(dp[len1]);
        answer[1] = sb.toString();
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str1 = br.readLine();
        String str2 = br.readLine();

        String[] answer = T.solution(str1, str2);
        bw.write(answer[0] + "\n" + answer[1]);
        bw.flush();
        bw.close();
    }
}

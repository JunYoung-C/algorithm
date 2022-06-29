package backjoon.combination.ex1722;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        long[] dp = new long[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] * i;
        }

        st = new StringTokenizer(br.readLine());
        int command = Integer.parseInt(st.nextToken());
        if (command == 1) {
            // k번째 수열 출력
            long order = Long.parseLong(st.nextToken()) - 1;
            for (int num = n; num > 1; num--) {
                int index = (int)(order / dp[num - 1]);
                System.out.print(numbers.get(index) + " ");
                numbers.remove(index);
                order %= dp[num - 1];
            }

            System.out.print(numbers.get(0) + " ");

        } else {
            // 수열에 해당되는 순서 출력
            long order = 1;
            for (int i = 1; i <= n; i++) {
                int number = Integer.parseInt(st.nextToken());
                order += (long) numbers.indexOf(number) * dp[(numbers.size() - 1)];
                numbers.remove((Integer) number);
            }
            System.out.println(order);
        }

        br.close();
        bw.flush();
        bw.close();
    }
}

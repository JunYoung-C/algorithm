package backjoon.greedy.ex11047;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public int solution(int kinds, int target, int[] coins) {
        int answer = 0;
        for (int i = kinds - 1; i >= 0; i--) {
            answer += target / coins[i];
            target %= coins[i];
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int kinds = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int[] coins = new int[kinds];
        for (int i = 0; i < kinds; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        br.close();
        bw.write(T.solution(kinds, target, coins) + "");
        bw.flush();
        bw.close();
    }
}

package backjoon.greedy.ex1715;

import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public long solution(int n, PriorityQueue<Long> cardQue) {
        long answer = 0;
        long sum;
        while (cardQue.size() > 1) {
            sum = cardQue.poll() + cardQue.poll();
            answer += sum;
            cardQue.offer(sum);
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Long> cardQue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            cardQue.offer(Long.parseLong(br.readLine()));
        }

        br.close();
        bw.write(T.solution(n, cardQue)+ "");
        bw.flush();
        bw.close();
    }
}

package backjoon.binarysearch.ex1300;

import java.util.Scanner;

public class Main {
    public long solution(int n, int k) {
        long answer = 0;
        long lt = 1,rt = k;

        while (lt <= rt) {
            long mid = (lt + rt) / 2;

            long count = 0;
            for (int i = 1; i <= n; i++) {
                count += Math.min(n, mid / i);
            }

            if (count >= k) {
                answer = mid;
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner stdIn = new Scanner(System.in);

        int n = stdIn.nextInt();
        int k = stdIn.nextInt();
        System.out.println(T.solution(n, k));
    }
}

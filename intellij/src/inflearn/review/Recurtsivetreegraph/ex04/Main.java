package inflearn.review.Recurtsivetreegraph.ex04;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Main T = new Main();
        Scanner stdIn = new Scanner(System.in);

        int n = stdIn.nextInt();
        int[] answer = new int[n + 1];
        answer[1] = 1;
        for (int i = 2; i <= n; i++) {
            answer[i] = answer[i - 1] + answer[i - 2];
        }

        for (int i : answer) {
            System.out.print(i + " ");
        }
    }
}

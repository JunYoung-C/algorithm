package inflearn.review.Recurtsivetreegraph.ex01;

import java.util.Scanner;

public class Main {
    public void solution(int n) {
        if (n <= 0) {
            return;
        }
        solution(n - 1);
        System.out.print(n + " ");

    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner stdIn = new Scanner(System.in);
        int n = stdIn.nextInt();
        T.solution(n);
    }
}

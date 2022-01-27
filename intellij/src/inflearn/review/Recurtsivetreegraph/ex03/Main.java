package inflearn.review.Recurtsivetreegraph.ex03;

import java.util.Scanner;

public class Main {
    public int solution(int n) {
        if (n == 0) {
            return 1;
        }

        return n * solution(n - 1);
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner stdIn = new Scanner(System.in);

        int n = stdIn.nextInt();
        System.out.println(T.solution(n));
    }
}

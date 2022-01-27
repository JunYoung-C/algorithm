package inflearn.review.Recurtsivetreegraph.ex02;

import java.util.Scanner;

public class Main {
    public String solution(int n) {
        String answer = "";
        answer = Integer.toBinaryString(n);
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner stdIn = new Scanner(System.in);

        int n = stdIn.nextInt();
        System.out.println(T.solution(n));
    }
}

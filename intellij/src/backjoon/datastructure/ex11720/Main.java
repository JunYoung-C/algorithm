package backjoon.datastructure.ex11720;

import java.util.Scanner;

public class Main {
    public String solution(int n, String str) {
        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer += str.charAt(i) - '0';
        }

        return String.valueOf(answer);
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner stdIn = new Scanner(System.in);

        int n = stdIn.nextInt();
        String str = stdIn.next();

        System.out.println(T.solution(n, str));
    }
}

package backjoon.bruteforce.좋은수열;

import java.util.Scanner;

public class Main {
    String answer = "";
    boolean flag = false;

    public String solution(int n) {

        dfs("1", n);

        return answer;
    }

    private void dfs(String number, int n) {
        if (flag) {
            return;
        }

        for (int i = number.length() - 1; i >= (number.length() + 1) / 2; i--) {
            if (number.substring(0, i).endsWith(number.substring(i))) {
                return;
            }
        }

        if (number.length() == n) {
            answer = number;
            flag = true;
            return;
        }

        for (int i = 1; i <= 3; i++) {
            dfs(number + i, n);
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner stdIn = new Scanner(System.in);

        int n = stdIn.nextInt();

        System.out.println(T.solution(n));
    }
}

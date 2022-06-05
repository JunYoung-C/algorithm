package backjoon.datastructure.ex2018;

import java.util.Scanner;

public class Main {
    public int solution(int n) {
        int answer = 0;
        int lt = 1;
        int sum = 0;
        for (int rt = 1; rt <= n; rt++) {
            sum += rt;
            if (sum < n) {
                continue;
            } else if (sum == n) {
                answer++;
                sum -= lt++;
                continue;
            }

            while (sum > n) {
                sum -= lt++;
                if (sum == n) {
                    answer++;
                }
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner stdIn = new Scanner(System.in);

        System.out.println(T.solution(stdIn.nextInt()));
    }
}

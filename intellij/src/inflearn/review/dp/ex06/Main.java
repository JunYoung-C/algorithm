package inflearn.review.dp.ex06;

import java.util.Scanner;

class Problem {
    int point;
    int time;

    public Problem(int point, int time) {
        this.point = point;
        this.time = time;
    }
}
public class Main {
    public int solution(int n, int limitTime, Problem[] problems) {
        int answer = 0;
        int[] dp = new int[limitTime + 1];
        for (Problem problem : problems) {
            for (int time = limitTime; time >= problem.time; time--) {
                dp[time] = Math.max(dp[time], dp[time - problem.time] + problem.point);
            }
        }
        answer = dp[limitTime];
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner stdIn = new Scanner(System.in);

        int n = stdIn.nextInt();
        int limitTime = stdIn.nextInt();
        Problem[] problems = new Problem[n];
        for (int i = 0; i < n; i++) {
            problems[i] = new Problem(stdIn.nextInt(), stdIn.nextInt());
        }
        System.out.println(T.solution(n, limitTime, problems));
    }
}

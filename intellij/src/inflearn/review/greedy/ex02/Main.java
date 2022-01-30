package inflearn.review.greedy.ex02;

import java.util.*;

class Conf implements Comparable<Conf> {
    int start;
    int end;

    public Conf(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Conf o) {
        if (this.end == o.end) {
            return this.start - o.end;
        }
        return this.end - o.end;
    }
}

public class Main {
    public int solution(int n, Conf[] conferences) {
        int answer = 0;
        Arrays.sort(conferences);
        int prevEndTime = 0;

        for (Conf conf : conferences) {
            if (prevEndTime <= conf.start) {
                answer++;
                prevEndTime = conf.end;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner stdIn = new Scanner(System.in);

        int n = stdIn.nextInt();
        Conf[] conferences = new Conf[n];
        for (int i = 0; i < n; i++) {
            int st = stdIn.nextInt();
            int et = stdIn.nextInt();
            conferences[i] = new Conf(st, et);
        }
        System.out.println(T.solution(n, conferences));
    }
}

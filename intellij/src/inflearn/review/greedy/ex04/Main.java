package inflearn.review.greedy.ex04;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Lecture implements Comparable<Lecture> {
    int day;
    int money;

    public Lecture(int day, int money) {
        this.day = day;
        this.money = money;
    }

    @Override
    public int compareTo(Lecture o) {
        return o.day - this.day;
    }
}

public class Main {
    public int solution(int n, Lecture[] lectures) {
        int answer = 0;
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Comparator.reverseOrder());
        Arrays.sort(lectures);
        int i = 0;

        for (int now = lectures[0].day; now >= 1; now--) {
            for (; i < n; i++) {
                if (now == lectures[i].day) {
                    pQ.offer(lectures[i].money);
                } else {
                    break;
                }
            }

            if (!pQ.isEmpty()) {
                answer += pQ.poll();
            }
        }

//        while (i < n) {
//            int now = lectures[i].day;
//            for (; i < n; i++) {
//                if (now == lectures[i].day) {
//                    pQ.offer(lectures[i].money);
//                } else {
//                    break;
//                }
//            }
//
//            if (!pQ.isEmpty()) {
//                answer += pQ.poll();
//            }
//        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner stdIn = new Scanner(System.in);

        int n = stdIn.nextInt();
        Lecture[] lectures = new Lecture[n];
        for (int i = 0; i < n; i++) {
            int m = stdIn.nextInt();
            int d = stdIn.nextInt();
            lectures[i] = new Lecture(d, m);
        }
        System.out.println(T.solution(n, lectures));
    }
}

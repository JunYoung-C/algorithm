package backjoon.datastructure.stackque.ex2164;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public int solution(int n) {
        Queue<Integer> que = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            que.offer(i);
        }
        while (que.size() > 1) {
            que.poll();
            que.offer(que.poll());
        }

        return que.poll();
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner stdIn = new Scanner(System.in);

        int n = stdIn.nextInt();

        System.out.println(T.solution(n));
    }
}

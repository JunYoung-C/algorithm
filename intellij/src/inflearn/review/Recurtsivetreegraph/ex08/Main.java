package inflearn.review.Recurtsivetreegraph.ex08;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public int solution(int start, int end) {
        int answer = -1;
        Queue<Integer> que = new LinkedList<>();
        que.offer(start);
        boolean[] isVisited = new boolean[10001];
        isVisited[start] = true;
        int cnt =1;
        int[] moves = {1, -1, 5};

        while (!que.isEmpty()) {
            int len = que.size();
            for (int i = 0; i < len; i++) {
                int now = que.poll();

                for (int dir = 0; dir < moves.length; dir++) {
                    int next = now + moves[dir];
                    if (next == end) {
                        return cnt;
                    }
                    if (next >= 1 && next <= 10000 && !isVisited[next]) {
                        isVisited[next] = true;
                        que.offer(next);
                    }
                }
            }

            cnt++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner stdIn = new Scanner(System.in);

        int start = stdIn.nextInt();
        int end = stdIn.nextInt();

        System.out.println(T.solution(start, end));
    }
}

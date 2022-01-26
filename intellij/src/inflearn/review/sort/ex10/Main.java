package inflearn.review.sort.ex10;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public int solution(int homeCnt, int horCnt, int[] homes) {
        int answer = -1;
        int lt = 1;
        int rt = homes[homeCnt - 1] - homes[0];
        Arrays.sort(homes);

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (countBatchedHorse(mid, homes, homeCnt) < horCnt) {
                rt = mid - 1;
            } else {
                answer = mid;
                lt = mid + 1;
            }
        }

        return answer;
    }

    int countBatchedHorse(int len, int[] homes, int homeCnt) {
        int cnt = 1;
        int prev = homes[0];

        for (int i = 1; i < homeCnt; i++) {
            if (homes[i] - prev >= len) {
                cnt++;
                prev = homes[i];
            }
        }

        return cnt;
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner stdIn = new Scanner(System.in);

        int homeCnt = stdIn.nextInt();
        int horCnt = stdIn.nextInt();
        int[] points = new int[homeCnt];
        for (int i = 0; i < homeCnt; i++) {
            points[i] = stdIn.nextInt();
        }
        System.out.println(T.solution(homeCnt, horCnt, points));
    }
}

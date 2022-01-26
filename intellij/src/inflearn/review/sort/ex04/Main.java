package inflearn.review.sort.ex04;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public int[] solution(int cachesLen, int worksLen, int[] works) {
        ArrayList<Integer> cachesList = new ArrayList<Integer>();
        int[] answer = new int[cachesLen];
        int cnt = 0; // 캐시의 개수, cachesLen보다 작다면 해당 인덱스의 값은 0이다.

        for (int work : works) {

            if (cachesList.contains(work)) {
                cachesList.remove(cachesList.indexOf(work));
            } else {
                if (cachesList.size() >= cachesLen) {
                    cachesList.remove(cachesLen - 1);
                }
            }
            cachesList.add(0, work);
        }

        for (int i = 0; i < cachesLen; i++) {
            answer[i] = cachesList.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner stdIn = new Scanner(System.in);

        int cachesLen = stdIn.nextInt();
        int worksLen = stdIn.nextInt();
        int[] works = new int[worksLen];
        for (int i = 0; i < worksLen; i++) {
            works[i] = stdIn.nextInt();
        }
        for (int i : T.solution(cachesLen, worksLen, works)) {
            System.out.print(i + " ");
        }
    }
}

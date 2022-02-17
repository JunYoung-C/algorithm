package programmers.binarysearch.lv4.stepbridge;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public int solution(int distance, int[] rocks, int n) {
        long answer = 0;
        long lt = 1, rt = distance;
        Arrays.sort(rocks);

        while (lt <= rt) {
            long mid = (lt + rt) / 2;
            int removedCnt = getRemovedCnt(mid, distance, rocks);
//            System.out.println("mid:" + mid + ", getRemovedCnt:" + removedCnt);
            if (removedCnt > n) {
                rt = mid - 1;
            } else {
                answer = mid;
                lt = mid + 1;
            }
        }
        return (int)answer;
    }

    private int getRemovedCnt(long standardNum, int end, int[] rocks) {
        int[] modifiedRocks = createModifiedRocks(end, rocks);
        int cnt = 0;
        int lt = 0, rt = 1;
        int len = modifiedRocks.length;

//        System.out.print("standardNum: " + standardNum + ", dif: ");
        for (; rt < len; rt++) {
            int dif = modifiedRocks[rt] - modifiedRocks[lt];
//            System.out.print(dif + " ");
            if (dif < standardNum) {
                cnt++;
            } else {
                lt = rt;
            }
        }
//        System.out.println();

        return cnt;
    }

    private int[] createModifiedRocks(int end, int[] rocks) {
        int[] modifiedRocks = new int[rocks.length + 2];
        int i = 1;
        for (int rock : rocks) {
            modifiedRocks[i++] = rock;
        }

        modifiedRocks[modifiedRocks.length - 1] = end;
        return modifiedRocks;
    }


    public static void main(String[] args) {
        Solution T = new Solution();
        Scanner stdIn = new Scanner(System.in);

        int distance = 25;
        int[] rocks = {2, 14, 11, 21, 17};
        int n = 2;

        distance = 1000000000;
        rocks = new int[] {500000000};
        n = 1;
        System.out.println(T.solution(distance, rocks, n));
    }
}

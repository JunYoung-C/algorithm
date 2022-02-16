package programmers.binarysearch.lv3.importtest;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        long lt = 1, rt = Long.MAX_VALUE / 2;

        while (lt <= rt) {
            long mid = (lt + rt) / 2;

            if (getTestCount(mid, times) >= (long) n) {
                answer = mid;
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }
        return answer;
    }

    private long getTestCount(long num, int[] times) {
        long cnt = 0;
        for (int time : times) {
            cnt += num / time;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        Scanner stdIn = new Scanner(System.in);

        int n = 6;
        int[] times = {7, 10};

//        n = 1000000000;
//        times = new int[5];
//        for (int i = 0; i < 5; i++) {
//            times[i] = 1000000000;
//        }
        System.out.println(T.solution(n, times));
    }
}

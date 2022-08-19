package programmers.lv3.스티커모으기2;

import java.util.*;

class Solution {
    public int solution(int sticker[]) {
        int answer = 0;
        int len = sticker.length;
        if (len == 1) {
            return sticker[0];
        } else if (len == 2) {
            return Math.max(sticker[0], sticker[1]);
        }
        int[] dp1 = new int[len];
        int[] dp2 = new int[len];
        dp1[1] = sticker[0];
        dp1[2] = sticker[1];
        dp2[1] = sticker[1];
        dp2[2] = sticker[2];
        for (int i = 3; i < len; i++) {
            dp1[i] = Math.max(dp1[i - 2], dp1[i - 3]) + sticker[i - 1];
            dp2[i] = Math.max(dp2[i - 2], dp2[i - 3]) + sticker[i];
        }

        // for (int i : dp1) {
        //     System.out.print(i + " ");
        // }
        // System.out.println();
        // for (int i : dp2) {
        //     System.out.print(i + " ");
        // }

        answer = Math.max(Math.max(dp1[len - 1], dp1[len - 2]),
                Math.max(dp2[len - 1], dp2[len - 2]));
        return answer;
    }
}

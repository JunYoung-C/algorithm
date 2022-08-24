package programmers.kakao.lv3.징검다리건너기;

import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int lt = 1, rt = 200000000;

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            int count = getMaxContinuousZeroStepCount(mid, stones);
            if (count >= k) {
                answer = mid;
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }

        }
        return answer;
    }

    private int getMaxContinuousZeroStepCount(int minusValue, int[] stones) {
        int result = 0;

        int count = 0;
        for (int stone : stones) {
            if (stone - minusValue <= 0) {
                count++;
            } else {
                result = Math.max(result, count);
                count = 0;
            }
        }
        result = Math.max(result, count);

        return result;
    }
}

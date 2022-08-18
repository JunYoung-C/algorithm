package programmers.lv3.선입선출스케줄링;

import java.util.*;

class Solution {
    public int solution(int n, int[] cores) {
        int answer = 0;
        int len = cores.length;
        if (n <= len) {
            return n;
        }

        int lt = 1, rt = 250000000;
        while (lt <= rt) {
            int mid = (lt + rt) / 2; // 몇초과 경과되었는지 의미. 0일 때는 처리 수 len개

            if (getProcessCount(mid, cores) >= n) {
                answer = mid;
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }

        ArrayList<Integer> targetCores = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (answer % cores[i] == 0) {
                targetCores.add(i + 1);
            }
        }

        int index = targetCores.size() - 1 - (int)(getProcessCount(answer, cores) - n);

        return targetCores.get(index);
    }

    private long getProcessCount(int passedTime, int[] cores) {
        long count = cores.length;

        for (int core : cores) {
            count += passedTime / core;
        }

        return count;
    }
}

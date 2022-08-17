package programmers.lv3.선입선출스케줄링;

import java.util.*;

class Solution {
    public int solution(int n, int[] cores) {
        int answer = 0;
        int len = cores.length;
        if (n <= len) {
            return cores[n - 1];
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
        for (int core : cores) {
            if (answer % core == 0) {
                targetCores.add(core);
            }
        }
        int index = targetCores.size() - 1 - (int)(getProcessCount(answer, cores) - n);

        System.out.println(answer);
        System.out.println(index);
        System.out.println(targetCores.size() - 1);
        System.out.println(getProcessCount(answer, cores) - n);
        return targetCores.get(index);
    }

    private long getProcessCount(int passedTime, int[] cores) {
        int len = cores.length;
        long count = len;

        for (int core : cores) {
            count += passedTime / core;
        }

        return count;
    }
}

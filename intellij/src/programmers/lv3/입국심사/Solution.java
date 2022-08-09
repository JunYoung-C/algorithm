package programmers.lv3.입국심사;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        long lt = 1, rt = Long.MAX_VALUE / 4;
        while (lt <= rt) {
            long mid = (lt + rt) / 2;
            if (getTestCount(mid, times, n) >= n) {
                answer = mid;
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }

        return answer;
    }

    private long getTestCount(long targetTime, int[] times, int n) {
        long count = 0;
        for (int time : times) {
            count += targetTime / time;
            if (count > n) {
                return n + 1;
            }
        }

        return count;
    }
}
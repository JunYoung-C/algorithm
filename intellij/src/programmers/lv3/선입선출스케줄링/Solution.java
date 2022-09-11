package programmers.lv3.선입선출스케줄링;

class Solution {
    public int solution(int n, int[] cores) {
        int len = cores.length;
        if (n <= len) {
            return n;
        }

        int answer = 0;
        int lt = 1, rt = 250_000_000;

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            long count = getProcessCount(mid, cores);

            if (count >= n) {
                answer = mid;
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }

        long count = getProcessCount(answer, cores);
        // System.out.println(answer + " " + count);
        for (int i = len - 1; i >= 0; i--) {
            if (answer % cores[i] != 0) {
                continue;
            }

            if (count == n) {
                return i + 1;
            } else {
                count--;
            }
        }

        return answer;
    }

    private long getProcessCount(int time, int[] cores) {
        long count = cores.length;

        for (int core : cores) {
            count += time / core;
        }

        return count;
    }
}

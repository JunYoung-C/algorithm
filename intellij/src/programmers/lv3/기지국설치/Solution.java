package programmers.lv3.기지국설치;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        int prevRt = 0;
        int lt, rt;
        for (int station : stations) {
            lt = station - w;
            rt = station + w;
            if (lt < 1) {
                lt = 1;
            }
            if (rt > n) {
                rt = n;
            }

            if (prevRt >= lt || lt == 1) {
                prevRt = rt;
                continue;
            }

            answer += Math.ceil((double)(lt - 1 - prevRt) / (2 * w + 1));
            prevRt = rt;
        }

        answer += Math.ceil((double)(n - prevRt) / (2 * w + 1));

        return answer;
    }
}

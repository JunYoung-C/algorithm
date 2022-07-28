package programmers.lv2.삼각달팽이;

class Solution {
    public int[] solution(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + i;
        }

        int[] answer = new int[dp[n]];
        int index = 0;
        int len = n;
        int count = 0;
        int status = 0; // 0 : 왼쪽 아래로, 1 : 오른쪽으로, 2 : 오른쪽 위로
        int plusValue = 0;
        int minusValue = 0;
        for (int num = 1; num <= n; num++) {
            answer[index] = num;
            count++;
            if (count == len) {
                status = (status + 1) % 3;
                len--;
                if (status == 0) {

                } else if (status == 1) {
                    minusValue = len + 1;
                }
            }

            // 인덱스 전환
            if (status == 0) {

            } else if (status == 1) {
                index++;
            } else {
                index -= minusValue;
                minusValue--;
            }
        }


        return answer;
    }
}

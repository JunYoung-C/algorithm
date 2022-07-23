package programmers.lv2.숫자의표현;

class Solution {
    public int solution(int n) {
        int answer = 0;

        // System.out.println(getSum(10, 10));
        int lt = 1, rt = 1;
        while (rt <= n && lt <= n) {
            if (lt > rt) {
                rt++;
                continue;
            }

            int sum = getSum(lt, rt);

            if (sum > n) {
                lt++;
            } else if (sum < n) {
                rt++;
            } else {
                answer++;
                lt++;
                rt++;
            }
        }

        return answer;
    }

    private int getSum(int lt, int rt) {
        return (lt + rt) * (rt - lt + 1) / 2;
    }
}

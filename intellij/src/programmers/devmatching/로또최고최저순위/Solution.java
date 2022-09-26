package programmers.devmatching.로또최고최저순위;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int len = lottos.length;

        int zeroCount = 0;
        int matchingCount = 0;

        for (int num : lottos) {
            if (num == 0) {
                zeroCount++;
            } else if (isMatching(num, win_nums)) {
                matchingCount++;
            }
        }

        answer[0] = getRank(matchingCount + zeroCount);
        answer[1] = getRank(matchingCount);

        return answer;
    }

    private boolean isMatching(int myNumber, int[] winNumbers) {
        for (int num : winNumbers) {
            if (myNumber == num) {
                return true;
            }
        }

        return false;
    }

    private int getRank(int matchingCount) {
        if (matchingCount <= 1) {
            return 6;
        } else {
            return 7 - matchingCount;
        }
    }
}

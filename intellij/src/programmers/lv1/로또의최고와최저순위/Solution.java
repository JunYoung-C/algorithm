package programmers.lv1.로또의최고와최저순위;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int minCount = 0;
        int maxCount = 0;
        for (int num : lottos) {
            if (num == 0) {
                maxCount++;
            }
        }

        for (int myNum : lottos) {
            for (int num : win_nums) {
                if (myNum == num) {
                    minCount++;
                    maxCount++;
                    break;
                }
            }
        }

        answer[0] = 7 - maxCount >= 6 ? 6 : 7 - maxCount;
        answer[1] = 7 - minCount >= 6 ? 6 : 7 - minCount;
        return answer;
    }
}

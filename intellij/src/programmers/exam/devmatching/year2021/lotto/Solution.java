package programmers.exam.devmatching.year2021.lotto;

import java.util.Scanner;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int minSame = 0, maxSame = 0;
        int zeroCnt = 0;
        for (int num : lottos) {
            for (int winNum : win_nums) {
                if (num == winNum) {
                    minSame++;
                    break;
                } else if (num == 0) {
                    zeroCnt++;
                    break;
                }

            }
        }
        maxSame = minSame + zeroCnt;

        if (7 - minSame <= 5) {
            answer[1] = 7 - minSame;
        } else {
            answer[1] = 6;
        }

        if (7 - maxSame <= 5) {
            answer[0] = 7 - maxSame;
        } else {
            answer[0] = 6;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        Scanner stdIn = new Scanner(System.in);

//        int[] lottos = {44, 1, 0, 0, 31, 25};
//        int[] win_nums = {31, 10, 45, 1, 6, 19};

//        int[] lottos = {0, 0, 0, 0, 0, 0};
//        int[] win_nums = {38, 19, 20, 40, 15, 25};

        int[] lottos = {45, 4, 35, 20, 3, 9};
        int[] win_nums = {20, 9, 3, 45, 4, 35};

        for (int i : T.solution(lottos, win_nums)) {
            System.out.print(i + " ");
        }
    }
}

package programmers.kakao.year2022.양궁대회;

import java.util.ArrayList;
import java.util.Collections;

class Solution {
    String bestResult = "";
    int maxPoint = Integer.MIN_VALUE;
    int[] apeachResult;

    public int[] solution(int n, int[] info) {
        int len = info.length;
        int[] answer = new int[len];
        apeachResult = info;
        setResults(0, "", len, n, n);

        if (maxPoint <= 0) {
            return new int[] {-1};
        }
        for (int i = 0; i < bestResult.length(); i++) {
            answer[i] = bestResult.charAt(i) - 'a';
        }
        return answer;
    }

    private void setResults(int depth, String result, int len, int remainArrow, int totalArrow) {
        if (result.length() >= 12) {
            return;
        }

        if (remainArrow == 0) {
            int point = 0;

            int i = 0;
            for (; i < result.length(); i++) {
                int lionArrow = result.charAt(i) - 'a';

                if (lionArrow == 0 && apeachResult[i] == 0) {
                    continue;
                }

                if (lionArrow > apeachResult[i]) {
                    point += 10 - i;
                } else {
                    point -= 10 - i;
                }
            }

            for (;i < len; i++) {
                if (apeachResult[i] > 0) {
                    point -= 10 - i;
                }
            }

            if (maxPoint < point) {
                maxPoint = point;
                bestResult = result;
                // System.out.println(point);
            } else if (maxPoint == point) {
                // 비교 후 bestResult 선택
                if (result.length() > bestResult.length()) {
                    bestResult = result;
                } else if (result.length() == bestResult.length()) {
                    if (result.compareTo(bestResult) <= -1) {
                        bestResult = result;
                    }
                }
                // System.out.println(point);
            }

            return;
        }

        for (char arrow = 'a'; arrow <= remainArrow + 'a'; arrow++) {
            setResults(depth + 1, result + arrow, len, remainArrow - (arrow - 'a'), totalArrow);
        }
    }

    public static void main(String[] args) {
        Solution T = new Solution();

//        int n = 5;
//        int[] info = {2,1,1,1,0,0,0,0,0,0,0};

//        int n = 1;
//        int[] info = {1,0,0,0,0,0,0,0,0,0,0};

//        int n = 9;
//        int[] info = {0,0,1,2,0,1,1,1,1,1,1};

        int n = 10;
        int[] info = {0,0,0,0,0,0,0,0,3,4,3};

        for (int i : T.solution(n, info)) {
            System.out.print(i + " ");
        }
    }
}


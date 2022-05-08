package programmers.exam.kakao.intern2022.ex3_test;

import java.util.Scanner;

class Solution {
    int minCost;
    int maxAlp = 0;
    int maxCop = 0;
    int maxIncreaseAlp = 0;
    int maxIncreaseCop = 0;

    public int solution(int alp, int cop, int[][] problems) {
        setMaxAlpAndCop(problems);
        minCost = maxAlp + maxCop - (alp + cop); // 공부만 하는 경우를 초기값으로 지정

        dfs(alp, cop, 0, problems);

        return minCost;
    }

    private void dfs(int alp, int cop, int cost, int[][] problems) {
        if (cost > minCost) {
            return;
        }

        if (maxAlp <= alp && maxCop <= cop) {
            minCost = Math.min(minCost, cost);
            return;
        }

        // 코딩력이 부족하면, 코딩력 증가하는 문제와 공부 1시간
        // 알고력이 부족하면, 알고력 증가하는 문제와 공부 1시간
        // problem : 필요 알고력, 필요 코딩력, 증가 알고력, 증가 코딩력, 시간
        for (int[] p : problems) {
            if (p[0] <= alp && p[1] <= cop) {
                if (alp < maxAlp && p[2] / p[4] >= 1) { // 풀수있는 문제가 공부보다 효율적인 경우
                    dfs(alp + p[2], cop + p[3], cost + p[4], problems);
                }

                if (cop < maxCop && p[3] / p[4] >= 1) {
                    dfs(alp + p[2], cop + p[3], cost + p[4], problems);
                }
            }
        }

        if (alp + maxIncreaseAlp > maxAlp && cop + maxIncreaseCop > maxCop) {
            for (int[] p : problems) {
                if (p[0] <= alp && p[1] <= cop) {
                    if (alp < maxAlp && p[2] / p[4] >= 1) { // 풀수있는 문제가 공부보다 효율적인 경우
                        dfs(alp + p[2], cop + p[3], cost + p[4], problems);
                    }

                    if (cop < maxCop && p[3] / p[4] >= 1) {
                        dfs(alp + p[2], cop + p[3], cost + p[4], problems);
                    }
                }
            }
        } else if (alp + maxIncreaseAlp > maxAlp ){
            // 가장 효율적인 거만 하기
        } else if (cop + maxIncreaseCop > maxCop) {
            // 가장 효율적인 거만 하기

        }



        if (alp < maxAlp) {
            dfs(alp + 1, cop, cost + 1, problems);
        }

        if (cop < maxCop) {
            dfs(alp, cop + 1, cost + 1, problems);
        }

    }

    private void setMaxAlpAndCop(int[][] problems) {
        for (int[] problem : problems) {
            maxAlp = Math.max(problem[0], maxAlp);
            maxCop = Math.max(problem[1], maxCop);
            maxIncreaseAlp = Math.max(problem[2], maxIncreaseAlp);
            maxIncreaseCop = Math.max(problem[3], maxIncreaseCop);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Solution T = new Solution();
        Scanner stdIn = new Scanner(System.in);

        int alp = 10;
        int cop = 10;
        int[][] problems = {{10, 15, 2, 1, 2}, {20, 20, 3, 3, 4}};

//        int alp = 0;
//        int cop = 0;
//        int[][] problems = {{0,0,2,1,2}, {4,5,3,1,2}, {4,11,4,0,2}, {10,4,0,4,2}};
        System.out.println(T.solution(alp, cop, problems));
    }
}

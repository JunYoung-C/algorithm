package programmers.exam.kakao.intern2022.ex3;

import java.util.Scanner;

// 정확성은 모두 통과. 효율성은 모두 시간초과가 발생했다.
// 문제들이 요구하는 필요 알고력과 필요 코딩력을 모두 충족시키기위해 알고력과 코딩력을 증가시키는 최소 비용을 찾는 문제이다.
// 알고력이나 코딩력을 증가시키는 방법은 문제를 풀거나 공부 1시간당 1씩 증가시킬 수 었다.
class Solution {
    int minCost;
    int maxAlp = 0;
    int maxCop = 0;

    public int solution(int alp, int cop, int[][] problems) {
        setMaxAlpAndCop(problems); // 우선 필요 알고력과 코딩력을 파악한다.
        minCost = maxAlp + maxCop; // 가장 비효율적인 비용은 maxAlp와 maxCop를 더한 값이다. 공부만 하면 채울 수 있기 때문이다.

        // 우선순위 큐와 dp를 활용하는 방법도 있을 것 같지만, 해당 부분은 공부가 더 필요하다.
        dfs(alp, cop, 0, problems);

        return minCost;
    }

    private void dfs(int alp, int cop, int cost, int[][] problems) {
        if (cost > minCost) { // 최소 비용을 넘는 경우는 과감하게 빼버린다.
            return;
        }

        if (maxAlp <= alp && maxCop <= cop) { // 필요 알고력과 필요 코딩력을 만족시키는 경우
            minCost = Math.min(minCost, cost);
            return;
        }

        // 코딩력이 부족하면, 코딩력 증가하는 문제와 공부 1시간
        // 알고력이 부족하면, 알고력 증가하는 문제와 공부 1시간
        // problem : 필요 알고력, 필요 코딩력, 증가 알고력, 증가 코딩력, 시간

        // 매 dfs마다 문제 수만큼의 비용이 들기 때문에 시간 초과가 발생한 것 같다.
        // cost > minCost의 조건을 달아주었음에도 부족한 것 같다.
        for (int[] p : problems) {
            if (p[0] <= alp && p[1] <= cop) {
                // 풀수있는 문제가 공부보다 효율적인 경우 dfs를 실행한다.
                // (필요 알고력 / 증가 알고력)이 1보다 작으면 공부로 올리는 게 더 낫다.
                if (alp < maxAlp && p[2] / p[4] >= 1) {
                    dfs(alp + p[2], cop + p[3], cost + p[4], problems);
                }

                if (cop < maxCop && p[3] / p[4] >= 1) {
                    dfs(alp + p[2], cop + p[3], cost + p[4], problems);
                }
            }
        }

        // 문제로 알고력이나 코딩력을 올릴 수 없는 경우 공부로 올린다.
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

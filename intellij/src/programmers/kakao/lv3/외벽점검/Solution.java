package programmers.kakao.lv3.외벽점검;

import java.util.*;

class Solution {
    boolean[] isUsed;
    int answer = Integer.MAX_VALUE;

    public int solution(int n, int[] weak, int[] dist) {
        isUsed = new boolean[dist.length];
        sort(weak, n);
        dfs(dist, weak, 0, 0, n);
        if (answer == Integer.MAX_VALUE) {
            return -1;
        }
        return answer;
    }

    private void dfs(int[] dist, int[] weak, int index, int depth, int n) {

        for (int i = 0; i < dist.length; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                int nextIndex = index + 1;
                int nextDistance = (weak[index] + dist[i]) % n;

                while (nextIndex < weak.length) {
                    if (nextDistance >= weak[nextIndex]) {
                        nextIndex++;
                    } else {
                        break;
                    }
                }

                // System.out.println(index + " " + nextIndex + " " + nextDistance);
                if (nextIndex >= weak.length) {
                    answer = Math.min(answer, depth + 1);
                } else {
                    dfs(dist, weak, nextIndex, depth + 1, n);
                }

                isUsed[i] = false;
            }
        }
    }

    private void sort(int[] weak, int n) {
        int index = getStartIndex(weak, n);
        int[] tmp = new int[weak.length];

        for (int i = index; i < index + weak.length; i++) {
            tmp[i - index] = weak[i % weak.length];
        }

        for (int i = 1; i < weak.length; i++) {
            if (tmp[i] < tmp[i - 1]) {
                tmp[i] += n;
            }
        }
        int fistNum = tmp[0];
        for (int i = 0; i < weak.length; i++) {
            weak[i] = tmp[i] - fistNum;
        }
    }

    private int getStartIndex(int[] weak, int n) {
        int index = 0;
        int maxDistance = weak[0] + n - weak[weak.length - 1];
        for (int i = 1; i < weak.length; i++) {
            if (weak[i] - weak[i - 1] > maxDistance) {
                index = i;
                maxDistance = weak[i] - weak[i - 1];
            }
        }
        return index;
    }
}

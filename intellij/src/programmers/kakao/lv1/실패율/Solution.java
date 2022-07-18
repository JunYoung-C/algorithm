package programmers.kakao.lv1.실패율;

import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] tryCount = new int[N + 2];
        int[] failCount = new int[N + 2];
        for (int stage : stages) {
            failCount[stage]++;
        }

        tryCount[N + 1] = failCount[N + 1];
        for (int i = N; i >= 1; i--) {
            tryCount[i] = tryCount[i + 1] + failCount[i];
        }

        ArrayList<StageInfo> stageInfoList = new ArrayList<>();
        for (int stage = 1; stage <= N; stage++) {
            stageInfoList.add(new StageInfo(stage, (double) failCount[stage] / tryCount[stage]));
        }

        Collections.sort(stageInfoList);
        for (int i = 0; i < N; i++) {
            answer[i] = stageInfoList.get(i).number;
        }

        for (int i = 0; i <= N + 1; i++) {
            System.out.print(tryCount[i] + " ");
        }
        System.out.println("");
        for (int i = 0; i <= N + 1; i++) {
            System.out.print(failCount[i] + " ");
        }
        return answer;
    }
}

class StageInfo implements Comparable<StageInfo> {
    int number;
    double failRatio;

    public StageInfo(int number, double failRatio) {
        this.number = number;
        this.failRatio = failRatio;
    }

    @Override
    public int compareTo(StageInfo o) {
        if (o.failRatio > this.failRatio) {
            return 1;
        } else if (o.failRatio < this.failRatio){
            return -1;
        } else {
            return this.number - o.number;
        }
    }
}

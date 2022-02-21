package programmers.kakao.year2022.archerycompetition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class PointInfo implements Comparable<PointInfo> {
    int dif;
    String cntStr;

    public PointInfo(String cntStr) {
        this.cntStr = cntStr;
    }

    void calculateTotal(int[] info) {
        StringBuilder sb = new StringBuilder(cntStr);
        String[] cntStrArr = sb.reverse().toString().split("");

        // 각 카운트가 양수인 경우 라이언꺼, 음수인 경우 어피치 꺼, 0인 경우 둘다 x
        int[] filteredCntArr = new int[11];
        for (int i = 0; i < 11; i++) {
            int cnt = Integer.parseInt(cntStrArr[i]) - info[i];
            if (cnt > 0) {
                filteredCntArr[i] = 1;
            } else if (cnt < 0) {
                filteredCntArr[i] = -1;
            } else {
                if (info[i] != 0) {
                    filteredCntArr[i] = -1;
                }
            }
        }

        int lionSum = 0;
        int apeechSum = 0;
        for (int i = 0; i < 11; i++) {
            if (filteredCntArr[i] > 0) {
                lionSum += (10 - i);
            } else if (filteredCntArr[i] < 0) {
                apeechSum += (10 - i);
            }
        }
        this.dif = lionSum - apeechSum;
    }

    @Override
    public int compareTo(PointInfo o) {
        if (this.dif == o.dif) {
            return o.cntStr.compareTo(this.cntStr);
        }
        return o.dif - this.dif;
    }
}

public class Solution {
    ArrayList<PointInfo> pointInfoList = new ArrayList<>();

    public int[] solution(int n, int[] info) {
        int[] answer = new int[info.length];
        dfs(0, "", 0, n, info);

        Collections.sort(pointInfoList);

        PointInfo pointInfo = pointInfoList.get(0);

        if (pointInfo.dif <= 0) {
            return new int[]{-1};
        }
        StringBuilder sb = new StringBuilder(pointInfo.cntStr);
        String[] cntStrArr = sb.reverse().toString().split("");
        for (int i = 0; i < 11; i++) {
            answer[i] = Integer.parseInt(cntStrArr[i]);
        }
        return answer;
    }

    void dfs(int L, String cntStr, int totalCnt, int n, int[] info) {
        if (L >= 11) {
            if (totalCnt == n) {
                // cntStr이 뒤집어진 상태로 넣어짐
                PointInfo pi = new PointInfo(cntStr);
                pi.calculateTotal(info);
                pointInfoList.add(pi);
            }
        } else {
            for (int cnt = 0; cnt <= n; cnt++) {
                if (totalCnt + cnt <= n) {
                    dfs(L + 1, cnt + cntStr, totalCnt + cnt, n, info);
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        Scanner stdIn = new Scanner(System.in);

//        int n = 5;
//        int[] info = {2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0};

//        int n = 1;
//        int[] info = {1,0,0,0,0,0,0,0,0,0,0};

        int n = 9;
        int[] info = {0,0,1,2,0,1,1,1,1,1,1};

//        int n = 10;
//        int[] info = {0,0,0,0,0,0,0,0,3,4,3};

        for (int i : T.solution(n, info)) {
            System.out.print(i + " ");
        }
    }
}

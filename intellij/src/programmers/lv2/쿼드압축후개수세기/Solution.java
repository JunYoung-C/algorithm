package programmers.lv2.쿼드압축후개수세기;

class Solution {
    public int[] solution(int[][] arr) {
        return dfs(0, 0, arr.length, arr.length, arr);
    }

    private int[] dfs(int sr, int sc, int er, int ec, int[][] arr) { // 0의 개수, 1의 개수
        int zeroCount = 0;
        int oneCount = 0;
        int len = er - sr;
        for (int r = sr; r < er; r++) {
            for (int c = sc; c < ec; c++) {
                if (arr[r][c] == 0) {
                    zeroCount++;
                } else {
                    oneCount++;
                }
            }
        }

        if (zeroCount == len * len) {
            return new int[] {1, 0};
        } else if (oneCount == len * len) {
            return new int[] {0, 1};
        } else {
            int[] result1 = dfs(sr, sc, sr + len / 2, sc + len / 2, arr);
            int[] result2 = dfs(sr, sc + len / 2, sr + len / 2, ec, arr);
            int[] result3 = dfs(sr + len / 2, sc, er, sc + len / 2, arr);
            int[] result4 = dfs(sr + len / 2, sc + len / 2, er, ec, arr);

            zeroCount = result1[0] + result2[0] + result3[0] + result4[0];
            oneCount = result1[1] + result2[1] + result3[1] + result4[1];
        }

        return new int[]{zeroCount, oneCount};
    }
}
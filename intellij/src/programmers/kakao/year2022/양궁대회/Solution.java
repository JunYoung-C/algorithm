package programmers.kakao.year2022.양궁대회;

class Solution {
    int len = 11;
    int[] apeach;
    int[] answer = new int[len];
    int maxDif = 0;

    public int[] solution(int n, int[] info) {
        apeach = info;

        for (int resultBit = 0; resultBit < (1 << 10); resultBit++) {
            find(resultBit, n);
        }

        if (maxDif <= 0) {
            return new int[] {-1};
        }

        return answer;
    }

    private void find(int resultBit, int remainArrow) {
        int[] lion = new int[len];
        int pointDif = 0;

        for (int i = 0; i <= 9; i++)  {
            if (((1 << i) & resultBit) > 0) {
                lion[i] = apeach[i] + 1;
                remainArrow -= apeach[i] + 1;
                pointDif += 10 - i;
            } else if (apeach[i] != 0) {
                pointDif -= 10 - i;
            }

            if (remainArrow < 0) {
                return;
            }
        }

        if (pointDif <= 0) {
            return;
        }

        lion[len - 1] = remainArrow;

        if (maxDif < pointDif) {
            maxDif = pointDif;
            answer = lion;
        } else if (maxDif == pointDif) {
            // 서로 비교
            for (int i = len - 1; i >= 0; i--) {
                if (answer[i] < lion[i]) {
                    answer = lion;
                    break;
                } else if (answer[i] > lion[i]) {
                    break;
                }
            }
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
        int[] info = {0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3};

        for (int i : T.solution(n, info)) {
            System.out.print(i + " ");
        }
    }
}
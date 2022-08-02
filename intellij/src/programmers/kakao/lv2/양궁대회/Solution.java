package programmers.kakao.lv2.양궁대회;

class Solution {
    String bestMethod = "";
    int maxDif = Integer.MIN_VALUE;
    public int[] solution(int n, int[] info) {
        dfs(n, 0, 0, "", info);
        System.out.println(bestMethod + " " + maxDif);
        if (maxDif <= 0) {
            return new int[] {-1};
        }

        int[] answer = new int[11];
        for (int i = 0; i < bestMethod.length(); i++) {
            answer[i] = bestMethod.charAt(i) - '0';
        }

        return answer;
    }

    private void dfs(int n, int count, int depth, String method, int[] info) {
        if (method.length() >= 12) {
            return;
        }

        if (count == n) {
            // method와 info를 비교하고 bestMethod에 넣을지 판별
            int dif = getDifference(method, info);
            if (dif > maxDif) {
                maxDif = dif;
                bestMethod = method;
            } else if (dif == maxDif) {
                if (bestMethod.length() == method.length()) {
                    if (bestMethod.compareTo(method) >= 1) {
                        bestMethod = method;
                    }
                } else if (bestMethod.length() < method.length()) {
                    bestMethod = method;
                }
            }

            return;
        }

        for (int hitCount = 0; hitCount <= n - count; hitCount++) {
            dfs(n, count + hitCount, depth + 1, method + hitCount, info);
        }
    }

    private int getDifference(String method, int[] info) {
        int lionPoint = 0;
        int apeechPoint = 0;
        int i = 0;
        for (; i < method.length(); i++) {
            if (method.charAt(i) == '0' && info[i] == 0) {
                continue;
            }

            if (method.charAt(i) - '0' > info[i]) {
                lionPoint += 10 - i;
            } else {
                apeechPoint += 10 - i;
            }
        }

        for (; i < info.length; i++) {
            if (info[i] == 0) {
                continue;
            }

            apeechPoint += 10 - i;
        }

        return lionPoint - apeechPoint;
    }
}

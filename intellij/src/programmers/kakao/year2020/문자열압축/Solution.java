package programmers.kakao.year2020.문자열압축;

class Solution {
    public int solution(String s) {
        int answer = s.length();

        for (int cutCount = 1; cutCount <= s.length() / 2; cutCount++) {
            answer = Math.min(getCompressedStrLen(s, cutCount), answer);
        }

        return answer;
    }

    private int getCompressedStrLen(String s, int cutCount) {
        int len = s.length();
        int i = 0;
        String prev = "";
        int sameCount = 1;
        StringBuilder sb = new StringBuilder();

        for (; i + cutCount <= len; i += cutCount) {
            String current = s.substring(i, i + cutCount);
            if (prev.length() == 0) {
                prev = current;
                continue;
            }

            if (current.equals(prev)) {
                sameCount++;
            } else {
                if (sameCount > 1) {
                    sb.append(sameCount);
                }
                sb.append(prev);

                sameCount = 1;
                prev = current;
            }
        }

        if (sameCount > 1) {
            sb.append(sameCount);
        }
        sb.append(prev);

        if (i < len) {
            sb.append(s.substring(i));
        }

        return sb.length();
    }

    public static void main(String[] args) {
        Solution T = new Solution();

//        String s = "aabbaccc";
//        String s = "ababcdcdababcdcd";
//        String s = "abcabcdede";
//        String s = "abcabcabcabcdededededede";
        String s = "xababcdcdababcdcd";
        System.out.println(T.solution(s));
    }
}

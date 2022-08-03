package programmers.kakao.lv2.문자열압축;

class Solution {
    public int solution(String s) {
        int answer = s.length();
        int len = answer;
        StringBuilder sb = new StringBuilder();
        System.out.println("s".startsWith(" "));
        for(int cut = 1; cut <= len / 2; cut++) {
            String currentString = "";
            int count = 1;
            for (int i = 0; i < len; i += cut) {
                if (i + cut > len) {
                    sb.append(s.substring(i));
                    continue;
                }

                currentString = s.substring(i, i + cut);
                // System.out.print(currentString + " ");
                if (s.substring(i + cut).startsWith(currentString)) {
                    count++;
                } else {
                    if (count > 1) {
                        sb.append(count + currentString);
                    } else {
                        sb.append(currentString);
                    }

                    count = 1;
                }
            }
            answer = Math.min(answer, sb.length());
            sb.setLength(0);
        }
        return answer;
    }
}

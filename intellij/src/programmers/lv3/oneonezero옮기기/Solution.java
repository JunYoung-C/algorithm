package programmers.lv3.oneonezero옮기기;

class Solution {
    public String[] solution(String[] s) {
        int len = s.length;
        String[] answer = new String[len];

        for (int i = 0; i < len; i++) {
            StringBuilder sb = new StringBuilder();
            int count = 0;
            for (char c : s[i].toCharArray()) {
                if (c == '0' && sb.length() >= 2
                        && sb.substring(sb.length() - 2).equals("11")) {
                    sb.delete(sb.length() - 2, sb.length());
                    count++;
                } else {
                    sb.append(c);
                }
            }
            String oneOneZero = getOneOneZeroString(count);
            int index = sb.lastIndexOf("0");

            if (index == -1) {
                answer[i] = oneOneZero + sb.toString();
            } else {
                sb.insert(index + 1, oneOneZero);
                answer[i] = sb.toString();
            }
        }

        return answer;
    }

    private String getOneOneZeroString(int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append("110");
        }
        return sb.toString();
    }
}
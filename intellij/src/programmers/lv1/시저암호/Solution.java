package programmers.lv1.시저암호;

class Solution {
    public String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();
        System.out.println((char)(0 + 'a'));
        System.out.println((char)(25 + 'a'));

        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                if (c + n > 'Z') {
                    answer.append((char)(c + n - 'Z' - 1 + 'A'));
                } else {
                    answer.append((char)(c + n));
                }
            } else if (Character.isLowerCase(c)) {
                if (c + n > 'z') {
                    answer.append((char)(c + n - 'z' - 1 + 'a'));
                } else {
                    answer.append((char)(c + n));
                }
            } else {
                answer.append(c);
            }
        }

        return answer.toString();
    }
}

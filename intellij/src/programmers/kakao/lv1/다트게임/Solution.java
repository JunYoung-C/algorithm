package programmers.kakao.lv1.다트게임;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        // System.out.println((int)Math.pow(2, 3));
        int[] points = new int[4];
        int index = 0;
        char prevChar = ' ';
        for (char c : dartResult.toCharArray()) {
            if (Character.isDigit(c)) {
                if (Character.isDigit(prevChar)) {
                    points[index] = 10;
                } else {
                    index++;
                    // System.out.println(index);
                    points[index] = c - '0';
                }
            } else if (c == 'D') {
                points[index] *= points[index];
            } else if (c == 'T') {
                points[index] = (int) Math.pow(points[index], 3);
            } else if (c == '*') {
                points[index - 1] *= 2;
                points[index] *= 2;
            } else if (c == '#') {
                points[index] *= -1;
            }
            prevChar = c;
        }

        for (int point : points) {
            answer += point;
        }
        return answer;
    }
}

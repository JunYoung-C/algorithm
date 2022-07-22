package programmers.lv2.카펫;

class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;
        int height = 3;
        int width = 0;
        for (; height <= (int) Math.sqrt(total); height++) {
            if (total % height == 0) {
                width = total / height;
                if ((width - 2) * (height - 2) == yellow) {
                    break;
                }
            }
        }

        return new int[] {width, height};
    }
}

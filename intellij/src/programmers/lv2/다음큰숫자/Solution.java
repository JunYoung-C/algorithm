package programmers.lv2.다음큰숫자;

class Solution {
    public int solution(int n) {
        int count = getOneCount(Integer.toString(n, 2));
        while (true) {
            if (count == getOneCount(Integer.toString(++n, 2))) {
                return n;
            }
        }
    }

    private int getOneCount(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == '1') {
                count++;
            }
        }

        return count;
    }
}
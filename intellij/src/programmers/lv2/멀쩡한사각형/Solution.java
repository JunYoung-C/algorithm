package programmers.lv2.멀쩡한사각형;

class Solution {
    public long solution(int w, int h) {
        long answer = (long)w * h;
        int gcd = gcd(w, h);
        System.out.println(gcd);
        w /= gcd;
        h /= gcd;
        answer -= (long)(w + h - 1) * gcd;

        return answer;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
}

package programmers.heap.lv1.gcdlcm;

class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int gcd = gcd(n, m);
        answer[0] = gcd;
        answer[1] = n * m / gcd;
        return answer;
    }

    private int gcd(int big, int small) {
        if (small == 0) {
            return big;
        }

        return gcd(small, big % small);
    }
}

package programmers.lv1.진법3뒤집기;

class Solution {
    public int solution(int n) {
        StringBuilder sb = new StringBuilder(Integer.toString(n, 3));
        return Integer.parseInt(sb.reverse().toString(), 3);
    }
}

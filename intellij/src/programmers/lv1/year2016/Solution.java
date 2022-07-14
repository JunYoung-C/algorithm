package programmers.lv1.year2016;

class Solution {
    public String solution(int a, int b) {
        String[] weeks = new String[] {"THU","FRI","SAT","SUN","MON","TUE","WED"};
        int[] days = new int[] {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int sum = b;
        for (int i = 0; i <= a - 1; i++) {
            sum += days[i];
        }

        return weeks[sum % 7];
    }
}

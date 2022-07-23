package programmers.lv2.최댓값과최솟값;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] numbers = s.split(" ");
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        for (String string : numbers) {
            long number = Long.parseLong(string);
            if (number > max) {
                max = number;
            }
            if (number < min) {
                min = number;
            }
        }
        return min + " " + max;
    }
}

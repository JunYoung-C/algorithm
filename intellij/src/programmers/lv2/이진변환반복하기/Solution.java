package programmers.lv2.이진변환반복하기;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int convertedCount = 0;
        int removedCount = 0;
        int bitCount = 0;
        while (!s.equals("1")) {
            bitCount = getBitCount(s);
            convertedCount++;
            removedCount += s.length() - bitCount;
            s = Integer.toString(bitCount, 2);
        }
        answer[0] = convertedCount;
        answer[1] = removedCount;
        return answer;
    }

    private int getBitCount(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }
}

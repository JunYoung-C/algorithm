package programmers.kakao.lv1.숫자문자열과영단어;

import java.util.*;
class Solution {
    public int solution(String s) {
        StringBuilder answer = new StringBuilder();
        StringBuilder numberMaker = new StringBuilder();
        HashMap<String, Integer> numberMap = new HashMap<>();

        numberMap.put("zero", 0);
        numberMap.put("one", 1);
        numberMap.put("two", 2);
        numberMap.put("three", 3);
        numberMap.put("four", 4);
        numberMap.put("five", 5);
        numberMap.put("six", 6);
        numberMap.put("seven", 7);
        numberMap.put("eight", 8);
        numberMap.put("nine", 9);

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                // 그냥 푸시
                answer.append(c);
            } else {
                // 문자 누적. 누적 문자가 숫자와 같으면 푸시 후 초기화
                numberMaker.append(c);
                if (numberMap.containsKey(numberMaker.toString())) {
                    answer.append(numberMap.get(numberMaker.toString()));
                    numberMaker.setLength(0);
                }
            }
        }
        return Integer.parseInt(answer.toString());
    }
}

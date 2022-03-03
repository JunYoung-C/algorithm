package programmers.exam.kakao.intern2021.numstrandeng;

import javax.xml.stream.events.Characters;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution {
    public int solution(String s) {
        StringBuilder answer = new StringBuilder();
        int len = s.length();
        String[] numStrArr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
//        Map<String, Integer> numStrMap = new HashMap<>();
//        for (int i = 0; i < 10; i++) {
//            numStrMap.put(numStrArr[i], i);
//        }

        for (char c : s.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                Character.toLowerCase(c);
            }
        }

        for (int i = 0; i < 10; i++) {
            s = s.replace(numStrArr[i], String.valueOf(i));
        }
//        int lt = 0, rt = 0;
//        for (; rt < len; rt++) {
//            if (Character.isDigit(s.charAt(rt))) {
//                answer.append(s.charAt(rt));
//                lt = rt + 1;
//                continue;
//            }
//
//            String str = s.substring(lt, rt + 1);
//            for (String numStr : numStrArr) {
//                if (numStr.equals(str)) {
//                    answer.append(numStrMap.get(str));
//                    lt = rt + 1;
//                    break;
//                }
//            }
//        }


//        return Integer.parseInt(answer.toString());
        return Integer.parseInt(s);
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        Scanner stdIn = new Scanner(System.in);

//        String s = "one4seveneight";
//        String s = "23four5six7";
//        String s = "2three45sixseven";
//        String s = "123";
        String s = "onetwothreefourfivesixseveneightninezero";
        System.out.println(T.solution(s));
    }
}

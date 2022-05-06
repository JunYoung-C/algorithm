package programmers.exam.kakao.intern2021.numstringeng;

import java.util.HashMap;
import java.util.Scanner;

class Solution {
    public int solution(String s) {
        StringBuilder result = new StringBuilder();
        StringBuilder chars = new StringBuilder();
        HashMap<String, Integer> map = new HashMap<>();
        initMap(map);

        for (char c : s.toCharArray()) {
            if (map.containsKey(chars.toString())) {
                result.append(map.get(chars.toString()));
                chars.setLength(0);
            }

            if (Character.isDigit(c)) {
                result.append(c);
            } else {
                chars.append(c);
            }
        }

        if (map.containsKey(chars.toString())) {
            result.append(map.get(chars.toString()));
            chars.setLength(0);
        }

        return Integer.parseInt(result.toString());
    }

    private void initMap(HashMap<String, Integer> map) {
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        Scanner stdIn = new Scanner(System.in);

//        String s = "one4seveneight";
//        String s = "23four5six7";
//        String s = "2three45sixseven";
        String s = "123";
        System.out.println(T.solution(s));
    }
}


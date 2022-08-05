package programmers.kakao.lv2.압축;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Solution {
    public int[] solution(String msg) {
        int[] answer = {};
        int len = msg.length();
        int lt = 0, rt = 0;

        HashMap<String, Integer> dictionary = createDictionary();
        ArrayList<Integer> indexList = new ArrayList<>();
        String prevStr = "";
        while (rt < len) {
            String str = msg.substring(lt, rt + 1);

            while (dictionary.containsKey(str)) {
                rt++;
                if (rt >= len) {
                    break;
                }
                prevStr = str;
                str = msg.substring(lt, rt + 1);
            }

            if (rt < len) {
                indexList.add(dictionary.get(prevStr));
                dictionary.put(str, dictionary.size() + 1);
                lt = rt;
            } else {
                indexList.add(dictionary.get(str));
            }
        }

        len = indexList.size();
        answer = new int[len];
        for (int i = 0; i < len; i++) {
            answer[i] = indexList.get(i);
        }

        return answer;
    }

    private static HashMap<String, Integer> createDictionary() {
        HashMap<String, Integer> dictionary = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            dictionary.put(String.valueOf((char) (i + 'A')), i + 1);
        }
        return dictionary;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        Scanner stdIn = new Scanner(System.in);

        String msg = "KAKAO";
//        String msg = "TOBEORNOTTOBEORTOBEORNOT";
//        String msg = "ABABABABABABABAB";
        System.out.println("hello".substring(0, 1));
        System.out.println(T.solution(msg));
    }
}

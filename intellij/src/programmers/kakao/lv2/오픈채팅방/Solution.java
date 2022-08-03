package programmers.kakao.lv2.오픈채팅방;

import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> userMap = new HashMap<>();
        int inOutCount = 0;
        for (String s : record) {
            String[] sArr = s.split(" ");

            if (sArr.length == 3) {
                userMap.put(sArr[1], sArr[2]);
            }

            if (!sArr[0].equals("Change")) {
                inOutCount++;
            }
        }

        String[] answer = new String[inOutCount];
        int index = 0;
        for (String s : record) {
            String[] sArr = s.split(" ");
            String command = sArr[0];
            String userId = sArr[1];

            if (command.equals("Enter")) {
                answer[index++] = userMap.get(userId) + "님이 들어왔습니다.";
            } else if (command.equals("Leave")) {
                answer[index++] = userMap.get(userId) + "님이 나갔습니다.";
            }
        }

        return answer;
    }
}
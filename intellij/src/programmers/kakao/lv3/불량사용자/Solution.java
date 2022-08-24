package programmers.kakao.lv3.불량사용자;

import java.util.*;

class Solution {
    HashSet<Integer> possibleIds = new HashSet<>();
    HashMap<String, ArrayList<Integer>> bannedIdMap = new HashMap<>();

    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;

        init(bannedIdMap, user_id, banned_id);

        dfs(0, banned_id, 0);

        // for (String id : bannedIdMap.keySet()) {
        //     System.out.print(id + " ");
        //     for (int i : bannedIdMap.get(id)) {
        //         System.out.print(user_id[i] + " ");
        //     }
        //     System.out.println();
        // }

        return possibleIds.size();
    }

    private void dfs(int depth, String[] banned_id, int bitRecord) {
        if (depth == banned_id.length) {
            possibleIds.add(bitRecord);
            return;
        }

        for (int index : bannedIdMap.get(banned_id[depth])) {
            if ((bitRecord & (1 << index)) == 0) {
                dfs(depth + 1, banned_id, bitRecord | (1 << index));
            }
        }
    }

    private void init(HashMap<String, ArrayList<Integer>> bannedIdMap, String[] user_id, String[] banned_id) {
        for (String id : banned_id) {
            if (!bannedIdMap.containsKey(id)) {
                bannedIdMap.put(id, new ArrayList<>());
            }
        }

        for (int i = 0; i < user_id.length; i++) {
            String userId = user_id[i];
            for (String bannedId : bannedIdMap.keySet()) {
                if (isSame(userId, bannedId)) {
                    bannedIdMap.get(bannedId).add(i);
                }
            }
        }
    }

    private boolean isSame(String id, String encodedId) {
        int len = id.length();
        if (len != encodedId.length()) {
            return false;
        }

        for (int i = 0; i < len; i++) {
            if (encodedId.charAt(i) == '*') {
                continue;
            }
            if (encodedId.charAt(i) != id.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}

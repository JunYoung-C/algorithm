package getmiddlechar;

import java.util.ArrayList;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer;
        int len = arr.length;
        ArrayList<Integer> filteredArr = new ArrayList<>();
        filteredArr.add(arr[0]);
        for (int i = 1; i < len; i++) {
          if (arr[i] != arr[i-1]) filteredArr.add(arr[i]);
        }
        answer= new int[filteredArr.size()];
        for (int i = 0; i < filteredArr.size(); i++) {
          answer[i] = filteredArr.get(i);
        }
        return answer;
    }
}

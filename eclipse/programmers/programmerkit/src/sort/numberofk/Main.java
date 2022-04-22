package sort.numberofk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Solution {
  public int[] solution(int[] array, int[][] commands) {
    int len = commands.length;
    int[] answer = new int[len];
    ArrayList<Integer> arrList;
    for (int i = 0; i < len; i++) {
      arrList = new ArrayList<>();
      for (int j = commands[i][0] - 1; j < commands[i][1]; j++) {
        arrList.add(array[j]);
      }
      Collections.sort(arrList);
      answer[i] = arrList.get(commands[i][2] - 1);
    }
    return answer;
  }
}


public class Main {
  public static void main(String[] args) {
    Solution T = new Solution();
    Scanner stdIn = new Scanner(System.in);

    int[] arr = {1, 5, 2, 6, 3, 7, 4};
    int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
    for (int i : T.solution(arr, commands)) {
      System.out.print(i + " ");
    }
  }
}

